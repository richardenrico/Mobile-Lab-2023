package com.example.background_thread.search;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.background_thread.R;
import com.example.background_thread.data.model.User;
import com.example.background_thread.profile.ProfileActivity;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<User> users = new ArrayList<>();

    public  void setUsers(ArrayList<User> users ){
        if (this.users.size() > 0) this.users.clear();
        this.users.addAll(users);
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.ivProfile.setImageResource(user.getProfile());
        holder.tvName.setText(user.getFullname());
        holder.tvUsername.setText(user.getUsername());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.ivProfile.getContext(), ProfileActivity.class);
            intent.putExtra(ProfileActivity.EXTRA_USER, user);
            holder.ivProfile.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView ivProfile;
        TextView tvName, tvUsername;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProfile = itemView.findViewById(R.id.iv_profile);
            tvName = itemView.findViewById(R.id.tv_name);
            tvUsername = itemView.findViewById(R.id.tv_username);
        }
    }
}
