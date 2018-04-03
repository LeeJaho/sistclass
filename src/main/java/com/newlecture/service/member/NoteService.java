package com.newlecture.service.member;

import java.util.List;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.dao.NoteDao;
import com.newlecture.entity.Note;

public class NoteService {
	
	@Autowired
	private NoteDao noteDao;
	
	public int insertNote(Note note) {
		
		noteDao.insert(note);
		return 0;  
	}

	public List<Note> getNoteList(int page) {
		
		List<Note> list = noteDao.getList(page);
		
		for(Note n : list) {
			String content = n.getContent();
			
			if(content == null) continue;
			String text = Jsoup.parse(content).text();
			
			if(text.length() > 250)
				//System.out.println(text.length());
				text = text.substring(0, 249);
			
			n.setContent(text);
						
		}
		
		
		
		return list;
	}

}
