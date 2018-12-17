package com.example.materialdemo1;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class FruitActivity extends AppCompatActivity {

    private Fruit fruit;
    private Toolbar mToolbar;
    private ImageView mImageView;
    private TextView mContentText;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        initView();
        intData();

        mContentText.setText(getMoreData(fruit.getName()));

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mCollapsingToolbarLayout.setTitle(fruit.getName());

        Glide.with(this).load(fruit.getSrc()).into(mImageView);
    }

    /**
     * 获取数据
     */
    private void intData() {
        fruit = (Fruit) getIntent().getSerializableExtra("fruit");

    }

    /**
     * 初始化控件
     */
    private void initView() {
        mToolbar = findViewById(R.id.mToolBar);
        mImageView = findViewById(R.id.mImageView);
        mContentText = findViewById(R.id.mContentText);
        mCollapsingToolbarLayout = findViewById(R.id.mCollapsingToolbarLayout);

    }

    /**为TextView提供更多的数据
     * @param name
     * @return
     */
    private String getMoreData(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 1000; i++) {
            sb.append(name + "");
        }

        return sb.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
