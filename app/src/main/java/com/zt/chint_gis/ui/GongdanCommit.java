package com.zt.chint_gis.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.animation.ObjectAnimator;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.opengl.Visibility;
import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.zt.chint_gis.AppApplication;
import com.zt.chint_gis.R;
import com.zt.chint_gis.database.AppDatabase;
import com.zt.chint_gis.database.SecuritycheckBean;
import com.zt.chint_gis.database.SecuritycheckDao;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 待安检用户详情展示界面
 */
public class GongdanCommit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gongdan_commit);
        Toolbar toolbar=findViewById(R.id.toolbar1);
         setSupportActionBar(toolbar);
         //toolbar关联侧滑菜单
        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        initView();
        initdrawaler();
        mAppdataBase=((AppApplication)getApplication()).getAppDatabase();
    }
    Boolean flag_rotate=true;
    /**
     * 初始化问题项
     */
    private int tag=1;
    private ImageView iv_img;
    private void initdrawaler() {
        ImageView rotate =findViewById(R.id.iv_rotateimg);
        RelativeLayout rl=findViewById(R.id.rl_rl);
        LinearLayout ll=findViewById(R.id.ll_ll);
        LinearLayout ll_item=findViewById(R.id.ll_item);
        iv_img=findViewById(R.id.iv_img);
        iv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag=2;
                PictureSelector.create(GongdanCommit.this)
                        .openCamera(PictureMimeType.ofImage())
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (ll_item.isShown()){
                    ObjectAnimator animator=  ObjectAnimator.ofFloat(rotate,"rotation",0f,180f);
                animator.setDuration(100);
                animator.start();
                ll_item.setVisibility(View.GONE);
                }else{
                 ObjectAnimator animator=  ObjectAnimator.ofFloat(rotate,"rotation",180f,360f);
                 animator.setDuration(100);
                 animator.start();
                 ll_item.setVisibility(View.GONE);
                    ll_item.setVisibility(View.VISIBLE);
                }

            }
        });


    }

    private ImageView iv_anjian;
    private boolean flag=true;
    private void initView() {
        TextView name=findViewById(R.id.cons_name);
        TextView no=findViewById(R.id.cons_no);
        TextView phone_number=findViewById(R.id.cons_phoneNumber);
        TextView address=findViewById(R.id.cons_address);
        TextView fac_number=findViewById(R.id.fac_number);
        TextView fac_type=findViewById(R.id.fac_type);
        TextView cons_read=findViewById(R.id.cons_read);
        ImageView iv_address_go=findViewById(R.id.iv_address_go);
        //复制地址
        iv_address_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager cmd= (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                cmd.setText(address.getText());
                Toast.makeText(GongdanCommit.this,"已复制",Toast.LENGTH_LONG).show();
            }
        });
        Button commit =findViewById(R.id.button_commit);
        //提交数据
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commit();
            }
        });
        TextView this_ymd=findViewById(R.id.this_ymd);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(System.currentTimeMillis());
        this_ymd.setText(format1);
        Intent intent =getIntent();
        //安检情况
        RadioGroup radioGroup=findViewById(R.id.rg_anjian);
            iv_anjian=findViewById(R.id.iv_current);
            iv_anjian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (flag){
                        PictureSelector.create(GongdanCommit.this)
                                .openCamera(PictureMimeType.ofImage())
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                        flag=false;
                    }else{
                        PictureSelector.create(GongdanCommit.this).externalPicturePreview(0, images);
                    }

                }
            });
      /*  String cons_name=intent.getStringExtra("UserName");
        String phone_NUmber=intent.getStringExtra("UserName");
        String cons_address=intent.getStringExtra("UserName");
        name.setText(cons_name);*/

    }
AppDatabase mAppdataBase;
    /**
     * 提交所有数据，或者保存
     */
    private void commit() {
        SecuritycheckBean bean=new SecuritycheckBean();
        bean.setCons_no("lly");
        bean.setCons_name("李凌云");
        mAppdataBase.userDao().insertcheckBean(bean);

        for (SecuritycheckBean securitycheckBean : mAppdataBase.userDao().addAllCheckBeans()) {
                Log.e("123",securitycheckBean.toString());
        }
    }

    List<LocalMedia> images;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
            switch(requestCode){
                case PictureConfig.CHOOSE_REQUEST:
                    Log.i("成功","dddd");
                    //图片选择的结果回调m
                    images= PictureSelector.obtainMultipleResult(data);
                   //图片显示
                    LocalMedia media = images.get(0);
                    String path="";
                    if (media.isCut() && !media.isCompressed()) {
                        // 裁剪过
                        path = media.getCutPath();
                    } else if (media.isCompressed() || (media.isCut() && media.isCompressed())) {
                        // 压缩过,或者裁剪同时压缩过,以最终压缩过图片为准
                        path = media.getCompressPath();
                    } else {
                        // 原图
                        path = media.getPath();
                    }
                    // 图片
                    if (media.isCompressed()) {
                        Log.i("compress image result:", new File(media.getCompressPath()).length() / 1024 + "k");
                        Log.i("压缩地址::", media.getCompressPath());
                    }

                    Log.i("原图地址::", media.getPath());
                    int pictureType = PictureMimeType.isPictureType(media.getPictureType());
                    if (media.isCut()) {
                        Log.i("裁剪地址::", media.getCutPath());
                    }
                    RequestOptions options = new RequestOptions()
                            .centerCrop()
                            .placeholder(R.color.backColor)
                            .diskCacheStrategy(DiskCacheStrategy.ALL);
                    switch (tag) {
                        case 2:
                            Glide.with(GongdanCommit.this)
                                    .load(path)
                                    .apply(options)
                                    .into(iv_img);

                            break;
                    }


            }
        }
    }
}