package com.bitacademy.myportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.repository.GuestbookVo;
import com.bitacademy.myportal.service.GuestbookService;

@RequestMapping("/guestbook")
@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookServiceImpl; // # 목록
	// # /guestbook, /guestbook/, /guestook/list를 반환한다.
	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = guestbookServiceImpl.getMessageList();
		System.out.println(list);
		model.addAttribute("list", list);
		return "guestbook/list"; //  #목록 데이터 전달
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute GuestbookVo vo) {
		System.out.println("FORM DATA:" + vo);
		return null;
	}
}