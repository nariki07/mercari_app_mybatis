package com.example.demo.domain;

public class SmallCategory {

	/* ID */
	private Integer id;
	/* 中カテゴリID */
	private Integer mediumCategoryId;
	/* カテゴリ名 */
	private String name;
	/* 全カテゴリ名 */
	private String nameAll;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMediumCategoryId() {
		return mediumCategoryId;
	}

	public void setMediumCategoryId(Integer mediumCategoryId) {
		this.mediumCategoryId = mediumCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameAll() {
		return nameAll;
	}

	public void setNameAll(String nameAll) {
		this.nameAll = nameAll;
	}

	@Override
	public String toString() {
		return "SmallCategory [id=" + id + ", mediumCategoryId=" + mediumCategoryId + ", name=" + name + ", nameAll="
				+ nameAll + "]";
	}

}
