package com.lekrieg.learningjapanese.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.lekrieg.learningjapanese.Fragments.AnimalsFragment;
import com.lekrieg.learningjapanese.Fragments.NumbersFragment;
import com.lekrieg.learningjapanese.Fragments.ItemsFragment;
import com.lekrieg.learningjapanese.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

	private ViewPager viewPager;
	private SmartTabLayout viewPagerTab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportActionBar().setElevation(0);

		bindViews();
		configureViewPager();
	}

	private void bindViews() {
		viewPager = findViewById(R.id.viewPager);
		viewPagerTab = findViewById(R.id.viewPagerTab);
	}

	private void configureViewPager() {
		FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
				getSupportFragmentManager(), FragmentPagerItems.with(this)
				.add("Numbers", NumbersFragment.class)
				.add("Animals", AnimalsFragment.class)
				.add("Items", ItemsFragment.class)
				.create());

		viewPager.setAdapter(adapter);
		viewPagerTab.setViewPager(viewPager);
	}
}
