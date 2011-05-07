package com.f2c.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.f2c.Reg;
@Path("/status")
public class Status {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Reg getReg(){
		Reg reg = new Reg();
		return reg;
	}
	
	
	@POST
	@Consumes({"application/json"})
	public Reg setReg(Reg reg) {
		return reg;
	}
}
