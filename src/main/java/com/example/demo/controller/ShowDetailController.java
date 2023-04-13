package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Item;
import com.example.demo.service.ShowDetailService;

@Controller
@RequestMapping("/")
public class ShowDetailController {
	
	@Autowired
	private ShowDetailService showDetailService;
	
	
	@GetMapping("detail")
	public String detail(Integer itemId, Model model) {
		
		Item item = showDetailService.showDetail(itemId);
		model.addAttribute("item",item);
		
		return "detail";
		
	}
}
