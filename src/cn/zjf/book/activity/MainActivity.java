package cn.zjf.book.activity;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import cn.zjf.book.R;
import cn.zjf.book.fragment.FragmentCart;
import cn.zjf.book.fragment.FragmentMine;
import cn.zjf.book.fragment.FragmentStore;

public class MainActivity extends FragmentActivity {
	@ViewInject(R.id.vp_pagers)
	private ViewPager vp;

	@ViewInject(R.id.rgShouyeMenu)
	private RadioGroup rg;

	@ViewInject(R.id.rbShucheng)
	private RadioButton rbBookStore;

	@ViewInject(R.id.rbCart)
	private RadioButton rbShopCart;

	@ViewInject(R.id.rbMine)
	private RadioButton rbMine;

	private ArrayList<Fragment> fragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//控件自动注入 控件初始化完毕
		x.view().inject(this);
		intitData();
		vp.setOffscreenPageLimit(3);
		// 设置Adapter
		setAdapter();
		// 设置监听器
		setListeners();

	}

	/**
	 * 设置监听器
	 */
	private void setListeners() {

		/**
		 * radioGroup监听器
		 */
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rbShucheng:
					vp.setCurrentItem(0);
					break;
				case R.id.rbCart:
					vp.setCurrentItem(1);
					break;
				case R.id.rbMine:
					vp.setCurrentItem(2);
					break;

				}

			}
		});
		/**
		 * vp监听器
		 */
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrolled(int i,float v,int i2 ){
			if(v!=0){ //当前是第3页
				//设置第三个fragment header的透明度
				FragmentMine fragment = (FragmentMine) fragments.get(2);
				fragment.slide(v);
			}
		}
			
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					rbBookStore.setChecked(true);
					break;
				case 1:
					rbShopCart.setChecked(true);
					break;
				case 2:
					rbMine.setChecked(true);
					break;

				}

			}

		

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	/**
	 * 设置adapter
	 */
	private void setAdapter() {
		PagerAdapter adapter = new FragmentPagerAdapter(
				getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return fragments.size();
			}

			@Override
			public Fragment getItem(int arg0) {

				return fragments.get(arg0);
			}

		};
		vp.setAdapter(adapter);
	}

	/**
	 * 初始化数据
	 */
	private void intitData() {
		fragments = new ArrayList<Fragment>();
		fragments.add(new FragmentStore());
		fragments.add(new FragmentCart());
		fragments.add(new FragmentMine());
	}

}
