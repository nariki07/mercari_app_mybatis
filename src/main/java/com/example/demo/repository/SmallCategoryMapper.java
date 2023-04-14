package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.MediumCategory;
import com.example.demo.domain.SmallCategory;

/**
 * mediumCategory情報 Mapper
 * 
 * @author moriharanariki
 *
 */
@Mapper
public interface SmallCategoryMapper {
	
	
	List<SmallCategory> findById(Integer smallCategoryId);
	
	SmallCategory findSmallId(Integer smallId);

	public void insert(SmallCategory smallCategory);
	
}
