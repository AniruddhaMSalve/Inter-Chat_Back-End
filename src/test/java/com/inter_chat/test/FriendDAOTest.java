package com.inter_chat.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inter_chat.Inter_Chat_Backend.dao.FriendDAO;
import com.inter_chat.Inter_Chat_Backend.model.Friend;

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
	
	@Ignore
	@Test
	public void addForumTest()
	{
		Friend friend=new Friend();
		friend.setFriendLoginName("test");
		friend.setLoginName("test");
		friend.setStatus("test");
		assertTrue("Problem in adding friend:", friendDAO.addFriend(friend));
	}
	
	@Ignore
	@Test
	public void deleteFriendTest()
	{
		Friend friend=friendDAO.getFriend(951);
		assertTrue("Problem in deleting friend:", friendDAO.deleteFriend(friend));
	}
	
	@Ignore
	@Test
	public void updateFriendTest()
	{
		Friend friend=friendDAO.getFriend(952);
		friend.setLoginName("test passed");
		friend.setFriendLoginName("test passed");
		friend.setStatus("passed");
		assertTrue("Problem in updating friend:", friendDAO.updateFriend(friend));
	}

//	@Ignore
	@Test
	public void listFriendTest() 
	{
		List<Friend> listFriend = friendDAO.listFriend();
		assertTrue("Problem in listing friends:",listFriend.size()>0);
		for (Friend friend : listFriend) 
		{
			System.out.println(friend.getLoginName() + ": "+friend.getFriendLoginName());
		}
	}
}