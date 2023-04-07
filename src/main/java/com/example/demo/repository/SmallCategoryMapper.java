package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.SmallCategory;

/**
 * mediumCategory情報 Mapper
 * 
 * @author moriharanariki
 *
 */
@Mapper
public interface SmallCategoryMapper {
	
	public void insert(SmallCategory smallCategory);
	
}
