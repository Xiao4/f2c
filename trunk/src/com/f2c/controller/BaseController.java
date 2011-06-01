package com.f2c.controller;

import java.util.HashMap;
import java.util.Map;

import com.f2c.utils.Setting;

public class BaseController  {
	private static final long serialVersionUID = 1L;
	public static final String FACEBOOK_API_ID = Setting.FACEBOOK_API_ID;
	public static final String FACEBOOK_API_KEY = Setting.FACEBOOK_API_KEY;
	public static final String FACEBOOK_SECRET_KEY = Setting.FACEBOOK_SECRET_KEY;
	public static Map<String, Object> fbUserMap = new HashMap<String, Object>();
	

}
