package com.newlecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.dao.NoteDao;
import com.newlecture.entity.Note;

@Service
public class NoteService {

	@Autowired
	private NoteDao noteDao;
	
	public List<Note> getNoteList(Integer page) {
		
		//noteDao = new ?();
		List<Note> list = noteDao.getList(page);
		return list;
	}

	public Note getNote(Integer id) {
		
		noteDao.get(id);
		return null;
	}
	
}
