package com.bitacademy.myportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/guestbook")
@Controller
public class GuestbookController {
	
	// # /guestbook, /guestbook/, /guestook/list를 반환한다.
	@RequestMapping({"", "/", "/list"})
	public String list() {
		return "guestbook/list";
	}
}
