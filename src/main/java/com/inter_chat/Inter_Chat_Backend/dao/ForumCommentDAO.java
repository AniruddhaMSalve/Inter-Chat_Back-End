package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import com.inter_chat.Inter_Chat_Backend.model.ForumComment;

public interface ForumCommentDAO 
{
	public boolean addForumComment(ForumComment forumComment);
	public boolean deleteForumComment(ForumComment forumComment);
	public List<ForumComment> listForumComment(int forumId);
	public ForumComment getForumComment(int commentId);
}