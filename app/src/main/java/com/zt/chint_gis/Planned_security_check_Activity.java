package com.zt.chint_gis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

import com.zt.chint_gis.adapter.MyRecyclerviewAdapter;
import com.zt.chint_gis.bean.UserBean;
import com.zt.chint_gis.utils.CustomDecoration;

import java.util.ArrayList;

public class Planned_security_check_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<UserBean> datalist;
    private MyRecyclerviewAdapter adapter;


    private LinearLayoutManager manager;
    private TitleBar mTitleBar;
    private ImageButton ib_reverse_order;
    private ImageButton ib_refresh;
    private TextView tv_unChecked_numbers;
    private LinearLayout loading_view_ll;
    private ImageView loading_view;
    private RelativeLayout rl_title;

    private boolean isReverse_order = false;//是否倒序

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_planned_security_check);
        initview();
        initdata();
        initevent();

    }

    private void initdata() {
        for (int i = 0; i < 20; i++) {
            UserBean bean = new UserBean();
            bean.setUserNumbers("2020" + i);
            bean.setUserName("林俊杰" + i);
            bean.setUserAddress("月明路250号正泰大厦1栋25楼第七排" + i);
            bean.setGasNumber("1234567890" + i);
            bean.setGasAccount("600" + i);
            bean.setGasType("物联网表");
            bean.setPhoneNumbers("18271671597");
            bean.setUserType("居民");
            bean.setCheckedStatus(false);
            datalist.add(bean);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 20; i++) {
                    UserBean bean = new UserBean();
                    bean.setUserNumbers("2020" + (i + 20));
                    bean.setUserName("特朗普" + (i + 20));
                    bean.setUserAddress("月明路250号正泰大厦1栋25楼第七排" + (i + 20));
                    bean.setGasNumber("1234567890" + (i + 20));
                    bean.setGasAccount("600" + (i + 20));
                    bean.setGasType("物联网表");
                    bean.setPhoneNumbers("18271671597");
                    bean.setUserType("居民");
                    bean.setCheckedStatus(false);
                    datalist.add(bean);
                }
            }
        }).start();

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

        adapter = new MyRecyclerviewAdapter(this, datalist);
        manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new CustomDecoration(this, LinearLayoutManager.VERTICAL, R.drawable.divider_mileage, 15));
        recyclerView.setAdapter(adapter);

        //定时器关闭数据加载动画
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                recyclerView.setVisibility(View.VISIBLE);
                rl_title.setVisibility(View.VISIBLE);
                loading_view_ll.setVisibility(View.GONE);
            }
        }, 1500);
        tv_unChecked_numbers.setText("待检户数:" + datalist.size());

        //TODO 倒序的功能，虽然不知道什么屌用
        ib_reverse_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isReverse_order) {
                    System.out.println("我要顺序");
                    manager.setStackFromEnd(false);
                    manager.setReverseLayout(false);
                    adapter.notifyDataSetChanged();
                    tv_unChecked_numbers.setText("待检户数:" + datalist.size());
                    isReverse_order = false;
                } else {
                    System.out.println("我要倒序");
                    manager.setStackFromEnd(true);
                    manager.setReverseLayout(true);
                    adapter.notifyDataSetChanged();
                    tv_unChecked_numbers.setText("待检户数:" + datalist.size());
                    isReverse_order = true;
                }
            }
        });

        //TODO 刷新
        ib_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyDataSetChanged();
                tv_unChecked_numbers.setText("待检户数:" + datalist.size());
            }
        });
        adapter.setItemClikListener(new MyRecyclerviewAdapter.OnItemClikListener() {
            @Override
            public void onItemClik(View view, int position, UserBean bean) {
                //TODO 可以传一个Bean过去
                Toast.makeText(getApplicationContext(), bean.getPhoneNumbers(), Toast.LENGTH_SHORT).show();
                /*TODO 传递bean到新页面
                *Intent intent=new Intent(DataList_Show_Activity.this,TestActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("bean",bean);
                intent.putExtras(bundle);
                startActivity(intent);*/
            }

            @Override
            public void onItemLongClik(View view, int position) {

            }
        });
    }

    private void initview() {
        mTitleBar = findViewById(R.id.mTitleBar);
        recyclerView = findViewById(R.id.rv_test);
        ib_reverse_order = findViewById(R.id.ib_reverse_order);
        ib_refresh = findViewById(R.id.ib_refresh);
        datalist = new ArrayList<>();
        tv_unChecked_numbers = findViewById(R.id.tv_UnChecked_Numbers);//待检户数


        rl_title = findViewById(R.id.rl_Title);//条目栏
        loading_view_ll = findViewById(R.id.loading_view_ll);//动画的控件
        loading_view = findViewById(R.id.loading_view);
        AnimationDrawable anim = (AnimationDrawable) loading_view.getDrawable();//开启动画
        anim.start();

    }
}
