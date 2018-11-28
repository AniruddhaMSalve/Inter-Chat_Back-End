package com.inter_chat.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inter_chat.Inter_Chat_Backend.dao.UserDetailDAO;
import com.inter_chat.Inter_Chat_Backend.model.UserDetail;

public class UserDetailDAOTest {
	static UserDetailDAO userDetailDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.inter_chat.Inter_Chat_Backend");
		context.refresh();
		userDetailDAO = (UserDetailDAO) context.getBean("userDetailDAO");
	}

	@Ignore
	@Test
	public void addUserTest() {
		UserDetail userDetail = new UserDetail();
		userDetail.setLoginName("");
		userDetail.setUsername("");
		userDetail.setPassword("");
		userDetail.setEmailId("");
		userDetail.setMobileNo("");
		userDetail.setAddress("");
		userDetail.setRole("");
		assertTrue("Problem in adding user:", userDetailDAO.addUser(userDetail));
	}

	@Ignore
	@Test
	public void updateUserTest() {
		UserDetail userDetail = userDetailDAO.getUserDetail("");
		userDetail.setLoginName("");
		userDetail.setRole("");
		assertTrue("Problem in updating user:", userDetailDAO.updateUser(userDetail));
	}

	@Ignore
	@Test
	public void deleteUserTest() {
		UserDetail userDetail = userDetailDAO.getUserDetail("");
		assertTrue("Problem in deleting user:", userDetailDAO.deleteUser(userDetail));
	}

	@Ignore
	@Test
	public void checkUserTest() {
		UserDetail userDetail = userDetailDAO.checkUserValidation("", "");
		assertNotNull("Problem in validating user", userDetail);
	}

	@Ignore
	@Test
	public void listUserDetailTest() {
		List<UserDetail> listUserDetail = userDetailDAO.listUserDetail();
		assertTrue("Problem in listing user:", listUserDetail.size() > 0);
		for (UserDetail userDetail : listUserDetail) {
			System.out.println(
					userDetail.getUsername() + ": " + userDetail.getEmailId() + ": " + userDetail.getMobileNo());
		}
	}
}