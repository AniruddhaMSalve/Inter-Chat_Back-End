package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import com.inter_chat.Inter_Chat_Backend.model.Friend;
import com.inter_chat.Inter_Chat_Backend.model.UserDetail;

public interface FriendDAO {
	public boolean sendFriendRequest(Friend friend);

	public boolean acceptFriendRequest(int friendId);

	public boolean deleteFriendRequest(int friendId);

	public List<Friend> listFriend(String loginName);

	public List<Friend> pendingFriend(String loginName);

	public List<UserDetail> suggestedFriend(String loginName);

}