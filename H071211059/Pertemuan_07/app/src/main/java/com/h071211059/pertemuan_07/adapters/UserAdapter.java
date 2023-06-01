package com.h071211059.pertemuan_07.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.h071211059.pertemuan_07.databinding.ItemUserLayoutBinding;
import com.h071211059.pertemuan_07.models.UserResponse;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    public ArrayList<UserResponse> users;
    private OnItemClickCallback onItemClickCallback;

    public UserAdapter(ArrayList<UserResponse> users) {
        this.users = users;
    }
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserLayoutBinding binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.onBind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemUserLayoutBinding binding;
        public ViewHolder(@NonNull ItemUserLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(UserResponse user) {
            binding.tvName.setText(user.getFirstName() + " " + user.getLastName());
            binding.tvUsername.setText(user.getEmail());
            Glide.with(binding.getRoot()).load(user.getAvatarUrl()).into(binding.ivProfile);
            binding.getRoot().setOnClickListener(v -> onItemClickCallback.onItemClicked(user));
        }
    }

    public static interface OnItemClickCallback {
        void onItemClicked(UserResponse user);
    }
}
