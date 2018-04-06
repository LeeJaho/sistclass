package com.newlecture.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.dao.MemberDao;
import com.newlecture.entity.Member;

public class MemberService {

	@Autowired
	private MemberDao memberDao;
	public int insertMember(Member member) {
		
		memberDao.insert(member);
		return 0;
	}

}
