package com.inter_chat.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inter_chat.Inter_Chat_Backend.dao.FriendDAO;

public class FriendDAOTest 
{
static FriendDAO friendDAO;
	
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.inter_chat.Inter_Chat_Backend");
		context.refresh();
		friendDAO = (FriendDAO) context.getBean("friendDAO");
	}
	

}