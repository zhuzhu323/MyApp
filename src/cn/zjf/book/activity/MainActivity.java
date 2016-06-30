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
		//�ؼ��Զ�ע�� �ؼ���ʼ�����
		x.view().inject(this);
		intitData();
		vp.setOffscreenPageLimit(3);
		// ����Adapter
		setAdapter();
		// ���ü�����
		setListeners();

	}

	/**
	 * ���ü�����
	 */
	private void setListeners() {

		/**
		 * radioGroup������
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
		 * vp������
		 */
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrolled(int i,float v,int i2 ){
			if(v!=0){ //��ǰ�ǵ�3ҳ
				//���õ�����fragment header��͸����
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
	 * ����adapter
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
	 * ��ʼ������
	 */
	private void intitData() {
		fragments = new ArrayList<Fragment>();
		fragments.add(new FragmentStore());
		fragments.add(new FragmentCart());
		fragments.add(new FragmentMine());
	}

}
