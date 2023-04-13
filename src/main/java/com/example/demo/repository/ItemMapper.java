package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Item;
import com.example.demo.form.SerchItemForm;

/**
 * item情報 Mapper
 * 
 * @author moriharanariki
 *
 */
@Mapper
public interface ItemMapper {
	
	public List<Item> findByNameAndCategoryAndBrand(String name, Integer smallId, String brand);
	
	public void insert(Item item);
	
	public Item findByItemId(Integer itemId);
	
}
