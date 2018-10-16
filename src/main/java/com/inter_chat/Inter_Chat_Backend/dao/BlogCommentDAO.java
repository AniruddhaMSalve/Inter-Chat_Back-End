package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;
import com.inter_chat.Inter_Chat_Backend.model.BlogComment;

public interface BlogCommentDAO 
{
	public boolean addBlogComment(BlogComment blogComment);
	public boolean deleteBlogComment(BlogComment blogComment);
	public List<BlogComment> listBlogComment(int blogId);
	public BlogComment getBlogComment(int commentId);
}