package com.example.recycleviewassignment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private final ArrayList<Data> data;

    public ChatAdapter(ArrayList<Data> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        Data datas = data.get(position);
        holder.setData(datas);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), ChatActivity.class);
            intent.putExtra(ChatActivity.EXTRA_CHAT, datas);
            holder.itemView.getContext().startActivity(intent);
        });
        holder.iv_profile.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), ImageDetailActivity.class);
            intent.putExtra(ImageDetailActivity.EXTRA_CHAT, datas);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_name;
        private final TextView tv_recentChat;
        private final CircleImageView iv_profile;
        private final TextView tv_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_recentChat = itemView.findViewById(R.id.tv_recentChat);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_time = itemView.findViewById(R.id.tv_time);
        }

        public void setData(Data datas) {
            tv_name.setText(datas.getName());
            tv_recentChat.setText(datas.getMessage());
            Glide.with(itemView.getContext()).load(datas.getPhoto_profile()).apply(new RequestOptions().override(350, 550)).into(iv_profile);
            tv_time.setText(datas.getTime());
        }
    }
}
