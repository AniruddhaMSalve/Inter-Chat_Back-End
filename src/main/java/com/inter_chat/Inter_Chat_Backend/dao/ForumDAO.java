package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import com.inter_chat.Inter_Chat_Backend.model.Forum;

public interface ForumDAO {

	public boolean addForum(Forum forum);

	public boolean deleteForum(Forum forum);

	public boolean updateForum(Forum forum);

	public boolean approveForum(Forum forum);

	public boolean rejectForum(Forum forum);

	public List<Forum> listForum();

	public Forum getForum(int forumId);
	
	public List<Forum> listUserForum(String loginName);
}
