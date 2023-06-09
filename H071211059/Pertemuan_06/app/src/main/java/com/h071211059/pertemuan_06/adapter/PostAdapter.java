package com.h071211059.pertemuan_06.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.h071211059.pertemuan_06.util.ProfileListener;
import com.h071211059.pertemuan_06.model.User;
import com.h071211059.pertemuan_06.databinding.ItemPostLayoutBinding;
import com.h071211059.pertemuan_06.model.Post;

import java.util.LinkedList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private ProfileListener profileListener;
    private final LinkedList<Object[]> posts;

    public PostAdapter(LinkedList<Object[]> posts) {
        this.posts = posts;
    }

    public void setClickListener(ProfileListener profileListener) {
        this.profileListener = profileListener;
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

        public void onBind(Object[] data) {
            User user = (User) data[0];
            Post post = (Post) data[1];

            binding.tvName.setText(user.getName());
            binding.tvUsername.setText(user.getUsername());
            binding.tvCaption.setText(post.getCaption());
            binding.ivProfile.setImageResource(user.getImage());
            Glide.with(binding.getRoot()).load(post.getImageUri()).into(binding.ivPostImage);

            binding.clProfile.setOnClickListener(v -> profileListener.onClick(user));
        }
    }

}
