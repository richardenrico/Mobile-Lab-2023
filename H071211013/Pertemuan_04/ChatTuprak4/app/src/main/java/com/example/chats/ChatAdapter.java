package com.example.chats;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private ArrayList<Chats> user;
    private Context context;
    public ChatAdapter(ArrayList<Chats> user){
        this.user = user;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName,userChat,userJam;
        CircleImageView userPict;
        ConstraintLayout parentlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentlayout = itemView.findViewById(R.id.parent_layout);

            userName = itemView.findViewById(R.id.tv_name);
            userChat = itemView.findViewById(R.id.tv_chat);
            userJam = itemView.findViewById(R.id.tv_jam);
            userPict = itemView.findViewById(R.id.iv_profil);
        }

        public void setData(Chats chat){
            Chats c1 = new Chats(chat.getNama(),chat.getChat(),chat.getJam(),chat.getNumber(),chat.getStatus(),chat.getTgl_stat(),chat.getImg());
            userName.setText(chat.getNama());
            userChat.setText(chat.getChat());
            userJam.setText(chat.getJam());
            userPict.setImageResource(chat.getImg());

            itemView.setOnClickListener(view -> {
                Intent kirim = new Intent(itemView.getContext(), MainActivity2.class);
                kirim.putExtra("user",c1);
                itemView.getContext().startActivity(kirim);
            });
            userPict.setOnClickListener(view -> {
                Intent pict = new Intent(userPict.getContext(), img_detail.class);
                pict.putExtra("user",c1);
                userPict.getContext().startActivity(pict);
            });
        }
    }

    @NonNull
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chats c1 = user.get(position);
        holder.setData(c1);
    }

    @Override
    public int getItemCount() {
        return user.size();
    }

}
