package com.zt.chint_gis.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zt.chint_gis.R;
import com.zt.chint_gis.bean.UserBean;

import java.util.ArrayList;

/**
 * Time:2020/8/1
 * Author:YCL
 * Description:
 */
public class MyRecyclerviewAdapter extends RecyclerView.Adapter<MyRecyclerviewAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<UserBean> DataList;
    private View inflate;
    private OnItemClikListener mOnItemClikListener;

    public MyRecyclerviewAdapter(Context context, ArrayList<UserBean> datalist) {
        this.mContext=context;
        this.DataList=datalist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(mContext).inflate(R.layout.user_recyclerview_item, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.userNumber.setText(DataList.get(position).getUserNumbers());
        holder.userName.setText(DataList.get(position).getUserName());
        holder.userAddress.setText(DataList.get(position).getUserAddress());


        if(DataList.get(position).isCheckedStatus()){
            holder.userStatus.setText("已安检");
            holder.userStatus.setTextColor(Color.BLUE);
        }else {
            holder.userStatus.setText("待安检");
            holder.userStatus.setTextColor(Color.RED);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserBean bean=DataList.get(position);
                mOnItemClikListener.onItemClik(holder.itemView,position,bean);
            }
        });

    }

    @Override
    public int getItemCount() {
        return DataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        TextView userNumber;
        TextView userName;
        TextView userAddress;
        TextView userStatus;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userNumber = itemView.findViewById(R.id.tv_UserNumber);
            userName = itemView.findViewById(R.id.tv_UserName);
            userAddress = itemView.findViewById(R.id.tv_UserAddress);
            userStatus = itemView.findViewById(R.id.tv_UserStatus);
        }
    }




    public interface  OnItemClikListener{
        void onItemClik(View view, int position,UserBean bean);
        void onItemLongClik(View view, int position);
    }
    public void setItemClikListener(OnItemClikListener OnItemClikListener) {
        this.mOnItemClikListener = OnItemClikListener;
    }


}
