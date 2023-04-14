package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.BigCategory;
import com.example.demo.domain.Item;
import com.example.demo.domain.MediumCategory;
import com.example.demo.domain.SmallCategory;
import com.example.demo.repository.BigCategoryMapper;
import com.example.demo.repository.ItemMapper;
import com.example.demo.repository.MediumCategoryMapper;
import com.example.demo.repository.SmallCategoryMapper;

/**
 * 商品編集の業務処理を行うサービスクラス.
 * 
 * @author moriharanariki
 *
 */
@Service
@Transactional
public class ItemEditService {

	@Autowired
	private ItemMapper itemMapper;

	@Autowired
	private SmallCategoryMapper smallCategoryMapper;

	@Autowired
	private MediumCategoryMapper mediumCategoryMapper;
	
	@Autowired
	private BigCategoryMapper bigCategoryMapper;


	/**
	 * 編集を行う商品情報を取得します.
	 * 
	 * @param itemId 商品ID
	 * @return 商品情報
	 */
	public Item showEdit(int itemId) {
		Item item = itemMapper.findByItemId(itemId);
		return item;
	}

	/**
	 * 編集を行う商品情報の小カテゴリを取得します.
	 * 
	 * @param smallId 小カテゴリID
	 * @return 小カテゴリ
	 */
	public SmallCategory showSmallCategory(Integer smallId) {
		SmallCategory smallCategory = smallCategoryMapper.findSmallId(smallId);
		return smallCategory;
	}

	/**
	 * 編集を行う商品情報の中カテゴリを取得します.
	 * 
	 * @param mediumId
	 * @return
	 */
	public MediumCategory showMediumCategory(Integer mediumId) {
		MediumCategory mediumCategory = mediumCategoryMapper.findByMediumId(mediumId);
		return mediumCategory;
	}
	
	/**
	 * 編集を行う商品情報の大カテゴリを取得します.
	 * 
	 * @param bigId
	 * @return
	 */
	public BigCategory showBigCategory(Integer bigId) {
		BigCategory bigCategory = bigCategoryMapper.findByBigId(bigId);
		return bigCategory;
	}
	
	public void edit(Item item) {
		itemMapper.update(item);
	}
	
}
