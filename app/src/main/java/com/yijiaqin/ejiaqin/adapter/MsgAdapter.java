package com.yijiaqin.ejiaqin.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.yijiaqin.ejiaqin.R;
import com.yijiaqin.ejiaqin.entity.Msg;

import java.util.List;

/**
 * Created by 平塔岛象龟
 * 2018/4/9.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsgList;
    public MsgAdapter(List<Msg> msgList) {
        super();
        mMsgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if(msg.getType() == Msg.TYPE_RECEIVER){
//            如果是收到的消息，则显示左边的消息布局和头像，隐藏右边的消息布局和头像
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.rightIv.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
            holder.iv.setImageResource(msg.getImageView());
            holder.time.setText(msg.getTime());
        } else if(msg.getType() == Msg.TYPE_SEND){
//            隐藏左边的布局和头像，显示右边的消息和头像
            holder.leftLayout.setVisibility(View.GONE);
            holder.iv.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
            holder.iv.setImageResource(msg.getImageView());
            holder.time.setText(msg.getTime());
        }
    }



    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        ImageView iv;   //左边的头像
        TextView time;
        ImageView rightIv;  //右边的头像
        ViewHolder(View itemView) {
            super(itemView);
            leftLayout = (LinearLayout) itemView.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout) itemView.findViewById(R.id.right_layout);
            leftMsg = (TextView) itemView.findViewById(R.id.left_msg);
            rightMsg = (TextView) itemView.findViewById(R.id.right_msg);
            time = (TextView) itemView.findViewById(R.id.msg_item_time);
            iv = (ImageView) itemView.findViewById(R.id.msg_item_left_iv);
            rightIv = (ImageView) itemView.findViewById(R.id.msg_item_right_iv);
        }
    }
}
