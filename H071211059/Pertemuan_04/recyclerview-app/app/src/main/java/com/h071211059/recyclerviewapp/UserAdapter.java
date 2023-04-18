package com.h071211059.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h071211059.recyclerviewapp.databinding.ItemChatLayoutBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ChatViewHolder> {

    private static ClickListener clickListener;
    private static ImageClick imageClickListener;
    private final ArrayList<User> chats;

    public UserAdapter(ArrayList<User> chats) {
        this.chats = chats;
    }

    public void setClickListener(ClickListener clickListener, ImageClick imageClick) {
        UserAdapter.clickListener = clickListener;
        UserAdapter.imageClickListener = imageClick;
    }

    @NonNull
    @Override
    public UserAdapter.ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChatLayoutBinding binding =
                ItemChatLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent,
                        false);
        return new ChatViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ChatViewHolder holder, int position) {
        holder.onBind(chats.get(position));
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    interface ClickListener {
        void onClick(User chat);
    }

    interface ImageClick {
        void onClick(User chat);
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        private final ItemChatLayoutBinding binding;

        public ChatViewHolder(@NonNull ItemChatLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(User chat) {
            Message lastMessage = chat.getMessages().get(chat.getMessages().size() - 1);
            String lastMessageText = lastMessage.getMsgText();
            String lastMessageTime = lastMessage.getMsgTime();

            binding.tvName.setText(chat.getName());
            binding.tvChat.setText(lastMessageText);
            binding.tvTime.setText(lastMessageTime);
            binding.ivProfile.setImageResource(chat.getImage());
            binding.clUserChatInfo.setOnClickListener(v -> clickListener.onClick(chat));
            binding.ivProfile.setOnClickListener(v -> imageClickListener.onClick(chat));

        }
    }
}
