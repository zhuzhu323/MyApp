package cn.zjf.book.fragment;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import cn.zjf.book.R;
import cn.zjf.book.view.IMineView;
import android.R.layout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 *Created by zjf 2016-6-25ÉÏÎç10:33:19
 */
public class FragmentMine extends Fragment implements IMineView{
	@ViewInject(R.id.relativeMineHeader)
	private RelativeLayout mineHeader;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_mine, null);
				// TODO Auto-generated method stub
		x.view().inject(this, view);
		return view;
}
	public void slide(float v) {
		mineHeader.setAlpha(v);
	}

}
