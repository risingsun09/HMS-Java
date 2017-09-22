package com.hms.pojo;

import java.io.Serializable;

public class RoomIncomePojo implements Serializable
{
	
	
	private static final long serialVersionUID = 1L;
	
	private String roomno,totalincome;

	public RoomIncomePojo(String roomno, String totalincome) {
		super();
		this.roomno = roomno;
		this.totalincome = totalincome;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public String getTotalincome() {
		return totalincome;
	}

	public void setTotalincome(String totalincome) {
		this.totalincome = totalincome;
	}
	
	
	
}
