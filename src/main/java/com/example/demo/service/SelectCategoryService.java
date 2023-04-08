package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.BigCategory;
import com.example.demo.domain.MediumCategory;
import com.example.demo.repository.BigCategoryMapper;
import com.example.demo.repository.MediumCategoryMapper;

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
	public List<MediumCategory> findById(String bigCategoryId) {

		List<MediumCategory> mediumCategoryList = mediumCategoryMapper.findById(Integer.parseInt(bigCategoryId));
		return mediumCategoryList;
	}

}
