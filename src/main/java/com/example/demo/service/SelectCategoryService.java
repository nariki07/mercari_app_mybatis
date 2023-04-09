package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.BigCategory;
import com.example.demo.domain.MediumCategory;
import com.example.demo.domain.SmallCategory;
import com.example.demo.repository.BigCategoryMapper;
import com.example.demo.repository.MediumCategoryMapper;
import com.example.demo.repository.SmallCategoryMapper;

/**
 * カテゴリプルダウンの操作に関する業務処理を行うサービス.
 * 
 * @author moriharanariki
 *
 */
@Service
@Transactional
public class SelectCategoryService {

	@Autowired
	private BigCategoryMapper bigCategoryMapper;

	@Autowired
	private MediumCategoryMapper mediumCategoryMapper;
	
	@Autowired
	private SmallCategoryMapper smallCategoryMapper;

	/**
	 * 大カテゴリ名を全件取得します.
	 * 
	 * @return 大カテゴリ名一覧
	 */
	public List<BigCategory> findAll() {
		List<BigCategory> bigCategoryList = bigCategoryMapper.findAll();
		return bigCategoryList;
	}

	/**
	 * 大カテゴリIDで中カテゴリ情報を取得します.
	 * 
	 * @param bigCategoryId 大カテゴリID
	 * @return 中カテゴリ情報
	 */
	public List<MediumCategory> findByBigId(String bigCategoryId) {
		List<MediumCategory> mediumCategoryList = mediumCategoryMapper.findById(Integer.parseInt(bigCategoryId));
		return mediumCategoryList;
	}
	
	/**
	 * 中カテゴリIDで小カテゴリ情報を取得します.
	 * 
	 * @param mediumCategoryId 中カテゴリID
	 * @return 小カテゴリ情報
	 */
	public List<SmallCategory> findByMediumId(String mediumCategoryId){
		List<SmallCategory> smallCategoryList = smallCategoryMapper.findById(Integer.parseInt(mediumCategoryId));
		return smallCategoryList;
	}

}
