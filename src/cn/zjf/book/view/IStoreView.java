package cn.zjf.book.view;

import java.util.List;

import cn.zjf.book.entity.Book;

/**
 * Created by zjf 2016-6-25����10:58:56
 */
public interface IStoreView {
	/**
	 * �����Ƽ�ͼ���б�
	 * 
	 * @param books
	 */

	void showRecommendBook(List<Book> books);

	/**
	 * ��������ͼ���б�
	 * 
	 * @param books
	 */
	void showHotBook(List<Book> books);

	/**
	 * ���������ϼ�ͼ���б�
	 * 
	 * @param books
	 */
	void showNewBook(List<Book> books);
}
