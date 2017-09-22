package com.hms.pojo;

import java.io.Serializable;

public class BookRoomPojo implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private String billno;
	private String roomno;
	private String name;
	
	private String gender;
	private String country;
	private String idtype;
	private String idno;
	private String dob;
	private String address;
	private String emailid;
	private String mobno;
	
	private String date;
	private String time;
	
	
	public BookRoomPojo(String billno, String roomno, String name, String gender, String country, String idtype, String idno, String dob, String address, String emailid,String mobno,String date,String time) 
	{
		super();
		this.billno = billno;
		this.roomno = roomno;	
		this.name = name;
		
		this.gender = gender;
		this.country = country;
		this.idtype = idtype;
		this.idno = idno;
		this.dob = dob;
		this.address = address;
		this.emailid = emailid;
		this.mobno = mobno;
		
		this.date = date;
		this.time = time;
	}
	

	public String getBillno() {
		return billno ;
	}

	public void setBillno(String billno) {
		this.billno = billno ;
		
	}
	
	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno ;
	}

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
}
