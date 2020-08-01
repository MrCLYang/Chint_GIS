package com.zt.chint_gis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.media.DrmInitData;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.zt.chint_gis.adapter.MyRecyclerViewAdapter;
import com.zt.chint_gis.bean.UserBean;
import com.zt.chint_gis.utils.CustomDecoration;

import java.util.ArrayList;

public class Planned_security_check_Activity extends AppCompatActivity {

    private TitleBar mTitleBar;
    private RecyclerView rv_check_list;
    private ArrayList<UserBean> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_planned_security_check);
        initdata();
        initview();
    }

    private void initdata() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    UserBean bean=new UserBean();
                    bean.setUserNumbers("2020"+i);
                    bean.setUserName("杨成雷"+i);
                    bean.setUserAddress("月明路正太大厦25楼"+i);
                    bean.setCheckedStatus(false);
                    dataList.add(bean);
                }
            }
        }).start();
    }

    @SuppressLint("WrongConstant")
    private void initview() {
        mTitleBar = findViewById(R.id.mTitleBar);
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

        rv_check_list = findViewById(R.id.rv_Check_List);
        dataList = new ArrayList<>();
        MyRecyclerViewAdapter myRecyclerViewAdapter=new MyRecyclerViewAdapter(this,dataList);
        LinearLayoutManager manager=new LinearLayoutManager(Planned_security_check_Activity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_check_list.setLayoutManager(manager);
        rv_check_list.addItemDecoration(new CustomDecoration(
                this, LinearLayoutManager.VERTICAL, R.drawable.divider_mileage, 15));
        rv_check_list.setAdapter(myRecyclerViewAdapter);
    }
}
