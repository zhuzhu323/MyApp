package cn.zjf.book.util;

import java.util.List;

import cn.zjf.book.entity.Book;
import cn.zjf.book.entity.InBooks;

import com.google.gson.Gson;

public class JSonParser {
	public static List<Book> getBooks(String json){
		Gson gson=new Gson();
		InBooks i=gson.fromJson(json, InBooks.class);
		return i.getData();
	}
}
