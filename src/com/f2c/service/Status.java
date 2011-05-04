package com.f2c.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSON;
import com.f2c.Reg;
@Path("/status")
public class Status {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getReg(){
		Reg reg = new Reg();
		return JSON.toJSONString(reg);
	}
	
	
	@POST
	@Consumes({"application/json"})
	public String setReg(Reg reg) {
		return JSON.toJSONString(reg);
	}
}
