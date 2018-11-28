package com.inter_chat.Inter_Chat_Backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name = "friendIdSeq", sequenceName = "friendId")
public class Friend {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friendIdSeq")
	@Column(nullable = false)
	int friendId;

	@Column(nullable = false)
	String loginName;

	@Column(nullable = false)
	String friendLoginName;

	@Column(nullable = false)
	String status;

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getFriendLoginName() {
		return friendLoginName;
	}

	public void setFriendLoginName(String friendLoginName) {
		this.friendLoginName = friendLoginName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}