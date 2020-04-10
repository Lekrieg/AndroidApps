package com.lekrieg.otakuextreme_prototype01.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.lekrieg.otakuextreme_prototype01.Fragment.AnimeFragment;
import com.lekrieg.otakuextreme_prototype01.Fragment.MangaFragment;
import com.lekrieg.otakuextreme_prototype01.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

	private SmartTabLayout smartTabLayout;
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		smartTabLayout = findViewById(R.id.viewPagerTab);
		viewPager = findViewById(R.id.viewPager);

		getSupportActionBar().setElevation(0);

		// 1 - Configurar um adapter para as abas
		FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
				FragmentPagerItems.with(this)
						.add("Animes", AnimeFragment.class)
						.add("Mangas", MangaFragment.class).create());

		viewPager.setAdapter(adapter);
		smartTabLayout.setViewPager(viewPager);

	}
}
