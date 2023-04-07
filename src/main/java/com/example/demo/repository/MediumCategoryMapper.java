package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.MediumCategory;

/**
 * mediumCategory情報 Mapper
 * 
 * @author moriharanariki
 *
 */
@Mapper
public interface MediumCategoryMapper {
	
	public void insert(MediumCategory mediumCategory);
}
