package com.newlecture.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.newlecture.entity.Note;

public interface NoteDao {
	
	/*마이바티스 어노테이션 방법*/
	/*@Select("select * from Note order by regDate desc" + 
			"		limit ${(page-1)*15}, 15")*/
	List<Note> getList(/*@Param("page") */Integer page);
	
	Note get(Integer id);
	
	int insert(Note note);
}
