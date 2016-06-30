package cn.zjf.book.app;

import org.xutils.x;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by zjf 2016-6-25ÉÏÎç10:03:24
 */
public class Myapplication extends Application {
	private static Myapplication context;
	private RequestQueue queue;

	public void setQueue(RequestQueue queue) {
		this.queue = queue;
	}

	public RequestQueue getQueue() {
		return queue;
		// TODO Auto-generated method stub

	}

	public void onCreate() {
		super.onCreate();
		x.Ext.init(this);
		context=this;
		queue = Volley.newRequestQueue(this);
	}

	public static Myapplication getContext() {
		return context;
	}

}
