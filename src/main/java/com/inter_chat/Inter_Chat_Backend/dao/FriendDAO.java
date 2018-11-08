package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import com.inter_chat.Inter_Chat_Backend.model.Friend;
import com.inter_chat.Inter_Chat_Backend.model.UserDetail;

public interface FriendDAO {
	public boolean sendFriend(Friend friend);

	public boolean acceptFriend(Friend friend);

	public boolean deleteFriend(Friend friend);

	public List<Friend> listFriend(String loginName);

	public List<Friend> pendingFriend(String loginName);

	public List<UserDetail> suggestedFriend(String loginName);

}