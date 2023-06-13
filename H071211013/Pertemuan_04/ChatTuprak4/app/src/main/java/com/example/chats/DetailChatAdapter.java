package com.example.chats;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailChatAdapter extends RecyclerView.Adapter<DetailChatAdapter.ViewHolder> {

    private ArrayList<DetailChat> detailChats;

    private static ViewHolder.ClickListener clickListener;
    public void setClickListener(ViewHolder.ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public DetailChatAdapter(ArrayList<DetailChat> detailChats) {
        this.detailChats = detailChats;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bubble_chat, parent, false);
        return new DetailChatAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetailChat detailchat = detailChats.get(position);
        holder.SetData(detailchat);
    }

    @Override
    public int getItemCount() {
        return detailChats.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView msg, time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            msg = itemView.findViewById(R.id.tv_msg);
            time = itemView.findViewById(R.id.tv_time);
        }

        public void SetData(DetailChat detailChat){
            msg.setText(detailChat.getMessage());
            time.setText(detailChat.getTime());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClicked(detailChat);
                }
            });
        }

        interface ClickListener{
            void onItemClicked(DetailChat detailChat);
        }
    }
}

