package com.newlecture.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/member/")
@Controller
public class MemberController {
		
		@RequestMapping(value="login", method=RequestMethod.GET)
		public String login() {
			
			return "member.login";
		}
		
		//스프링이 제공하는 POST를 이용한다
		/*@RequestMapping(value="login", method=RequestMethod.POST)
		public String login(String id, String pwd) {
			return "redirect:../index"; 
		}*/
		
}
