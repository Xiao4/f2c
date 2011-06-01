package com.f2c.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.f2c.entity.Friend;
import com.f2c.entity.User;
import com.f2c.service.FriendService;
import com.f2c.service.UserService;

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
			if (session.getAttribute("fb_userinfo") != null) {
				JSONObject fbUserinfo = (JSONObject) session.getAttribute("fb_userinfo");
				String facebookUID = fbUserinfo.getString("user_id");
				user = userService.getUser(facebookUID);
				if (user == null) {
					user = userService.register(facebookUID);
				}
				session.setAttribute("loginUser", user);
			} else if (request.getParameter("facebook_uid") != null) {
				String facebookUID = request.getParameter("facebook_uid");
				user = userService.getUser(facebookUID);
				if (user == null) {
					user = userService.register(facebookUID);
				}
				session.setAttribute("loginUser", user);
			}
			logger.debug("当然登录用户:" + JSON.toJSONString(user));
			List<Friend> friendList =  friendService.getFriendListByUID(user.getId());
			model.put("friendList", friendList);
			logger.debug("当然登录用户的好友列表:" + JSON.toJSONString(friendList));
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
		}
		return new ModelAndView("index", model);
	}
}
