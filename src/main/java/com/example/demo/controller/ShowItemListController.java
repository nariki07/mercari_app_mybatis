package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.BigCategory;
import com.example.demo.domain.Item;
import com.example.demo.form.SerchItemForm;
import com.example.demo.service.SelectCategoryService;
import com.example.demo.service.ShowItemListService;

/**
 * 商品表示を行うコントローラー.
 * 
 * @author moriharanariki
 *
 */
@Controller
@RequestMapping("")
public class ShowItemListController {

	@Autowired
	private SelectCategoryService selectCategoryService;

	@Autowired
	private ShowItemListService showItemListService;

	// 1ページに表示するアイテム数は20個
	private static final int VIEW_SIZE = 20;

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

	@RequestMapping("/serchItem")
	public String serchItem(@ModelAttribute("searchItemForm") SerchItemForm form, Model model, Integer page) {
		
		List<Item> itemList = showItemListService.showItemList(form);

		// pageがnullもしくは0の場合は1をいれる.
		if (page == null || page == 0) {
			page = 1;
		}

		// 表示させたいページ数、ページサイズ、商品リストを渡し１ページに表示させる商品リストを絞り込み.
		Page<Item> itemPage = null;
		itemPage = showItemListService.showItemListPaging(page, VIEW_SIZE, itemList);
		model.addAttribute("itemPage", itemPage);

		if (itemPage.isEmpty() && page != 1) {
			page--;
			Page<Item> itemPage2 = showItemListService.showItemListPaging(page, VIEW_SIZE, itemList);
			model.addAttribute("itemPage", itemPage2);
		}

		// ページングのリンクに使うページ数をスコープに格納 (例)28件あり1ページにつき10件表示させる場合→1,2,3がpageNumbersに入る
		List<Integer> pageNumbers = calcPageNumbers(model, itemPage);
		model.addAttribute("pageNumbers", pageNumbers);

		return showItemList(model);
	}

	/**
	 * ページングのリンクに使うページ数をスコープに格納 (例)28件あり1ページにつき10件表示させる場合→1,2,3がpageNumbersに入る
	 * 
	 * @param model        モデル
	 * @param employeePage ページング情報
	 */
	private List<Integer> calcPageNumbers(Model model, Page<Item> itemPage) {
		int totalPages = itemPage.getTotalPages();
		List<Integer> pageNumbers = null;
		if (totalPages > 0) {
			pageNumbers = new ArrayList<Integer>();
			for (int i = 1; i <= totalPages; i++) {
				pageNumbers.add(i);
			}
		}
		return pageNumbers;
	}

}
