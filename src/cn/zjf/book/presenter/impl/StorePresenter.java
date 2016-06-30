package cn.zjf.book.presenter.impl;

import java.util.List;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import cn.zjf.book.entity.Book;
import cn.zjf.book.model.IModel.AsyncCallBack;
import cn.zjf.book.model.IStoreModel;
import cn.zjf.book.model.impl.StoreModel;
import cn.zjf.book.presenter.IStorePresenter;
import cn.zjf.book.view.IStoreView;

/**
 * Created by zjf 2016-6-29ÏÂÎç3:31:54
 */
public class StorePresenter implements IStorePresenter {
	private IStoreView view;
	private IStoreModel model;

	

	public StorePresenter(IStoreView view,Context context) {
		super();
		this.view = view;
		model=new StoreModel(context);
	}

	@Override
	public void getRecommendBooks() {
		model.loadRecommendBook(new AsyncCallBack() {

			public void onSuccess(List<Book> books) {
				view.showRecommendBook(books);

			}

			@Override
			public void onError() {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public void getHotBooks() {
		model.loadHotBook(new AsyncCallBack() {

			@Override
			public void onSuccess(List<Book> books) {
				view.showHotBook(books);
			}

			@Override
			public void onError() {

			}
		});

	}

	@Override
	public void getNewBooks() {
		model.loadNewBook(new AsyncCallBack() {

			@Override
			public void onSuccess(List<Book> books) {
				view.showNewBook(books);
			}

			@Override
			public void onError() {
				// TODO Auto-generated method stub

			}
		});
	}

}
