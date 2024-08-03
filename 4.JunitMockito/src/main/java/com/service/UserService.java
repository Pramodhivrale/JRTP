package com.service;

import com.data.DAO;

public class UserService 
{
	private DAO dao;
	
	public UserService() {
		
	}
	
	public UserService(DAO mock2) {
		this.dao=mock2;
	}
	
	public String findNameById(Integer id) {
		String nameById = dao.findNameById(id);
		return nameById;
	}
	
	public String findEmailById(Integer id) {
		String emailbyId = dao.findEmailbyId(id);
		return emailbyId;
	}
	
	public void doProcess()  {
		System.out.println("doProcess started !");
		pushMsgtoKafka("msg");
		System.out.println("doProcess ended !");
		
		
	}
	
	public void pushMsgtoKafka(String msg) {
		System.out.println("Msg pushing to kafka  ..!");
	}
	
	public String doWork(String msg) {
		String formatMsg = formatMsg(msg);
		return formatMsg;
	}
	
	private String formatMsg(String msg) {
		return msg.toUpperCase();
	}

}
