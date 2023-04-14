package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.BigCategory;
import com.example.demo.domain.Item;
import com.example.demo.domain.MediumCategory;
import com.example.demo.domain.SmallCategory;
import com.example.demo.form.UpdateItemForm;
import com.example.demo.service.ItemEditService;
import com.example.demo.service.SelectCategoryService;

/**
 * 商品編集を行うコントローラー.
 * 
 * @author moriharanariki
 *
 */
@Controller
@RequestMapping("/")
public class ItemEditController {

	@Autowired
	private ItemEditService itemEditService;

	@Autowired
	private SelectCategoryService selectCategoryService;
	
	@Autowired
	private ShowDetailController showDetailController;

	/**
	 * 商品編集画面を表示します.
	 * 
	 * @param form   フォーム
	 * @param itemId 商品ID
	 * @return 商品編集画面
	 */
	@GetMapping("toEdit")
	public String showEditService(UpdateItemForm updateItemForm, int itemId, Model model) {
		Item item = itemEditService.showEdit(itemId);
		SmallCategory smallCategory = itemEditService.showSmallCategory(item.getSmallCategoryId());
		
		List<SmallCategory> smallCategoryList = selectCategoryService
				.findByMediumId(String.valueOf(smallCategory.getMediumCategoryId()));
		
		MediumCategory mediumCategory = itemEditService.showMediumCategory(smallCategoryList.get(0).getMediumCategoryId());
		List<MediumCategory> mediumCategoryList = selectCategoryService.findByBigId(String.valueOf(mediumCategory.getBigCategoryId()));
		
		BigCategory bigCategory = itemEditService.showBigCategory(mediumCategory.getBigCategoryId());
				
		List<BigCategory> bigCategoryList = selectCategoryService.findAll();
		
		//フォームに値をセットする.
		BeanUtils.copyProperties(item, updateItemForm);
		updateItemForm.setPrice(String.valueOf(item.getPrice()));
		updateItemForm.setBigName(String.valueOf(bigCategory.getId()));
		updateItemForm.setMediumName(String.valueOf(mediumCategory.getId()));
		updateItemForm.setSmallId(String.valueOf(item.getSmallCategoryId()));

		model.addAttribute("bigCategoryList", bigCategoryList);
		model.addAttribute("mediumCategoryList", mediumCategoryList);
		model.addAttribute("smallCategoryList", smallCategoryList);
		model.addAttribute("item",item);
		return "edit";
	}
	
	@PostMapping("edit")
	public String edit(UpdateItemForm updateItemForm, Integer itemId, Model model) {
		Item item = new Item();
		BeanUtils.copyProperties(updateItemForm, item);
		item.setPrice(Double.valueOf(updateItemForm.getPrice()));
		item.setSmallCategoryId(Integer.parseInt(updateItemForm.getSmallId()));
		item.setShipping(0);
		item.setId(itemId);
		itemEditService.edit(item);
		
		return showDetailController.detail(itemId, model);
	}
	
	
}
