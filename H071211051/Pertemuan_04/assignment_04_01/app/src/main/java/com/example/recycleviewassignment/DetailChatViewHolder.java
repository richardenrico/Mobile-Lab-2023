package com.example.recycleviewassignment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class DetailChatViewHolder extends RecyclerView.ViewHolder {
    public DetailChatViewHolder(@NonNull View itemView) {
        super(itemView.getRootView());
    }


    public abstract void  setData(DetailChat chat);
}
