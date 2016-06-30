package cn.zjf.book.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.zjf.book.R;
import cn.zjf.book.app.Myapplication;
import cn.zjf.book.entity.Book;
import cn.zjf.book.util.GlobalConsts;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;

/**
 * Created by zjf 2016-6-25ÉÏÎç10:35:25
 */
public class BookAdapter extends BaseAdapter {

	private List<Book> books;
	private Context context;
	private LayoutInflater inflater;

	public BookAdapter(Context context, List<Book> books) {
		this.books = books;
		this.context = context;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return books.size();
	}

	@Override
	public Book getItem(int position) {
		// TODO Auto-generated method stub
		return books.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		Book b = books.get(position);
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item_store_gv_book,
					null);
			holder = new ViewHolder();
			holder.iv = (ImageView) convertView
					.findViewById(R.id.iv_item_store_book);
			holder.tv = (TextView) convertView
					.findViewById(R.id.tv_item_store_book);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tv.setText(b.getDescription());
		Myapplication app = (Myapplication) context.getApplicationContext();
		RequestQueue q = app.getQueue();
		ImageLoader imageLoader = new ImageLoader(q, new BitmapCache());
		ImageListener listener = imageLoader.getImageListener(holder.iv,
				R.drawable.ic_launcher, R.drawable.ic_launcher);
		imageLoader.get(
				GlobalConsts.BASEURL + "productImages/" + b.getProduct_pic(),
				listener);

		return convertView;
	}

	public class BitmapCache implements ImageCache {
		private LruCache<String, Bitmap> mCache;

		public BitmapCache() {
			int maxSize = 10 * 1024 * 1024;
			mCache = new LruCache<String, Bitmap>(maxSize) {
				@Override
				protected int sizeOf(String key, Bitmap value) {
					return value.getRowBytes() * value.getHeight();
				}
			};
		}

		@Override
		public Bitmap getBitmap(String arg0) {
			// TODO Auto-generated method stub
			return mCache.get(arg0);
		}

		@Override
		public void putBitmap(String arg0, Bitmap arg1) {
			mCache.put(arg0, arg1);

		}

	}

	public class ViewHolder {
		ImageView iv;
		TextView tv;
	}
}
