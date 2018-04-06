package com.newlecture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newlecture.entity.Member;
import com.newlecture.service.MemberService;


@RequestMapping("/member/")
@Controller
public class MemberController {
		@Autowired
		private MemberService service;
	
		@RequestMapping(value="login", method=RequestMethod.GET)
		public String login() {
			
			return "member.login";
		}
		
		//스프링이 제공하는 POST를 이용한다
		/*@RequestMapping(value="login", method=RequestMethod.POST)
		public String login(String id, String pwd) {
			return "redirect:../index"; 
		}*/
		
		@RequestMapping(value="join", method=RequestMethod.GET)
		public String join() {
			
			return "member.join";
		}
		
		@RequestMapping(value="join", method=RequestMethod.POST)
		public String join(Member member) {
			
			int result = service.insertMember(member);
			return "redirect:../index"; 
		}
}
