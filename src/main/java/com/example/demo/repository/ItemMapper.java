package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Item;

/**
 * item情報 Mapper
 * 
 * @author moriharanariki
 *
 */
@Mapper
public interface ItemMapper {

	public void insert(Item item);
	
}
