package com.inter_chat.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inter_chat.Inter_Chat_Backend.dao.BlogDAO;
import com.inter_chat.Inter_Chat_Backend.model.Blog;



public class BlogDAOTestCase 
{
	static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.inter_chat.Inter_Chat_Backend");
		context.refresh();
		blogDAO = (BlogDAO) context.getBean("blogDAO");
	}
	
	@Ignore
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogName("test");
		blog.setBlogDesc("test");
		blog.setCreateDate(new java.util.Date());
		blog.setLoginName("test");
		blog.setStatus("test");
		blog.setLikes(1);
		blog.setDislikes(1);
		assertTrue("Problem in adding blog:", blogDAO.addBlog(blog));
	}
	
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=blogDAO.getBlog(952);
		assertTrue("Problem in deleting blog:", blogDAO.deleteBlog(blog));
	}
	
	@Ignore
	@Test
	public void updateBlogTest()
	{
		Blog blog=blogDAO.getBlog(953);
		blog.setLikes(0);
		blog.setDislikes(0);
		assertTrue("Problem in updating blog:", blogDAO.updateBlog(blog));
	}
	
	@Ignore
	@Test
	public void approveBlogTest()
	{
		Blog blog=blogDAO.getBlog(953);
		assertTrue("Problem in approving blog:", blogDAO.approveBlog(blog));
	}
	
	
	@Ignore
	@Test
	public void rejectBlogTest()
	{
		Blog blog=blogDAO.getBlog(953);
		assertTrue("Problem in rejecting blog:", blogDAO.rejectBlog(blog));
	}
	
	
	@Ignore
	@Test
	public void incrementLikesTest()
	{
		Blog blog=blogDAO.getBlog(953);
		assertTrue("Problem in incrementing likes:", blogDAO.incrementLikes(953));
	}
	
	
	@Ignore
	@Test
	public void incrementDislikesTest()
	{
		assertTrue("Problem in incrementing dislikes:", blogDAO.incrementDislikes(953));
	}
	
//	@Ignore
	@Test
	public void listBlogTest() 
	{
		List<Blog> listBlog = blogDAO.listBlog();
		assertTrue("Problem in listing blog:",listBlog.size()>0);
		for (Blog blog : listBlog) 
		{
			System.out.println(blog.getBlogId() + ": "+blog.getBlogName()+": "+blog.getBlogDesc()+": "+blog.getLikes()+": "+blog.getDislikes());
		}
	}
}