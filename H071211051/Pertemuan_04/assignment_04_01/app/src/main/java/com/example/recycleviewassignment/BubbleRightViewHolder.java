package com.example.recycleviewassignment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BubbleRightViewHolder extends DetailChatViewHolder {
    private final TextView tv_text;
    private final TextView tv_time;

    public BubbleRightViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_text = itemView.findViewById(R.id.tv_text);
        tv_time = itemView.findViewById(R.id.tv_time);
    }

    @Override
    public void setData(DetailChat chat) {
        tv_text.setText(chat.getChat());
        tv_time.setText(chat.getTime());
    }
}
