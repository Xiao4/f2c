package com.f2c.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType; 
import com.f2c.entity.Message;

import com.f2c.entity.ResponseBody;
import com.sun.grizzly.tcp.Response;
@Path("/status")
public class MessageService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody getMessages(){
		ResponseBody rb = new ResponseBody();
		Message message = new Message();
		Message[] mList = new Message[]{message,message,message,message};
		rb.setData(mList);
		return rb;
	}
	
	@Path("/{id}/{sort}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBody getMessages(String id,String sort){
		ResponseBody rb = new ResponseBody();
		Message message = new Message();
		message.setId(id);
		Message[] mList = new Message[]{message};
		rb.setData(mList);
		return rb;
	}
	
	@POST
	@Consumes({"application/json"})
	public ResponseBody createMessage(Message message) {
		ResponseBody rb = new ResponseBody();
		return rb;
	}
}
