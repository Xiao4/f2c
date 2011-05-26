package com.f2c.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.f2c.entity.Friend;
import com.f2c.entity.User;
import com.f2c.service.FriendService;
import com.f2c.service.UserService;
import com.f2c.utils.OpenPlatform;
import com.f2c.utils.ResultsUtil;

/**
 *  
 * 消息相关JSON接口
 * @author lihuan
 *
 */
@Controller
@RequestMapping("/msg")
public class MessageAPI extends BaseAPI {

	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private FriendService friendService;
	
	/**
	 * 发送私聊信息
	 * 测试地址：http://localhost:8888/f2c/msg/send.json?friend_id=dc64fd98-f443-4e20-8438-5634bb0a81b0&text=123123
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/send")
	public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		String friendID = request.getParameter("friend_id");
		String text = request.getParameter("text");
		if (user == null) {
			return createResults(ResultsUtil.USER_LOGIN_FAILURE);
		}
		if (friendID == null) {
			return createResults(ResultsUtil.PARAMETER_FRIENDUID_REQUIRE);
		}
		if (text == null) {
			return createResults(ResultsUtil.PARAMETER_TEXT_REQUIRE);
		}
		Friend friend = this.friendService.getFriendByID(friendID);
		if (logger.isDebugEnabled()) {
			logger.debug("用户" + JSON.toJSONString(user) + "发送[" + text + "]给联系人" + JSON.toJSONString(friend));
		}
		JSONObject returnText = OpenPlatform.directMessagesAdd(Integer.valueOf(user.getMobileUID()), Integer.valueOf(friend.getMobileUID()), text);
		return createResults(ResultsUtil.SUCCESS, returnText.toString());
	}
	
	/**
	 * 获取私聊信息
	 * 测试地址：http://localhost:8888/f2c/msg/send.json?friend_id=dc64fd98-f443-4e20-8438-5634bb0a81b0&text=123123
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/get")
	public Map<String, Object> get(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		String friendID = request.getParameter("friend_id");
		Integer maxId = null;
		Integer count = null;
		if (request.getParameter("max_id") != null) {
			maxId = Integer.valueOf(request.getParameter("max_id"));
		}
		if (request.getParameter("count") != null) {
			count = Integer.valueOf(request.getParameter("count"));
		}
		if (user == null) {
			return createResults(ResultsUtil.USER_LOGIN_FAILURE);
		}
		if (friendID == null) {
			return createResults(ResultsUtil.PARAMETER_FRIENDUID_REQUIRE);
		}
		Friend friend = this.friendService.getFriendByID(friendID);
		if (logger.isDebugEnabled()) {
			logger.debug("用户" + JSON.toJSONString(user) + "获取与用户" + JSON.toJSONString(friend) + "的私聊信息" );
		}
		try {
			JSONArray returnArry = OpenPlatform.directMessagesDialog(Integer.valueOf(user.getMobileUID()), Integer.valueOf(friend.getMobileUID()), maxId, count);
			return createResults(ResultsUtil.SUCCESS, returnArry.toString());
		} catch (RuntimeException e) {
			return createResults(ResultsUtil.FAILED);
		}
	}
}
