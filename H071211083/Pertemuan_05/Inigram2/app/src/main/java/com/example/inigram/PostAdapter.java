package com.example.inigram;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    Context context;
    ArrayList<PostModel> posts = new ArrayList<>();

//    public void additem (PostModel post){
//        posts.add(post);
//        System.out.println("khgfd");
//    }

    public PostAdapter (Context context, ArrayList<PostModel> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdesign, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.ivPhoto.setImageURI(posts.get(position).getPhoto());
        holder.tvCaption.setText(posts.get(position).getCaption());
        holder.tvName.setText("Liska Dewi Rombe");
        holder.tvUsername.setText("Liska_");

        holder.itemHeader.setOnClickListener(v -> {
            Intent intent = new Intent(holder.ivProfil.getContext(), ProfileActivity.class);
            holder.ivPhoto.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        ShapeableImageView ivProfil;
        TextView tvName, tvUsername, tvCaption;
        LinearLayout itemHeader;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.imgupload);
            ivProfil = itemView.findViewById(R.id.image);
            tvCaption = itemView.findViewById(R.id.caption2);
            tvName = itemView.findViewById(R.id.namaatas);
            tvUsername = itemView.findViewById(R.id.namabawah);
            itemHeader = itemView.findViewById(R.id.item_header);
        }
    }

}

