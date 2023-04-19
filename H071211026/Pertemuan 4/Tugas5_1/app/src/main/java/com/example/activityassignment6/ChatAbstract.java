package com.example.activityassignment6;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

abstract class ChatAbstract extends RecyclerView.ViewHolder {

    public ChatAbstract(@NonNull View itemView) {
        super(itemView);

    }

    public abstract void onBind(Chat chat);


}
