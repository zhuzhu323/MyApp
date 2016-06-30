package cn.zjf.book.model.impl;

import java.util.List;

import android.content.Context;
import android.util.Log;
import cn.zjf.book.app.Myapplication;
import cn.zjf.book.entity.Book;
import cn.zjf.book.model.IStoreModel;
import cn.zjf.book.util.GlobalConsts;
import cn.zjf.book.util.JSonParser;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by zjf 2016-6-25上午11:01:12
 */
public class StoreModel implements IStoreModel {
	private RequestQueue queue;
	private Context context;
	private Myapplication app;

	public StoreModel(Context context) {
		this.context = context;
	}

	@Override
	public void loadHotBook(final AsyncCallBack callBack) {
		app = Myapplication.getContext();
		queue = app.getQueue();
		StringRequest r = new StringRequest(
				GlobalConsts.URL_LOAD_HOT_BOOK_LIST, new Listener<String>() {
					@Override
					public void onResponse(String arg0) {
						// 解析json字符串
						List<Book> books = JSonParser.getBooks(arg0);
						callBack.onSuccess(books);
					}

				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						Log.i("zjf", "添加热门书籍信息失败，请再次尝试");

					}
				});
		queue.add(r);

	}

	@Override
	public void loadNewBook(final AsyncCallBack callBack) {
		StringRequest r = new StringRequest(
				GlobalConsts.URL_LOAD_NEW_BOOK_LIST, new Listener<String>() {

					@Override
					public void onResponse(String arg0) {
						// TODO Auto-generated method stub
						// 解析json字符串
						List<Book> books = JSonParser.getBooks(arg0);
						callBack.onSuccess(books);
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						Log.i("zjf", "添加新书信息失败，请再次尝试");

					}
				});
		queue.add(r);
	}

	@Override
	public void loadRecommendBook(final AsyncCallBack callBack) {
		// TODO Auto-generated method stub
		StringRequest r = new StringRequest(
				GlobalConsts.URL_LOAD_HOT_BOOK_LIST, new Listener<String>() {

					@Override
					public void onResponse(String arg0) {
						List<Book> books = JSonParser.getBooks(arg0);
						callBack.onSuccess(books);
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						Log.i("zjf", "添加推荐图书信息失败，请再次尝试");
					}
				});
		queue.add(r);
	}

}
