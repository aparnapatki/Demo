package com.inventory.request;

public class ProductRequest {
    
	private String name;
	private String type;
	private int mrp;
	private double discount;
	private int price;
	private int quantity;
	private int soldItem;
	private int availableItem;
	private int defectiveItem;
	private String description;
	private String companyName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMrp() {
		return mrp;
	}
	public void setMrp(int mrp) {
		this.mrp = mrp;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSoldItem() {
		return soldItem;
	}
	public void setSoldItem(int soldItem) {
		this.soldItem = soldItem;
	}
	public int getAvailableItem() {
		return availableItem;
	}
	public void setAvailableItem(int availableItem) {
		this.availableItem = availableItem;
	}
	public int getDefectiveItem() {
		return defectiveItem;
	}
	public void setDefectiveItem(int defectiveItem) {
		this.defectiveItem = defectiveItem;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	private long compId;

	public long getCompId() {
		return compId;
	}
	public void setCompId(long compId) {
		this.compId = compId;
	}
	

}
