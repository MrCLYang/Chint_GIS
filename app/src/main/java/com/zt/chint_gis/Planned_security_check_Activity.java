package com.zt.chint_gis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zt.chint_gis.adapter.MyRecyclerviewAdapter;
import com.zt.chint_gis.bean.UserBean;
import com.zt.chint_gis.utils.CustomDecoration;

import java.util.ArrayList;

public class Planned_security_check_Activity extends AppCompatActivity {

    private TitleBar mTitleBar;
    private RecyclerView recyclerView;
    private ArrayList<UserBean> datalist;
    private MyRecyclerviewAdapter adapter;
    private RefreshLayout refreshLayout;


    private boolean refreshType;
    private int page;
    private int oldListSize;
    private int newListSize;
    private int addListSize;
    private LinearLayoutManager manager;
    private DividerItemDecoration itemDecoration;
    private ImageView mLoadingView;
    private LinearLayout ll_loadingView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_planned_security_check);
        initview();
        initevent();
    }
    private void initview() {
        mTitleBar = findViewById(R.id.mTitleBar);
        recyclerView = findViewById(R.id.rv_test);
        refreshLayout = findViewById(R.id.refreshLayout);
        mLoadingView = findViewById(R.id.loading_view);
        ll_loadingView = findViewById(R.id.loading_view_ll);
        AnimationDrawable anim = (AnimationDrawable) mLoadingView.getDrawable();
        anim.start();
        datalist = new ArrayList<>();
    }

    private void initevent() {
        mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View v) {
                finish();
            }

            @Override
            public void onTitleClick(View v) {

            }

            @Override
            public void onRightClick(View v) {

            }
        });


        //TODO 刷新监听
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshType = true;
                        page=1;
                        DataDoing();
                        refreshLayout.finishRefresh();
                        refreshLayout.resetNoMoreData();
                    }
                }, 1000);
            }
        });

        //TODO 加载更新监听
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshType = false;
                        if (page>2) {
                            Toast.makeText(getApplicationContext(), "暂无更多的数据", Toast.LENGTH_SHORT).show();
                            refreshLayout.finishLoadMoreWithNoMoreData();
                            return;
                        }
                        DataDoing();
                        refreshLayout.setEnableLoadMore(true);
                        refreshLayout.finishLoadMore();

                    }
                }, 1000);
            }
        });
        refreshLayout.autoRefresh();
    }

    private void DataDoing() {
        //TODO 刷新数据
        if(refreshType&& datalist!=null){
            datalist.clear();
            oldListSize=0;
        }else {
            oldListSize=datalist.size();
        }
        //TODO 假数据
        if(page==1){
            for (int i = 0; i < 20; i++) {
                UserBean bean=new UserBean();
                bean.setUserNumbers("2020"+i);
                bean.setUserName("杨成雷"+i);
                bean.setUserAddress("月明路正太大厦25楼"+i);
                bean.setCheckedStatus(false);
                datalist.add(bean);
            }
        }else  if(page==2){
            for (int i = 0; i < 10; i++) {
                UserBean bean=new UserBean();
                bean.setUserNumbers("2020"+(i+20));
                bean.setUserName("杨成雷"+(i+20));
                bean.setUserAddress("月明路正太大厦25楼"+(i+20));
                bean.setCheckedStatus(false);
                datalist.add(bean);
            }
        }

        //新的list数据
        newListSize=datalist.size();
        //再次加载的数据
        addListSize=newListSize-oldListSize;//
        if (refreshType) {
            adapter = new MyRecyclerviewAdapter(this, datalist);
            manager = new LinearLayoutManager(this);
            manager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(manager);
            recyclerView.addItemDecoration(new CustomDecoration(this, LinearLayoutManager.VERTICAL, R.drawable.divider_mileage, 15));
            recyclerView.setAdapter(adapter);
        } else {
            //从那个位置添加
            adapter.notifyItemRangeInserted(datalist.size()-addListSize, datalist.size());
            adapter.notifyItemRangeChanged(datalist.size()-addListSize, datalist.size());
        }
        page++;
        recyclerView.setVisibility(View.VISIBLE);
        ll_loadingView.setVisibility(View.GONE);
        adapter.setItemClikListener(new MyRecyclerviewAdapter.OnItemClikListener() {
            @Override
            public void onItemClik(View view, int position) {
                Toast.makeText(getApplicationContext(),datalist.get(position).getUserName(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClik(View view, int position) {

            }
        });
    }



}
