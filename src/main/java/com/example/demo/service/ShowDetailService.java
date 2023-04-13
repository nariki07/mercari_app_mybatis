package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Item;
import com.example.demo.repository.ItemMapper;

@Service
@Transactional
public class ShowDetailService {
	
	@Autowired
	private ItemMapper itemMapper;
	
	public Item showDetail(Integer itemId) {
		
		Item item = itemMapper.findByItemId(itemId);
		
		return item;
	}
}
