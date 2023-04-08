package com.example.demo.form;

/**
 * 商品検索に使用するフォーム.
 * 
 * @author moriharanariki
 *
 */
public class SerchItemForm {

	/** 名前 */
	private String name;
	/** 親カテゴリ名 */
	private String bigName;
	/** 子カテゴリ名 */
	private String middleName;
	/** 孫カテゴリID */
	private String categoryId;
	/** 孫カテゴリ名 */
	private String smallName;
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

	public String getBigName() {
		return bigName;
	}

	public void setBigName(String bigName) {
		this.bigName = bigName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSmallName() {
		return smallName;
	}

	public void setSmallName(String smallName) {
		this.smallName = smallName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "SerchItemForm [name=" + name + ", bigName=" + bigName + ", middleName=" + middleName + ", categoryId="
				+ categoryId + ", smallName=" + smallName + ", brand=" + brand + "]";
	}

}
