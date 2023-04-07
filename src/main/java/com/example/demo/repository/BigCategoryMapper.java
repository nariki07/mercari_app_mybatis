package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.BigCategory;

/**
 * bigCategory情報 Mapper
 * 
 * @author moriharanariki
 *
 */
@Mapper
public interface BigCategoryMapper {
	
	public void insert(BigCategory bigCategory);
	
}
