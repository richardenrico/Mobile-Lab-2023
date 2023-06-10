package com.example.tp_mobile_7;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ArrayList<Post> postList;
    private Context context;

    public PostAdapter(ArrayList<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.caption.setText(post.getCaption());
        holder.imageUpload.setImageURI(post.getImagePost());

        holder.civProfilePictureHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.fullName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView civProfilePictureHome;
        TextView caption, userName, fullName;
        ImageView imageUpload;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            caption = itemView.findViewById(R.id.tv_captionHome);
            userName = itemView.findViewById(R.id.tvUserName);
            fullName = itemView.findViewById(R.id.tvFullName);
            imageUpload = itemView.findViewById(R.id.ivUploadedImage);
            civProfilePictureHome = itemView.findViewById(R.id.civProfilePictureHome);
        }
    }
}
