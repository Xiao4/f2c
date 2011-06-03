package com.f2c.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.xwork.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.f2c.entity.Friend;
import com.f2c.entity.Message;
import com.f2c.entity.User;
import com.f2c.service.FriendService;
import com.f2c.service.MessageService;
import com.f2c.service.UserService;
import com.f2c.utils.FacebookUtil;

/**
 * 
 * 主页Servlet
 * 
 * @author lihuan
 * 
 */
@Controller
public class IndexController extends BaseController {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserService userService;
	@Autowired
	private FriendService friendService;
	@Autowired
	private MessageService messageService;


	/**
	 * 主页
	 * 测试地址：http://localhost:8888/f2c/index.action?facebook_uid=1234567
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws Exception
	 */
	@RequestMapping(value = "/index")
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			HttpSession session = request.getSession();
			User user = null;
			if (StringUtils.isNotEmpty(request.getParameter("facebook_uid"))) {
				String facebookUID = request.getParameter("facebook_uid");
				user = userService.getUser(facebookUID);
				if (user == null) {
					session.setAttribute("facebook_uid", facebookUID);
					return new ModelAndView("welcome", model);
				}
				session.setAttribute("loginUser", user);
			} else if(StringUtils.isNotEmpty(request.getParameter("signed_request"))) {
				String signedRequest = request.getParameter("signed_request");
				JSONObject fbUserinfo = FacebookUtil.parseSignedRequest(signedRequest, FACEBOOK_SECRET_KEY);
//				JSONObject fbUserinfo = FacebookUtil.parseSignedRequest(signedRequest, "9413a14daea1b773ab8a44dafbecb7fe");
				if (fbUserinfo == null) {
					throw new RuntimeException("facebook secret key error");
				}
				session.setAttribute("fb_userinfo", fbUserinfo);
				String oauthToken = fbUserinfo.getString("oauth_token");
				String sessionKey = oauthToken.split("\\|")[1];
				String facebookUID = fbUserinfo.getString("user_id");
				if (facebookUID == null) {
					response.setStatus(404);
					return null;
				}
				user = userService.getUser(facebookUID);
				if (user == null) {
					return new ModelAndView("welcome", model);
				} else {
					session.setAttribute("loginUser", user);
				}
			} else {
				response.setStatus(404);
				return null;
			}
			session.setAttribute("facebook_api_id", FACEBOOK_API_ID);
			logger.debug("当然登录用户:" + JSON.toJSONString(user));
			List<Friend> friendList =  friendService.getFriendListByUID(user.getId());
			model.put("friendList", friendList);
			model.put("friendListJson", JSON.toJSONString(friendList));
			logger.debug("当然登录用户的好友列表:" + JSON.toJSONString(friendList));
			List<Message> robotMessage = messageService.getRobotMessage(user.getId());
			if (robotMessage == null || robotMessage.size() < 0) {
				messageService.pushRobotMessage(user.getId(), MessageService.content.get(0));
			}
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
		}
		return new ModelAndView("index", model);
	}
}
