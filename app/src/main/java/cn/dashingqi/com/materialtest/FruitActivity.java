package cn.dashingqi.com.materialtest;

import android.app.Person;
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

    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbar;
    private ImageView fruitImageView;
    private TextView fruitTextView;
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_SRC = "fruit_src";
    private String fruitName;
    private int fruitSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        initView();
        initData();
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Glide.with(this).load(fruitSrc).into(fruitImageView);
        mCollapsingToolbar.setTitle(fruitName);
        fruitTextView.setText(getFruitContent(fruitName));

    }

    private void initData() {
        fruitName = getIntent().getStringExtra(FruitActivity.FRUIT_NAME);
        fruitSrc = getIntent().getIntExtra(FRUIT_SRC, 0);
    }

    private void initView() {
        mToolbar = findViewById(R.id.mToolbar);
        mCollapsingToolbar = findViewById(R.id.collapsing_toolbar);
        fruitImageView = findViewById(R.id.fruit_image_view);
        fruitTextView = findViewById(R.id.fruit_text_view);
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

    private StringBuilder getFruitContent(String fruitName){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<=500;i++){
            sb.append(fruitName);
        }

        return sb;
    }
}
