package com.inter_chat.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inter_chat.Inter_Chat_Backend.dao.ForumDAO;
import com.inter_chat.Inter_Chat_Backend.model.Forum;

public class ForumDAOTest 
{
	static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.inter_chat.Inter_Chat_Backend");
		context.refresh();
		forumDAO = (ForumDAO) context.getBean("forumDAO");
	}
	
//	@Ignore
	@Test
	public void addForumTest()
	{
		Forum forum=new Forum();
		forum.setCreateDate(new java.util.Date());
		forum.setForumContent("Forum");
		forum.setForumName("Forum");
		forum.setLoginName("Forum");
		forum.setStatus("Forum");
		assertTrue("Problem in adding forum:", forumDAO.addForum(forum));
	}
	
	@Ignore
	@Test
	public void deleteForumTest()
	{
		Forum forum=forumDAO.getForum(951);
		assertTrue("Problem in deleting forum:", forumDAO.deleteForum(forum));
	}
	
	@Ignore
	@Test
	public void updateForumTest()
	{
		Forum forum=forumDAO.getForum(951);
		forum.setForumName("test passed");
		forum.setForumContent("test passed");
		assertTrue("Problem in updating forum:", forumDAO.updateForum(forum));
	}

	@Ignore
	@Test
	public void listForumTest() 
	{
		List<Forum> listForum = forumDAO.listForum();
		assertTrue("Problem in listing forum:",listForum.size()>0);
		for (Forum forum : listForum) 
		{
			System.out.println(forum.getForumName() + ": "+forum.getForumContent());
		}
	}
}