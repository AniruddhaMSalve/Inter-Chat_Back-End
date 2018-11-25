package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inter_chat.Inter_Chat_Backend.model.Blog;
import com.inter_chat.Inter_Chat_Backend.model.BlogComment;

@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<BlogComment> listBlogComment(int blogId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BlogComment where blogId=:myBlogId");
		query.setParameter("myBlogId", blogId);
		List<BlogComment> listBlogComment = query.list();
		return listBlogComment;
	}

	@Override
	public BlogComment getBlogComment(int commentId) {
		Session session = sessionFactory.openSession();
		BlogComment blogComment = (BlogComment) session.get(BlogComment.class, commentId);
		session.close();
		return blogComment;
	}
}