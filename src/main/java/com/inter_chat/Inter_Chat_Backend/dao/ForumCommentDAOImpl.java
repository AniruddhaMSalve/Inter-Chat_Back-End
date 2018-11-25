package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inter_chat.Inter_Chat_Backend.model.ForumComment;

@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addForumComment(ForumComment forumComment) {
		try {
			sessionFactory.getCurrentSession().save(forumComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteForumComment(ForumComment forumComment) {
		try {
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<ForumComment> listForumComment(int forumId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ForumComment");
		List<ForumComment> listForumComment = query.list();
		session.close();
		return listForumComment;
	}

	@Override
	public ForumComment getForumComment(int commentId) {
		Session session = sessionFactory.openSession();
		ForumComment forumComment = (ForumComment) session.get(ForumComment.class, commentId);
		session.close();
		return forumComment;
	}
}