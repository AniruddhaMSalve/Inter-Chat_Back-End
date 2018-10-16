package com.inter_chat.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inter_chat.Inter_Chat_Backend.dao.ForumCommentDAO;
import com.inter_chat.Inter_Chat_Backend.model.ForumComment;

public class ForumCommentDAOTest 
{
	static ForumCommentDAO forumCommentDAO;
	
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.inter_chat.Inter_Chat_Backend");
		context.refresh();
		forumCommentDAO = (ForumCommentDAO) context.getBean("forumCommentDAO");
	}
	
	@Ignore
	@Test
	public void addForumCommentTest()
	{
		ForumComment forumComment=new ForumComment();
		forumComment.setCommentText("test");
		forumComment.setForumId(100);
		forumComment.setCommentText("test");
		forumComment.setCommentDate(new java.util.Date());
		forumComment.setLoginName("test");
		assertTrue("Problem in adding forum comment:", forumCommentDAO.addForumComment(forumComment));
	}
	
	@Ignore
	@Test
	public void deleteBlogCommentTest()
	{
		ForumComment forumComment=forumCommentDAO.getForumComment(951);
		assertTrue("Problem in deleting blog comment:", forumCommentDAO.deleteForumComment(forumComment));
	}
	
	@Ignore
	@Test
	public void listBlogCommentTest() 
	{
		List<ForumComment> listForumComment = forumCommentDAO.listForumComment(100);
		assertTrue("Problem in listing forum:",listForumComment.size()>0);
		for (ForumComment forumComment : listForumComment) 
		{
			System.out.println(forumComment.getForumId() + ": "+forumComment.getCommentId()+": "+forumComment.getLoginName()+":"+forumComment.getCommentText()+":"+forumComment.getCommentDate());
		}
	}
}