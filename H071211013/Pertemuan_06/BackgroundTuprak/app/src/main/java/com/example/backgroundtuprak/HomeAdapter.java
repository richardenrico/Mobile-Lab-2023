package com.example.backgroundtuprak;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.backgroundtuprak.datasource.UserDataSource;
import com.example.backgroundtuprak.model.Post;
import com.example.backgroundtuprak.model.User;

import java.util.ArrayList;
import java.util.Collections;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private ArrayList<Post> posts;
    private Context context;

    public HomeAdapter(ArrayList<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
        Collections.reverse(this.posts);
    }

    @NonNull
    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.HomeViewHolder holder, int position) {
        Post post = posts.get(position);
        UserDataSource userDataSource = new UserDataSource();
        User user = userDataSource.getUserById(post.getUserId());

        holder.fullNameTextView.setText(user.getFullName());
        holder.userNameTextView.setText(user.getUserName());
        holder.captionTextView.setText(post.getCaption());
        holder.profileImage.setImageResource(user.getProfilePicture());

        if (user.getUserId() != 0) {
            holder.postImage.setImageResource(post.getImageInt());
        } else {
            holder.postImage.setImageURI(post.getImageUri());
        }

        holder.profileImage.setOnClickListener(v -> {
            User profile = new User(user.getUserId(), user.getFullName(), user.getUserName(), user.getProfilePicture());
            Intent intent = new Intent(context, DetailProfileActivity.class);
            intent.putExtra(DetailProfileActivity.KEY_PROFILE, profile);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView fullNameTextView, userNameTextView, captionTextView;
        ImageView profileImage, postImage;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            fullNameTextView = itemView.findViewById(R.id.fullname);
            userNameTextView = itemView.findViewById(R.id.username);
            captionTextView = itemView.findViewById(R.id.post_caption);
            profileImage = itemView.findViewById(R.id.profile_image);
            postImage = itemView.findViewById(R.id.post_image);
        }
    }
}