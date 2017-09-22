package com.hms.pojo;

import java.io.Serializable;

public class FoodPojo implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private String roomno;
	private String name;
	private String total;
	private String foodType;
	private String breakfast;
	private String lunch;
	private String billno;
	private String dinner;
	private String quanb;
	private String quanl;
	private String quant;
	private String quand;
	private String date;
	private String time;
	
	public FoodPojo(String roomno, String name, String total, String foodType, String breakfast, String lunch,
			String billno, String dinner, String quanb, String quanl, String quant, String quand, String date,
			String time) {
		super();
		this.roomno = roomno;
		this.name = name;
		this.total = total;
		this.foodType = foodType;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.billno = billno;
		this.dinner = dinner;
		this.quanb = quanb;
		this.quanl = quanl;
		this.quant = quant;
		this.quand = quand;
		this.date = date;
		this.time = time;
	}
	public String getRoomno() {
		return roomno;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}
	public String getLunch() {
		return lunch;
	}
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	
	public String getDinner() {
		return dinner;
	}
	public void setDinner(String dinner) {
		this.dinner = dinner;
	}
	public String getQuanb() {
		return quanb;
	}
	public void setQuanb(String quanb) {
		this.quanb = quanb;
	}
	public String getQuanl() {
		return quanl;
	}
	public void setQuanl(String quanl) {
		this.quanl = quanl;
	}
	public String getQuant() {
		return quant;
	}
	public void setQuant(String quant) {
		this.quant = quant;
	}
	public String getQuand() {
		return quand;
	}
	public void setQuand(String quand) {
		this.quand = quand;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	
}	