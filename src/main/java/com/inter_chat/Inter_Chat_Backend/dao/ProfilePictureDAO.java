package com.inter_chat.Inter_Chat_Backend.dao;

import com.inter_chat.Inter_Chat_Backend.model.ProfilePicture;

public interface ProfilePictureDAO 
{
	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String loginName);
}