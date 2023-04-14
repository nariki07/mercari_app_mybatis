package com.example.demo.form;

/**
 * 商品の更新を行うフォーム.
 * 
 * @author moriharanariki
 *
 */
public class UpdateItemForm {

	/** ID */
	private String id;
	/** 名前 */
	private String name;
	/** 状態 */
	private Integer conditionId;
	/* 大カテゴリ名 */
	private String bigName;
	/* 中カテゴリ名 */
	private String mediumName;
	/* 小カテゴリ名 */
	private String smallId;
	/** ブランド名 */
	private String brand;
	/** 価格 */
	private String price;
	/** 配送情報 */
	private String shipping;
	/** 説明 */
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getConditionId() {
		return conditionId;
	}
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}
	public String getBigName() {
		return bigName;
	}
	public void setBigName(String bigName) {
		this.bigName = bigName;
	}
	public String getMediumName() {
		return mediumName;
	}
	public void setMediumName(String mediumName) {
		this.mediumName = mediumName;
	}
	public String getSmallId() {
		return smallId;
	}
	public void setSmallId(String smallId) {
		this.smallId = smallId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
