package com.example.demo.repository;

import java.util.List;

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

	List<BigCategory> findAll();
	
	BigCategory findByBigId(Integer bigId);
	
	public void insert(BigCategory bigCategory);
	
}
