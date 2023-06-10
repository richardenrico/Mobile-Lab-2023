package com.example.tp_mobile_9;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private List<UserResponse> userList;
    private Context context;

    public UserAdapter(List<UserResponse> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        UserResponse userResponse = userList.get(position);

        String fullName = userResponse.getFirstName() + " " + userResponse.getLastName();
        holder.tvFullNameMainActivity.setText(fullName);
        holder.tvEmailMainActivity.setText(userResponse.getEmail());
        Glide.with(context)
                .load(userResponse.getAvatarUrl())
                .into(holder.civProfilePictureMainActivity);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserResponse userResponse = userList.get(holder.getAdapterPosition());
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("avatarUrl", userResponse.getAvatarUrl());
                intent.putExtra("fullName", userResponse.getFirstName() + " " + userResponse.getLastName());
                intent.putExtra("email", userResponse.getEmail());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout parentLayout;
        private CircleImageView civProfilePictureMainActivity;
        private TextView tvFullNameMainActivity, tvEmailMainActivity;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.parentLayout);
            civProfilePictureMainActivity = itemView.findViewById(R.id.civProfilePictureMainActivity);
            tvFullNameMainActivity = itemView.findViewById(R.id.tvFullNameMainActivity);
            tvEmailMainActivity = itemView.findViewById(R.id.tvEmailMainActivity);
        }
    }
}
