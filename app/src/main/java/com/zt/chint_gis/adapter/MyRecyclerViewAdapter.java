package com.zt.chint_gis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zt.chint_gis.R;
import com.zt.chint_gis.bean.UserBean;

import java.util.List;

/**
 * Time:2020/7/31
 * Author:YCL
 * Description:
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<UserBean> DataList;
    private View inflater;


    public MyRecyclerViewAdapter(Context context, List<UserBean> DataList) {
        this.context = context;
        this.DataList = DataList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context).inflate(R.layout.user_recyclerview_item, parent, false);
        MyViewHolder MyHolder = new MyViewHolder(inflater);
        return MyHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userNumber.setText(DataList.get(position).getUserNumbers());
        holder.userName.setText(DataList.get(position).getUserName());
        holder.userAddress.setText(DataList.get(position).getUserAddress());
        if(DataList.get(position).isCheckedStatus()){
            holder.userStatus.setText("已安检");
        }else {
            holder.userStatus.setText("待安检");
        }
    }

    @Override
    public int getItemCount() {
        return DataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

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


}
