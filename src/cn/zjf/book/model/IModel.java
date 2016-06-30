package cn.zjf.book.model;

import java.util.List;

import cn.zjf.book.entity.Book;

/**
 *Created by zjf 2016-6-29ионГ11:07:48
 */
public interface IModel {
public interface AsyncCallBack{
	public void onSuccess(List<Book> books);
	public void onError();
}
}
