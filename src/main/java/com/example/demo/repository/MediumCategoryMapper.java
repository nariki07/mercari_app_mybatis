package com.example.demo.repository;

import java.util.List;

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
	
	
	List<MediumCategory> findById(Integer bigCategoryId);
	
	public void insert(MediumCategory mediumCategory);
	
}
