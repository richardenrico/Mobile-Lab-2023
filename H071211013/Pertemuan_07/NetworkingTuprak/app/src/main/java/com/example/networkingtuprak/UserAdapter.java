package com.example.networkingtuprak;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<UserResponse> data;

    public UserAdapter(List<UserResponse> data) {
        this.data = data;
    }
    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        UserResponse userResponse = data.get(position);
        holder.setData(userResponse);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profil;
        TextView name, email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profil = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }

        public void setData(UserResponse userResponse) {
            String fullName = userResponse.getFirstName() + " " + userResponse.getLastName();
            name.setText(fullName);
            email.setText(userResponse.getEmail());
            Glide.with(itemView.getContext())
                    .load(userResponse.getAvatarUrl()).into(profil);

            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), DetailItem.class);
                intent.putExtra(DetailItem.EXTRA_USER,userResponse.getId());
                itemView.getContext().startActivity(intent);
            });

        }
    }
}
