package com.h071211059.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h071211059.recyclerviewapp.databinding.MessageReceivedLayoutBinding;
import com.h071211059.recyclerviewapp.databinding.MessageSentLayoutBinding;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter {
    private final ArrayList<Message> messages;

    public MessageAdapter(ArrayList<Message> messages) {
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        if (messages.get(position).isSentByMe()) {
            return 1;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MessageSentLayoutBinding binding =
                MessageSentLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent
                        , false);

        MessageReceivedLayoutBinding binding1 =
                MessageReceivedLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);

        if (viewType == 0) {
            return new MessageSentViewHolder(binding);
        }
        return new MessageReceivedViewHolder(binding1);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == 0) {
            ((MessageSentViewHolder) holder).onBind(messages.get(position));
        } else {
            ((MessageReceivedViewHolder) holder).onBind(messages.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MessageSentViewHolder extends RecyclerView.ViewHolder {
        private final MessageSentLayoutBinding binding;

        public MessageSentViewHolder(@NonNull MessageSentLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Message message) {
            binding.tvMessageText.setText(message.getMsgText());
        }
    }

    class MessageReceivedViewHolder extends RecyclerView.ViewHolder {
        private final MessageReceivedLayoutBinding binding;

        public MessageReceivedViewHolder(@NonNull MessageReceivedLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Message message) {
            binding.tvMessageText.setText(message.getMsgText());
        }
    }

}
