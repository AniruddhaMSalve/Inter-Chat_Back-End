package com.inter_chat.Inter_Chat_Backend.model;

import java.util.Date;

public class MessageOutput extends Message {
	private Date time;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public MessageOutput(Message original, Date time) {
		super(original.getId(), original.getMessage());
		this.time = time;
	}
}