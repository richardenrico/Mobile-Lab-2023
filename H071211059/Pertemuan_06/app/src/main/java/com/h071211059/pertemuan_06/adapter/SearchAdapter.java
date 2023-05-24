package com.h071211059.pertemuan_06.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h071211059.pertemuan_06.databinding.ItemPostLayoutBinding;
import com.h071211059.pertemuan_06.databinding.ItemUserLayoutBinding;
import com.h071211059.pertemuan_06.model.User;
import com.h071211059.pertemuan_06.util.ProfileListener;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    private ArrayList<User> users;
    private ProfileListener profileListener;

    public SearchAdapter(ArrayList<User> users) {
        this.users = users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    public void setProfileListener(ProfileListener profileListener) {
        this.profileListener = profileListener;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserLayoutBinding binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
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

        public void onBind(User user) {
            Log.i("onBind", "onBind: Set data");
            binding.ivProfile.setImageResource(user.getImage());
            binding.tvUsername.setText(user.getUsername());
            binding.tvName.setText(user.getName());
            binding.getRoot().setOnClickListener(v -> profileListener.onClick(user));
        }
    }
}
