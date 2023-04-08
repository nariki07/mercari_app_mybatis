package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.BigCategory;
import com.example.demo.form.SerchItemForm;
import com.example.demo.service.SelectCategoryService;

@Controller
@RequestMapping("")
public class ShowItemListController {
	
	@Autowired
	private SelectCategoryService selectCategoryService;
	
	@ModelAttribute("searchItemForm")
	public SerchItemForm setUpSearchItemForm() {
		return new SerchItemForm();
	}
	
	/**
	 * トップページの表示を行います.
	 * 
	 * 
	 * @return 商品一覧画面
	 */
	@GetMapping("/")
	public String showItemList(Model model) {
		
		List<BigCategory> bigCategoryList = selectCategoryService.findAll();
		model.addAttribute(bigCategoryList);
		
		return "list";
	}
	
	@PostMapping("/serchItem")
	public String serchItem(SerchItemForm form) {
		
		return "list";
	}
	
}











