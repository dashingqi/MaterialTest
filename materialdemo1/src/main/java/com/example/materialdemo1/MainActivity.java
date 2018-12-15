package com.example.materialdemo1;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private FloatingActionButton mFloatActionButton;

    private Fruit[] fruits = {new Fruit("apple", R.drawable.apple), new Fruit("banana", R.drawable.banana),
            new Fruit("cherry", R.drawable.cherry), new Fruit("grape", R.drawable.grape)};
    private List<Fruit> fruitList = new ArrayList<>();
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

        setSupportActionBar(mToolbar);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
        }

        mNavigationView.setCheckedItem(R.id.call);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        mFloatActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "delete data", Snackbar.LENGTH_LONG)
                        .setAction("done", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
                            }
                        }).show();
            }
        });

        MyAdapter myAdapter = new MyAdapter(fruitList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(myAdapter);
    }

    /**
     * 初始化好数据
     */
    private void initData() {
        Random random = new Random();

        for (int i = 0; i <= 50; i++) {
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }

    private void initView() {
        mToolbar = findViewById(R.id.mToolBar);
        mNavigationView = findViewById(R.id.mNavigationView);
        mDrawerLayout = findViewById(R.id.mDrawerLayout);
        mFloatActionButton = findViewById(R.id.mFloatActionButton);
        mRecyclerView = findViewById(R.id.mRecyclerView);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.delete:
                Log.d(TAG, "delete");
                break;
            case R.id.setting:
                Log.d(TAG, "setting");
                break;
            case R.id.download:
                Log.d(TAG, "download");
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }
}
