package com.example.background_thread.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.background_thread.data.model.User;
import com.example.background_thread.profile.ProfileActivity;
import com.example.background_thread.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    ArrayList<User> users;

    public PostAdapter (ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.itemdesign, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.ivPhoto.setImageURI(users.get(position).getPost().getPhoto());
        holder.tvCaption.setText(users.get(position).getPost().getCaption());
        holder.tvName.setText(users.get(position).getFullname());
        holder.tvUsername.setText(users.get(position).getUsername());
        holder.ivProfil.setImageResource(users.get(position).getProfile());

        holder.itemHeader.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
        System.out.println(user.getProfile());
            intent.putExtra(ProfileActivity.EXTRA_USER, user);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        ShapeableImageView ivProfil;
        TextView tvName, tvUsername, tvCaption;
        LinearLayout itemHeader;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.imgupload);
            ivProfil = itemView.findViewById(R.id.iv_profile);
            tvCaption = itemView.findViewById(R.id.tv_caption);
            tvName = itemView.findViewById(R.id.namaatas);
            tvUsername = itemView.findViewById(R.id.namabawah);
            itemHeader = itemView.findViewById(R.id.item_header);
        }
    }


}
