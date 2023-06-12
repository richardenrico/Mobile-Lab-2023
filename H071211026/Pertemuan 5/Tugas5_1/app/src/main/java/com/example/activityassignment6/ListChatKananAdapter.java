package com.example.activityassignment6;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ListChatKananAdapter extends ChatAbstract{
    public ListChatKananAdapter(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void onBind(Chat chat) {
        TextView tvMessage, tvTime;
        tvMessage = itemView.findViewById(R.id.message);
        tvTime = itemView.findViewById(R.id.time);
    }
}
