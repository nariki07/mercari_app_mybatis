package com.example.demo.domain;

/**
 * 大カテゴリの情報を表すドメインクラス.
 * 
 * @author moriharanariki
 *
 */
public class BigCategory {

	/* id */
	private Integer id;
	/* カテゴリ名 */
	private String name;
	
	public BigCategory() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BigCategory [id=" + id + ", name=" + name + "]";
	}

}
