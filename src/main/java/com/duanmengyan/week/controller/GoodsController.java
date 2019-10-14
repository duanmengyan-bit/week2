package com.duanmengyan.week.controller;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsController {
	@Autowired
	RedisTemplate redisTemplate;
	
	@RequestMapping("getList")
	public String getList(Model m) {
		int page=1;
		int pageSize=10;
		List list = redisTemplate.opsForList().range("readList", (page-1)*pageSize,(page-1)*pageSize+pageSize-1 );
		m.addAttribute("list", list);
		
		if (page==1) {
			m.addAttribute("prepage",1);
		}else {
			m.addAttribute("prepage", page-1);
		}
		m.addAttribute("nextpage", page+1);
		return "list";
		
	}
	
	@RequestMapping("getSet")
	public String getSize(Model m) {
		int page=1;
		int pageSize=10;
		List list = (List) redisTemplate.opsForZSet().reverseRange("getZsize", (page-1)*pageSize,(page-1)*pageSize+pageSize-1);
		m.addAttribute("list", list);
		if (page==1) {
			m.addAttribute("prepage",1);
		}else {
			m.addAttribute("prepage", page-1);
		}
		m.addAttribute("nextpage", page+1);
		return "list2";
	}
}
