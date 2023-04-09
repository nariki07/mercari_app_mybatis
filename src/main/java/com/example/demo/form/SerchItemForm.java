package com.example.demo.form;

/**
 * 商品検索に使用するフォーム.
 * 
 * @author moriharanariki
 *
 */
public class SerchItemForm {

	/* 名前 */
	private String name;
	/* 小カテゴリID */
	private String smallId;
	/** ブランド名 */
	private String brand;

	public SerchItemForm() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "SerchItemForm [name=" + name + ", smallId=" + smallId + ", brand=" + brand + "]";
	}

}
