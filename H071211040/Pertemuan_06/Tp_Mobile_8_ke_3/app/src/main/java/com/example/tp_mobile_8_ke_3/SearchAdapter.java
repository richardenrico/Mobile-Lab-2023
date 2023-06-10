package com.example.tp_mobile_8_ke_3;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.CardViewHolder>{
    private final ArrayList<UserModel> users;

    public SearchAdapter(ArrayList<UserModel> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public SearchAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new SearchAdapter.CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.CardViewHolder holder, int position) {
        UserModel user = users.get(position);

        holder.tv_name.setText(user.getName());
        holder.tv_username.setText(user.getUsername());
        holder.civ_profile.setImageResource(user.getProfilePicture());
        holder.rl_container_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel user = users.get(holder.getAdapterPosition());
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                intent.putExtra("pic", user.getProfilePicture());
                intent.putExtra("name", user.getName());
                intent.putExtra("username", user.getUsername());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout rl_container_item;
        ImageView civ_profile;
        TextView tv_name, tv_username;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            rl_container_item = itemView.findViewById(R.id.rl_container_item);

            civ_profile = itemView.findViewById(R.id.civ_profile);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_username = itemView.findViewById(R.id.tv_username);

        }
    }
}
