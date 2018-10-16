package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import com.inter_chat.Inter_Chat_Backend.model.Friend;

public interface FriendDAO 
{
	public boolean addFriend(Friend friend);
	public boolean deleteFriend(Friend friend);
	public boolean updateFriend(Friend friend);
	public List<Friend> listFriend();
	public Friend getFriend(int friendId);
}
