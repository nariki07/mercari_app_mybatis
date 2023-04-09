package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.example.demo.domain.Item;
import com.example.demo.form.SerchItemForm;
import com.example.demo.repository.ItemMapper;

/**
 * 商品一覧表示に関する業務処理を行うサービス.
 * 
 * @author moriharanariki
 *
 */
@Service
@Transactional
public class ShowItemListService {

	@Autowired
	private ItemMapper itemMapper;

	/**
	 * 検索条件から商品情報を取得します.
	 * 
	 * @param form フォーム
	 * @return 商品リスト
	 */
	public List<Item> showItemList(SerchItemForm form) {
		List<Item> itemList = new ArrayList<>();

		// 未入力の場合は全件取得させるため、空文字セットする.
		if (form.getName() == null) {
			form.setName("");
		}

		if (form.getBrand() == null) {
			form.setBrand("");
		}

		itemList = itemMapper.findByNameAndCategoryAndBrand(form.getName(), Integer.parseInt(form.getSmallId()),
				form.getBrand());
		return itemList;
	}

	/**
	 * ページング用メソッド.
	 * 
	 * @param page 表示させたいページ数
	 * @param VIEW_SIZE １ページに表示させる従業員数
	 * @param itemList 商品情報一覧
	 * @return
	 */
	public Page<Item> showItemListPaging(Integer page, Integer VIEW_SIZE, List<Item> itemList) {

		// 表示させたいページ数を-1しなければうまく動かない
		page--;
		// どの商品から表示させるかと言うカウント値
		int startItemCount = page * VIEW_SIZE;
		// 絞り込んだ後の商品リストが入る変数
		List<Item> list;

		if (itemList.size() < startItemCount) {
			// (ありえないが)もし表示させたい商品カウントがサイズよりも大きい場合は空のリストを返す
			list = Collections.emptyList();
		} else {
			// 該当ページに表示させる商品一覧を作成
			int toIndex = Math.min(startItemCount + VIEW_SIZE, itemList.size());
			list = itemList.subList(startItemCount, toIndex);
		}
		// 上記で作成した該当ページに表示させる商品一覧をページングできる形に変換して返す
		Page<Item> itemPage = new PageImpl<Item>(list, PageRequest.of(page, VIEW_SIZE), itemList.size());
		return itemPage;

	}

}
