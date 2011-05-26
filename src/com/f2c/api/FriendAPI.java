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
 * 好友相关JSON接口
 * @author lihuan
 *
 */
@Controller
@RequestMapping("/f")
public class FriendAPI extends BaseAPI {

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
	
	/**
	 * 删除好友
	 * 测试地址：http://localhost:8080/f2c/f/delete.json?f_id=
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		String fId = request.getParameter("f_id");
		if (user == null) {
			return createResults(ResultsUtil.USER_LOGIN_FAILURE);
		}
		if (fId == null) {
			return createResults(ResultsUtil.PARAMETER_FRIENDID_REQUIRE);
		}
		try {
			boolean success = friendService.deleteByID(fId);
			if (success) {
				return createResults(ResultsUtil.SUCCESS);
			} else {
				return createResults(ResultsUtil.FAILED);
			}
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			return createResults(ResultsUtil.DATABASE_ERROR, e.getMessage());
		}
	}

	
	/**
	 * 修改好友信息
	 * 测试地址：http://localhost:8080/f2c/f/delete.json?f_id=xxxxxxxxxx&f_name=xxxxxxxxxxxxx
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public Map<String, Object> update(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		String fId = request.getParameter("f_id");
		String fName = request.getParameter("f_name");
		if (user == null) {
			return createResults(ResultsUtil.USER_LOGIN_FAILURE);
		}
		if (fId == null) {
			return createResults(ResultsUtil.PARAMETER_FRIENDID_REQUIRE);
		}
		try {
			Friend friend = this.friendService.getFriendByID(fId);
			if (friend != null) {
				friend.setNickname(fName);
				boolean success = this.friendService.update(friend);
				if (success) {
					return createResults(ResultsUtil.SUCCESS);
				} else {
					return createResults(ResultsUtil.FAILED);
				}
			} else {
				return createResults(ResultsUtil.FAILED);
			}
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			return createResults(ResultsUtil.DATABASE_ERROR, e.getMessage());
		}
	}
}
