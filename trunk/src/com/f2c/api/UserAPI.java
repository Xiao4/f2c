package com.f2c.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.f2c.entity.User;
import com.f2c.service.UserService;
import com.f2c.utils.ResultsUtil;

/**
 *  
 * 用户相关JSON接口
 * @author lihuan
 *
 */
@Controller
@RequestMapping("/u")
public class UserAPI extends BaseAPI {

	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserService userService;
	
	/**
	 * 修改个人信息
	 * 测试地址：http://localhost:8080/f2c/u/update.json?nickname=LiHuan&nickname_switch=1
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/update")
	public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		String nickname = request.getParameter("nickname");
		int nicknameSwitch = -1;
		if (user == null) {
			return createResults(ResultsUtil.USER_LOGIN_FAILURE);
		}
		if (request.getParameter("nickname_switch") != null) {
			nicknameSwitch = parseInt(request.getParameter("nickname_switch"));
		}
		if (nickname != null) {
			user.setNickname(nickname);
		}
		if (nicknameSwitch == 0) {
			user.setNicknameSwitch(false);
		} else if(nicknameSwitch == 1) {
			user.setNicknameSwitch(true);
		}
		try {
			user = this.userService.update(user);
			if (user != null) {
				session.setAttribute("loginUser", user);
				return createResults(ResultsUtil.SUCCESS, user);
			} else {
				user = (User) session.getAttribute("loginUser");
				return createResults(ResultsUtil.FAILED, user);
			}
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			return createResults(ResultsUtil.DATABASE_ERROR, e.getMessage());
		}
	}
}
