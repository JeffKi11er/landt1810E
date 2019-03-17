package com.phongbm.filternews;

import android.app.SearchManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.phongbm.filternews.utils.DialogUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, XMLAsync.ParserXMLCallback {
    private RecyclerView lvNews;
    private NewsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        adapter = new NewsAdapter(this);
        lvNews = findViewById(R.id.lv_news);
        lvNews.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        SearchView searchView = (SearchView) menu.
                findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        if (s.isEmpty()){
            return false;
        }
        DialogUtils.show(this);
        XMLAsync async = new XMLAsync(this);
        async.execute(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public void onParserFinish(ArrayList<News> arr) {
        DialogUtils.dissmiss();
        adapter.setData(arr);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.menu_search:
//                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.menu_setting:
//                Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return true;
//    }
}
