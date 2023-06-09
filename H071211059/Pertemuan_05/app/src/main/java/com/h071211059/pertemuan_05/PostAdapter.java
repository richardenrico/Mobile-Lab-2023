package com.h071211059.pertemuan_05;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h071211059.pertemuan_05.databinding.ItemPostLayoutBinding;

import java.util.LinkedList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private ClickListener clickListener;
    private final LinkedList<Post> posts;

    public PostAdapter(LinkedList<Post> posts) {
        this.posts = posts;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostLayoutBinding binding = ItemPostLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        holder.onBind(posts.get(position));

    }

    @Override
    public int getItemCount() {
        return this.posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private ItemPostLayoutBinding binding;

        public PostViewHolder(@NonNull ItemPostLayoutBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(Post post) {
            binding.ivPostImage.setImageURI(post.getImageUri());
            binding.tvCaption.setText(post.getCaption());
            binding.clProfile.setOnClickListener(v -> clickListener.onClick());
        }
    }

    interface ClickListener{
       void onClick();
    }
}
