package com.example.TP_Mobile_6_Ke_2;

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
import com.bumptech.glide.request.RequestOptions;
import com.example.tp_mobile_6_ke_2.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.viewHolder> {


    private List<Chat> chatList;

    public ChatAdapter(Context context, List<Chat> chatList){
        this.chatList = chatList;
        this.context = context;
    }

    private Context context;


    @NonNull
    @Override
    public ChatAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat,parent,false);
               return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.viewHolder holder, int position) {
        Chat chat = chatList.get(position);
        holder.tv_name.setText(chat.getTv_name());
        holder.tv_chat.setText(chat.getTv_chat());
        holder.tv_time.setText(chat.getTv_time());

        Glide.with(holder.itemView.getContext())
                .load(chat.getIv_profile())
                .apply(new RequestOptions().override(300,300))
                .into(holder.iv_profile);

        holder.iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity4.class);
                intent.putExtra("Img", chat.getIv_profile());
                intent.putExtra("Name", chat.getTv_name());
                holder.itemView.getContext().startActivity(intent);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int iv_profile = chatList.get(holder.getAdapterPosition()).getIv_profile();
                String name = String.valueOf(chatList.get(holder.getAdapterPosition()).getTv_name());
                String time = String.valueOf(chatList.get(holder.getAdapterPosition()).getTv_time());
                String number = String.valueOf(chatList.get(holder.getAdapterPosition()).getTv_nomor());
                String status = String.valueOf(chatList.get(holder.getAdapterPosition()).getTv_status());
                String status_date = String.valueOf(chatList.get(holder.getAdapterPosition()).getTv_tgl_status());

                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                intent.putExtra("Img", iv_profile);
                intent.putExtra("Name", name);
                intent.putExtra("Time", time);
                intent.putExtra("Number", number);
                intent.putExtra("Status", status);
                intent.putExtra("Status_Date", status_date);

                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class viewHolder extends  RecyclerView.ViewHolder{

        RelativeLayout parentLayout;
        private CircleImageView iv_profile;
        private TextView tv_name, tv_chat, tv_time;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_name =  itemView.findViewById(R.id.tv_name);
            tv_chat = itemView.findViewById(R.id.tv_chat);
            tv_time = itemView.findViewById(R.id.tv_time);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }

        public void setData(int image, String name, String time, String chat) {
            iv_profile.setImageResource(image);
            tv_name.setText(name);
            tv_time.setText(time);
            tv_chat.setText(chat);
        }
    }
}
