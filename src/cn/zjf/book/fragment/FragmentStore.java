package cn.zjf.book.fragment;

import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import cn.zjf.book.R;
import cn.zjf.book.adapter.BookAdapter;
import cn.zjf.book.entity.Book;
import cn.zjf.book.presenter.impl.StorePresenter;
import cn.zjf.book.view.IStoreView;

/**
 * Created by zjf 2016-6-25上午10:24:07
 */
public class FragmentStore extends Fragment implements IStoreView{
	@ViewInject(R.id.gvRecommend)
	private GridView gvRecommend;
	@ViewInject(R.id.gvHot)
	private GridView gvHot;
	@ViewInject(R.id.gvNew)
	private GridView gvNew;
	@ViewInject(R.id.tvStoreRecommendMore)
	private TextView tvRecommendMore;
	@ViewInject(R.id.tvHotMore)
	private TextView tvHotMore;
	@ViewInject(R.id.tvNewMore)
	private TextView tvNewMore;
	@ViewInject(R.id.etSearch)
	private EditText etSearch;
	private List<Book> recommendBooks;
	private List<Book> hotBooks;
	private List<Book> newBooks;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_store, null);
		//控件自动注入 控件初始化完毕
		x.view().inject(this,view);
		etSearch.clearFocus();
	StorePresenter sp=new StorePresenter(this,getActivity());
	sp.getRecommendBooks();
	sp.getHotBooks();
	sp.getNewBooks();
		return view;
	}


	@Override
	public void showRecommendBook(List<Book> books) {
		this.recommendBooks=books;
		BookAdapter adapter=new BookAdapter(getActivity(),books);
		gvRecommend.setAdapter(adapter);
		
	}


	@Override
	public void showHotBook(List<Book> books) {
		this.hotBooks=books;
		BookAdapter adapter=new BookAdapter(getActivity(), books);
		gvHot.setAdapter(adapter);
		
	}


	@Override
	public void showNewBook(List<Book> books) {
		// TODO Auto-generated method stub
		this.newBooks=books;
		BookAdapter adapter=new BookAdapter(getActivity(), books);
		gvNew.setAdapter(adapter);
	}
}
