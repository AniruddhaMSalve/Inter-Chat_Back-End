package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import com.inter_chat.Inter_Chat_Backend.model.Blog;
import com.inter_chat.Inter_Chat_Backend.model.ProfilePicture;

public interface BlogDAO {
	public boolean addBlog(Blog blog);

	public boolean deleteBlog(Blog blog);

	public boolean updateBlog(Blog blog);

	public boolean approveBlog(Blog blog);

	public boolean rejectBlog(Blog blog);

	public boolean incrementLikes(int blogId);

	public boolean incrementDislikes(int blogId);

	public List<Blog> listBlog();

	public Blog getBlog(int blogId);
}
