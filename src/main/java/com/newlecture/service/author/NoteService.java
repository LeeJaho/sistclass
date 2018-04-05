package com.newlecture.service.author;

import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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
				Document doc = Jsoup.parse(content);
				String text = doc.text();
				Elements imgs = doc.select("img");
				//System.out.println(imgs);
			if(text.length() > 250)
				//System.out.println(text.length());
				text = text.substring(0, 249);
			
			if(imgs.size() > 0)
				text += imgs.first().toString();
			
			
			
			n.setContent(text);			
		}
		/*Pattern pattern  =  Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
			Matcher match = pattern.matcher(content);
			String imgTag = null;
			
			if(match.find()){ // 이미지 태그를 찾았다면,,
			    imgTag = match.group(0); // 글 내용 중에 첫번째 이미지 태그를 뽑아옴.
			    n.setContent(imgTag+text);
			    System.out.println("imgTag : " + imgTag);
			}*/
		
		
		
		return list;
	}

	public Note getNote(Integer id) {
		
		Note note = noteDao.get(id);
		return note;
	}

}
