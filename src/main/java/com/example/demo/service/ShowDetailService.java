package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Item;
import com.example.demo.repository.ItemMapper;

/**
 * 商品情報を取得する業務処理を行うサービス.
 * 
 * @author moriharanariki
 *
 */
@Service
@Transactional
public class ShowDetailService {
	
	@Autowired
	private ItemMapper itemMapper;
	
	/**
	 * 商品情報を取得します.
	 * 
	 * @param itemId 商品ID
	 * @return 商品情報
	 */
	public Item showDetail(Integer itemId) {
		
		Item item = itemMapper.findByItemId(itemId);
		
		return item;
	}
}
