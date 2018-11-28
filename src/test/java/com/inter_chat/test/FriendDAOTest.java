package com.inter_chat.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inter_chat.Inter_Chat_Backend.dao.FriendDAO;
import com.inter_chat.Inter_Chat_Backend.model.Friend;
import com.inter_chat.Inter_Chat_Backend.model.UserDetail;

public class FriendDAOTest {
	static FriendDAO friendDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.inter_chat.Inter_Chat_Backend");
		context.refresh();
		friendDAO = (FriendDAO) context.getBean("friendDAO");
	}

	@Ignore
	@Test
	public void ListFriendTest() {
		List<Friend> listFriend = friendDAO.listFriend("");

		assertTrue("Problem in getting list of friends", listFriend.size() > 0);

		for (Friend friend : listFriend) {
			System.out.print(friend.getLoginName() + "  ");
			System.out.print(friend.getFriendLoginName() + "  ");
			System.out.println(friend.getStatus() + "  ");
		}
	}

	@Ignore
	@Test
	public void PendingtFriendListTest() {
		List<Friend> listFriend = friendDAO.pendingFriend("");

		assertTrue("Problem in getting list of pending friends", listFriend.size() > 0);

		for (Friend friend : listFriend) {
			System.out.println(friend.getLoginName() + "  ");
			System.out.println(friend.getFriendLoginName() + "  ");
			System.out.println(friend.getStatus() + "  ");
		}
	}

	@Ignore
	@Test
	public void SendFriendRequestTest() {
		Friend friend = new Friend();
		friend.setLoginName("");
		friend.setFriendLoginName("");
		assertTrue("Problem in sending friend request", friendDAO.sendFriendRequest(friend));
	}

	@Ignore
	@Test
	public void acceptFriendRequestTest() {
		assertTrue("Problem in accepting request", friendDAO.acceptFriendRequest(997));
	}

	@Ignore
	@Test
	public void deleteFriendRequestTest() {
		assertTrue("Problem in deleting request", friendDAO.deleteFriendRequest(0));
	}

	@Ignore
	@Test
	public void ShowSuggestedFriendListTest() {
		List<UserDetail> friendList = friendDAO.suggestedFriend("User4");
		assertTrue("Problem in suggesting friends", friendList.size() > 0);

		for (UserDetail friend : friendList) {
			System.out.println(friend.getLoginName() + "  ");
		}
	}

}