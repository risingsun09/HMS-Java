package com.hms.pojo;

import java.io.Serializable;

public class RoomPojo implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private String roomno;
	private String roomtype;
	private String tarrif;
	private String numofpersons;
	private boolean allocate;
	
	
	
	public RoomPojo(String roomno, String roomtype, String tarrif,
			String numofpersons, boolean allocate)
	{
		super();
		this.roomno = roomno;
		this.roomtype = roomtype;
		this.tarrif = tarrif;
		this.numofpersons = numofpersons;
		this.allocate = allocate;
	}
	
	public boolean isAllocate() {
		return allocate;
	}

	public void setAllocate(boolean allocate) {
		this.allocate = allocate;
	}


	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getTarrif() {
		return tarrif;
	}

	public void setTarrif(String tarrif) {
		this.tarrif = tarrif;
	}

	public String getNumofpersons() {
		return numofpersons;
	}

	public void setNumofpersons(String numofpersons) {
		this.numofpersons = numofpersons;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


	
	
}


