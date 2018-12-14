package cn.dashingqi.com.materialtest;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Toolbar mToolbar;
    private TextView mTextView;
    private DrawerLayout mDrawerLayout;
    private NavigationView navView;
    private FloatingActionButton mFloatingActionButton;
    private RecyclerView mRecyclerView;
    private Fruit[] fruits = {new Fruit(R.drawable.apple, "apple"), new Fruit(R.drawable.banana, "banana"),
            new Fruit(R.drawable.cherry, "cherry"), new Fruit(R.drawable.grape, "grape")};
    private List<Fruit> fruitList = new ArrayList<>();
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        //设置默认选中
        navView.setCheckedItem(R.id.friend);

        //设置item点击事件
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //mDrawerLayout.closeDrawers();
                return false;
            }
        });

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "data deleted", Snackbar.LENGTH_LONG)
                        .setAction("undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "HelloWorld", Toast.LENGTH_LONG).show();
                            }
                        }).show();
            }
        });

        initData();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        final MyAdapter myAdapter = new MyAdapter(fruitList);
        mRecyclerView.setAdapter(myAdapter);

        //设置下拉刷新的颜色
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initData();
                                myAdapter.notifyDataSetChanged();
                                mSwipeRefreshLayout.setRefreshing(false);
                            }
                        });

                    }
                }).start();
            }
        });


    }

    private void
    initData() {
        for (int i = 0; i <= 51; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);

        }
    }

    private void initView() {
        mToolbar = findViewById(R.id.mToolbar);
        //mTextView = findViewById(R.id.mStartTextView);
        mDrawerLayout = findViewById(R.id.mDrawerLayout);
        navView = findViewById(R.id.nav_view);
        mFloatingActionButton = findViewById(R.id.mFloatingActionButton);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        mSwipeRefreshLayout = findViewById(R.id.mSwipeRefreshLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.delete:
                Log.d("delete", "delete");
                break;
            case R.id.download:
                Log.d("download", "download");
                break;
            case R.id.setting:
                Log.d("setting", "setting");
                break;
        }
        return true;
    }
}
