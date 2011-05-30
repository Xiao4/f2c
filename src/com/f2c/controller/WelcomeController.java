package com.f2c.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.f2c.service.UserService;
import com.f2c.utils.FacebookUtil;

/**
 * 
 * 欢迎页
 * 
 * @author lihuan
 * 
 */
@Controller
public class WelcomeController extends BaseController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@RequestMapping(value = "/welcome")
	public ModelAndView init(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String signedRequest = request.getParameter("signed_request");
			JSONObject fbUserinfo = FacebookUtil.parseSignedRequest(signedRequest, SECRET_KEY);
			session.setAttribute("fb_userinfo", fbUserinfo);
			if (fbUserinfo != null) {
				String oauthToken = fbUserinfo.getString("oauth_token");
				String sessionKey = oauthToken.split("\\|")[1];
			}
			if (logger.isDebugEnabled()) {
				logger.debug("signed_request：" + fbUserinfo);
			}
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
		}
		return new ModelAndView("welcome");
	}

}
