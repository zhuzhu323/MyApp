package cn.zjf.book.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 *Created by zjf 2016-6-29ÏÂÎç5:21:30
 */
public class MainPageAdapter extends FragmentPagerAdapter{

	private List<Fragment> fragments;

	public MainPageAdapter(FragmentManager fm,List<Fragment> fragments) {
		super(fm);
		this.fragments=fragments;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int i) {
		// TODO Auto-generated method stub
		return fragments.get(i);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.size();
	}

}
