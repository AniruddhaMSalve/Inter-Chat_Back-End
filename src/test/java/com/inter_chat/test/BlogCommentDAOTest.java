package com.inter_chat.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inter_chat.Inter_Chat_Backend.dao.BlogCommentDAO;
import com.inter_chat.Inter_Chat_Backend.model.Blog;
import com.inter_chat.Inter_Chat_Backend.model.BlogComment;

public class BlogCommentDAOTest 
{
static BlogCommentDAO blogCommentDAO;
	
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.inter_chat.Inter_Chat_Backend");
		context.refresh();
		blogCommentDAO = (BlogCommentDAO) context.getBean("blogCommentDAO");
	}
	
//	@Ignore
	@Test
	public void addBlogCommentTest()
	{
		BlogComment blogComment=new BlogComment();
		blogComment.setCommentText("test");
		blogComment.setBlogId(100);
		blogComment.setCommentText("test");
		blogComment.setCommentDate(new java.util.Date());
		blogComment.setLoginName("test");
		assertTrue("Problem in adding blog comment:", blogCommentDAO.addBlogComment(blogComment));
	}
	
	@Ignore
	@Test
	public void deleteBlogCommentTest()
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(952);
		assertTrue("Problem in deleting blog comment:", blogCommentDAO.deleteBlogComment(blogComment));
	}
	
	@Ignore
	@Test
	public void listBlogCommentTest() 
	{
		List<BlogComment> listBlogComment = blogCommentDAO.listBlogComment(100);
		assertTrue("Problem in listing blog:",listBlogComment.size()>0);
		for (BlogComment blogComment : listBlogComment) 
		{
			System.out.println(blogComment.getBlogId() + ": "+blogComment.getCommentId()+": "+blogComment.getLoginName()+":"+blogComment.getCommentText()+":"+blogComment.getCommentDate());
		}
	}
}