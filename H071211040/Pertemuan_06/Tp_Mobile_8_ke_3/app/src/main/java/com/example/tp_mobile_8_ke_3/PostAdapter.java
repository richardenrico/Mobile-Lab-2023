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

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.CardViewHolder> {
    private final ArrayList<UserModel> users;
    public PostAdapter(ArrayList<UserModel> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        UserModel user = users.get(position);

        holder.civ_profile.setImageResource(user.getProfilePicture());
        holder.tv_name.setText(user.getName());
        holder.tv_username.setText(user.getUsername());

        holder.iv_post_image.setImageURI(user.getPost().getImg_post());
        holder.tv_caption.setText(user.getPost().getCaption());


        holder.rl_profile.setOnClickListener(new View.OnClickListener() {
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

        RelativeLayout rl_profile;
        TextView tv_name, tv_username, tv_caption;
        ImageView civ_profile, iv_post_image;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            rl_profile = itemView.findViewById(R.id.rl_profile);

            civ_profile = itemView.findViewById(R.id.civ_profile);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_caption = itemView.findViewById(R.id.tv_caption);
            iv_post_image = itemView.findViewById(R.id.iv_post_image);
        }
    }
}
