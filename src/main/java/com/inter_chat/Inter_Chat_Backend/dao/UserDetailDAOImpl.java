package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inter_chat.Inter_Chat_Backend.model.UserDetail;

@Repository("userDetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(UserDetail userDetail) {
		try {
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateUser(UserDetail userDetail) {
		try {
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteUser(UserDetail userDetail) {
		try {
			sessionFactory.getCurrentSession().delete(userDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<UserDetail> listUserDetail() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserDetail");
		List<UserDetail> listUserDetail = query.list();
		session.close();
		return listUserDetail;
	}

	@Override
	public UserDetail getUserDetail(String loginName) {
		Session session = sessionFactory.openSession();
		UserDetail userDetail = (UserDetail) session.get(UserDetail.class, loginName);
		session.close();
		return userDetail;
	}

	@Override
	public UserDetail checkUserValidation(String loginName, String password) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserDetail where loginName=:myloginName and password=:mypassword");
		query.setParameter("myloginName", loginName);
		query.setParameter("mypassword", password);
		List<UserDetail> listUserDetail = query.list();
		if (listUserDetail.size() > 0) {
			UserDetail userDetail = listUserDetail.get(0);
			return userDetail;
		}
		return null;
	}
}
