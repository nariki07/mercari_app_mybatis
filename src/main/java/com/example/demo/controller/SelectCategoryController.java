package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.MediumCategory;
import com.example.demo.domain.SmallCategory;
import com.example.demo.service.SelectCategoryService;
import com.example.demo.service.ShowItemListService;

/**
 * カテゴリプルダウンの操作を行うコントローラー.
 * 
 * @author moriharanariki
 *
 */
@Controller
@RequestMapping("/selectCategory")
public class SelectCategoryController {
	
	@Autowired
	private SelectCategoryService selectCategoryService;
	
	
	/**
	 * 大カテゴリに紐づく中カテゴリを検索します.
	 * 
	 * @param largeCategoryId 大カテゴリID
	 * @return 中カテゴリリスト
	 */
	@PostMapping("/getMiddleList")
	@ResponseBody
	public List<MediumCategory> setMiddle(@RequestBody String largeCategoryId){
		List<MediumCategory> mediumCategoryList = selectCategoryService.findByBigId(largeCategoryId);
		return mediumCategoryList;
	}
	
	/**
	 * 中カテゴリに紐づく小カテゴリを検索します.
	 * 
	 * @param mediumCategoryId 中カテゴリID
	 * @return 小カテゴリリスト
	 */
	@PostMapping("/getSmallList")
	@ResponseBody
	public List<SmallCategory> setSmall(@RequestBody String mediumCategoryId){
		List<SmallCategory> smallCategoryList = selectCategoryService.findByMediumId(mediumCategoryId);
		return smallCategoryList;
	}
	
}














