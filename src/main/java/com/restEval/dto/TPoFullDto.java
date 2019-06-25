package com.restEval.dto;

import java.util.Date;

public class TPoFullDto {
	
	private String poNo;
	private String cityId;
	private double discount;
	private String poAddress;
	private Date poDate;
	private Date poExpDate;
	private String poNotes;
	private String poShipment;
	private String supId;
	private double total;
	private String supName;
	private String cityName;
	
	private String itemId;
	private String itemName;
	private int itemPrice;
	private int itemQty;
	private double subtotal;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getPoAddress() {
		return poAddress;
	}
	public void setPoAddress(String poAddress) {
		this.poAddress = poAddress;
	}
	public Date getPoDate() {
		return poDate;
	}
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}
	public Date getPoExpDate() {
		return poExpDate;
	}
	public void setPoExpDate(Date poExpDate) {
		this.poExpDate = poExpDate;
	}
	public String getPoNotes() {
		return poNotes;
	}
	public void setPoNotes(String poNotes) {
		this.poNotes = poNotes;
	}
	public String getPoShipment() {
		return poShipment;
	}
	public void setPoShipment(String poShipment) {
		this.poShipment = poShipment;
	}
	public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
