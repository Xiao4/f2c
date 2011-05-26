package com.f2c.api;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.f2c.entity.Friend;
import com.f2c.entity.User;
import com.f2c.service.FriendService;
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
	private FriendService friendService;
	
	/**
	 * 添加好友
	 * 测试地址：http://localhost:8080/f2c/f/add.json?mobile=13810554162&nickname=Li Huan
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/add")
	public Map<String, Object> add(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		String mobile = request.getParameter("mobile");
		String nickname = request.getParameter("nickname");
		if (user == null) {
			return createResults(ResultsUtil.USER_LOGIN_FAILURE);
		}
		if (mobile == null) {
			return createResults(ResultsUtil.PARAMETER_MOBILE_REQUIRE);
		}
		if (nickname == null) {
			return createResults(ResultsUtil.PARAMETER_NICKNAME_REQUIRE);
		}
		List<Friend> friendList = friendService.getFriendByMobile(user.getId(), mobile);
		if (friendList != null && friendList.size() > 0) {
			return createResults(ResultsUtil.FRIEND_ALREAY_EXISTS, friendList.get(0));
		}
		try {
			Friend friend = friendService.add(user, mobile, nickname);
			return createResults(ResultsUtil.SUCCESS, friend);
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			return createResults(ResultsUtil.DATABASE_ERROR, e.getMessage());
		}
	}
	
}
