package cn.zjf.book.entity;

import java.util.List;

/**
 *Created by zjf 2016-6-25ÉÏÎç11:16:08
 */
public class InBooks {
	private int code;
	private List<Book> data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<Book> getData() {
		return data;
	}
	public void setData(List<Book> data) {
		this.data = data;
	}
	
}

