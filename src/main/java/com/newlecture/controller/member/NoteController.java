package com.newlecture.controller.member;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.entity.Note;
import com.newlecture.service.member.NoteService;
@RequestMapping("/member/note/")
@Controller("MemberNoteController")
public class NoteController {
	
	@Autowired
	private NoteService service;
	
	@RequestMapping("list")
	public String list() {
		
		return "member.note.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		
		return "member/note/detail";
	}
	
	
	@RequestMapping("edit")
	public String edit() {
		
		return "member/note/edit";
	}
	
	//왜 GET, POST 나눴나? value 의미
	@RequestMapping(value="reg", method=RequestMethod.GET)
	public String reg() {
		
		return "member/note/reg";
	}
	
	@RequestMapping(value="reg", method=RequestMethod.POST)
	public String reg(Note note, MultipartFile file, HttpServletRequest request/*String title, String content*/) { //일일이 값을 담아주는 게 아니라 객체를 아예 받을 수 있음?-> setter가 있는지 확인하고 짝 맞춰서 스프링이 알아서 담아줌
									//name="" 이름 매칭되면 담아준다!!!!
		String memberId = "newlec";
		//예외 처리 위로 던지면 무책임한 일 / 우리 오류 코드 뜬다 ! / 오류페이지로 redirect가 맞는 일
		ServletContext ctx = request.getServletContext();
		//newlec이란 사용자 폴더 path
	    String path = ctx.getRealPath("/resource/note/"+memberId+"/");
		
	    //폴더가 존재하지 않으면 새로운 폴더를 생성해줘라
	    File f = new File(path);
	    if(!f.exists())
	    	f.mkdirs();
	    
		try {
			String fname = file.getName();//키값 느낌?
			InputStream fis = file.getInputStream();
			//운영체제마다 연결 연산자 다르니까 File.separator로 해줘야함
			FileOutputStream fos = new FileOutputStream(path +File.separator+ fname);
			byte[] buf = new byte[1024];
				         
	        int size = 0;
	         
	         while((size = fis.read(buf, 0, 1024)) != -1)
	            fos.write(buf, 0, size);
			
			fis.close();
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//send해줘야함 원래는\
			//return "redirect:erropage";
		}
		/*file.getOriginalFilename();//
		file.getSize();//파일 크기 0일 수도 있으니까 검사
		file.isEmpty();//파일 안넣었을 때 조건 처리 할 때 사용
*/		int result = service.insertNote(note);
		return "redirect:list"; //list로 redirect 된다는 의미 / forward된다는 의미가 아님
	}
	

	@RequestMapping("data")
	@ResponseBody//그냥 바디야 문서로 출력해줘!
	public String data() {
		
		return "안녕하세요";
	}
}
