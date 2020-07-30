package com.zt.chint_gis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private ImageView mIvAllImg;
    private TextView mTvAll;
    private TextView mTvAllDes;
    private ImageView mIvUnCompleted;
    private TextView mTvUnCompleted;
    private TextView mTvUnCompletedDes;
    private ImageView mIvCompleted;
    private TextView mTvCompleted;
    private TextView mTvCompletedDes;
    private TextView mTvTip;
    private LinearLayout mLlTipContent;
    private TextView mTvTipContent;
    private TextView mTvTipTime;
    private TextView mTvInspection;
    private GridView mGv;

    private int icons[] = {R.drawable.planned_security_check, R.drawable.sampling_security_check, R.drawable.achievements};
    private String names[] = {"计划安检", "抽样安检", "安检绩效"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        initview();
        initevent();


    }

    private void initevent() {
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    //TODO 计划安检
                    case 0:
                        //TODO 添加到跳转到计划巡检的页面
                        //123
                        //杨成雷
                        Intent intent=new Intent(HomeActivity.this,Planned_security_check_Activity.class);
                        startActivity(intent);
                        break;
                    //TODO 抽样安检
                    case 1:
                        break;
                    //TODO　安检绩效
                    case 2:

                        break;
                }
            }
        });
    }

    private void initview() {
        mIvAllImg = findViewById(R.id.iv_All_img);
        mTvAll = findViewById(R.id.tv_All_);
        mTvAllDes = findViewById(R.id.tv_All_Des);
        mIvUnCompleted = findViewById(R.id.iv_UnCompleted);
        mTvUnCompleted = findViewById(R.id.tv_UnCompleted_);
        mTvUnCompletedDes = findViewById(R.id.tv_UnCompleted_Des);
        mIvCompleted = findViewById(R.id.iv_Completed);
        mTvCompleted = findViewById(R.id.tv_Completed_);
        mTvCompletedDes = findViewById(R.id.tv_Completed_Des);
        mTvTip = findViewById(R.id.tv_Tip);
        mLlTipContent = findViewById(R.id.ll_Tip_Content);
        mTvTipContent = findViewById(R.id.tv_Tip_Content);
        mTvTipTime = findViewById(R.id.tv_Tip_Time);
        mTvInspection = findViewById(R.id.tv_Inspection);
        mGv = findViewById(R.id.gv_);
        Myadapter adapter = new Myadapter();
        mGv.setAdapter(adapter);
    }

    private class Myadapter extends BaseAdapter {
        @Override
        public int getCount() {
            return icons.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(getApplicationContext(), R.layout.gridview_item, null);
            TextView name = view.findViewById(R.id.tv_item_home_gv_name);
            ImageView icon = view.findViewById(R.id.iv_item_home_gv_icon);
            name.setText(names[position]);
            icon.setImageResource(icons[position]);
            return view;
        }
    }
}
