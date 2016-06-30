package cn.zjf.book.view;

import java.util.List;

import cn.zjf.book.entity.Book;

/**
 * Created by zjf 2016-6-25上午10:58:56
 */
public interface IStoreView {
	/**
	 * 更新推荐图书列表
	 * 
	 * @param books
	 */

	void showRecommendBook(List<Book> books);

	/**
	 * 更新热销图书列表
	 * 
	 * @param books
	 */
	void showHotBook(List<Book> books);

	/**
	 * 更新最新上架图书列表
	 * 
	 * @param books
	 */
	void showNewBook(List<Book> books);
}
