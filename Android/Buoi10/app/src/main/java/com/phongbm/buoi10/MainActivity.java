package com.phongbm.buoi10;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.phongbm.buoi10.adapter.PageAdapter;
import com.phongbm.buoi10.fragments.FavoriteFragment;
import com.phongbm.buoi10.fragments.NewsFragment;
import com.phongbm.buoi10.fragments.SavedFragment;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private NewsFragment fmNews = new NewsFragment();
    private SavedFragment fmSave = new SavedFragment();
    private FavoriteFragment fmFavorite = new FavoriteFragment();
    private ViewPager pager;
    private PageAdapter adapter;
    private TabLayout tabTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        pager = findViewById(R.id.pager);
        adapter = new PageAdapter(getSupportFragmentManager(),
                fmNews, fmSave, fmFavorite);
        pager.setAdapter(adapter);
        tabTitle = findViewById(R.id.tab_title);
        tabTitle.setupWithViewPager(pager);

        pager.addOnPageChangeListener(this);
    }

    public NewsFragment getFmNews() {
        return fmNews;
    }

    public SavedFragment getFmSave() {
        return fmSave;
    }

    public FavoriteFragment getFmFavorite() {
        return fmFavorite;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        Log.e(getClass().getName(), "onPageSelected- " + i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() == 0) {
            super.onBackPressed();
        }else{
            pager.setCurrentItem(0);
        }
    }
}
