<%@page import="com.alibaba.fastjson.JSON"%>
<%@page import="com.f2c.Reg"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
com.f2c.Reg reg = new Reg();
reg.setNickname("yangfan");
out.print(com.alibaba.fastjson.JSON.toJSONString(reg));
%>