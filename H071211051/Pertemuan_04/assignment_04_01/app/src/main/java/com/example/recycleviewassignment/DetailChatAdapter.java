package com.example.recycleviewassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailChatAdapter extends RecyclerView.Adapter<DetailChatViewHolder>{
    private final ArrayList<DetailChat> chats;

    public DetailChatAdapter(ArrayList<DetailChat> chats) {
        this.chats = chats;
    }

    @Override
    public int getItemViewType(int position) {
        DetailChat chat = chats.get(position);
        return chat.isLeft() ? 0 : 1;
    }

    @NonNull
    @Override
    public DetailChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bubble_chat_right, parent, false);
//        return new DetailChatAdapter.ViewHolder(view);
        switch (viewType) {
            case 0 :
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bubble_chat_left, parent, false);
                return new BubbleLeftViewHolder(view);
            case 1 :
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bubble_chat_right, parent, false);
                return new BubbleRightViewHolder(view1);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailChatViewHolder holder, int position) {
        DetailChat chat = chats.get(position);
        holder.setData(chat);
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_chat;
        private final TextView tv_time;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_chat = itemView.findViewById(R.id.tv_text);
            tv_time = itemView.findViewById(R.id.tv_time);
        }

        public void setData(DetailChat chat) {
            tv_chat.setText(chat.getChat());
            tv_time.setText(chat.getTime());
        }
    }
}
