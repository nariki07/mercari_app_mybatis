package com.example.demo.domain;

/**
 * 中カテゴリを表すドメインクラス.
 * 
 * @author moriharanariki
 *
 */
public class MediumCategory {

	/* ID */
	private Integer id;
	/* 大カテゴリID */
	private Integer bigCategoryId;
	/* カテゴリ名 */
	private String name;
	
	public MediumCategory(){
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBigCategoryId() {
		return bigCategoryId;
	}

	public void setBigCategoryId(Integer bigCategoryId) {
		this.bigCategoryId = bigCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MediumCategory [id=" + id + ", bigCategoryId=" + bigCategoryId + ", name=" + name + "]";
	}

}
