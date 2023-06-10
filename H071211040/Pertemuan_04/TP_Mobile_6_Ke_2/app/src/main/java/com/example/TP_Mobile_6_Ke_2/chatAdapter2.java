package com.example.TP_Mobile_6_Ke_2;

import static com.example.TP_Mobile_6_Ke_2.Chat2.MY_LAYOUT;
import static com.example.TP_Mobile_6_Ke_2.Chat2.THEIR_LAYOUT;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp_mobile_6_ke_2.R;

import java.util.List;

public class chatAdapter2 extends RecyclerView.Adapter {

    List<Chat2> list;
    Context context;

    public chatAdapter2(List<Chat2> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).getViewType()) {
            case 1:
                return MY_LAYOUT;
            case 2:
                return THEIR_LAYOUT;

            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                View myLayout = LayoutInflater.from(context).inflate(R.layout.my_chat, parent, false);
                return new myMessageViewHolder(myLayout);

            case 2:
                View theirLayout = LayoutInflater.from(context).inflate(R.layout.their_chat, parent, false);
                return new theirMessageViewHolder(theirLayout);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (list.get(position).getViewType()) {
            case 1:
                String myMessage = list.get(position).getPesan();
                ((myMessageViewHolder) holder).setView(myMessage);
                break;
            case 2:
                String theirMessage = list.get(position).getPesan();
                ((theirMessageViewHolder) holder).setView(theirMessage);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class theirMessageViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_theirText;

        public theirMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_theirText = itemView.findViewById(R.id.tv_theirText);
        }
        private void setView(String text){tv_theirText.setText(text);}
    }

    class myMessageViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_myText;

        public myMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_myText = itemView.findViewById(R.id.tv_myText);
        }
        private void setView(String text){tv_myText.setText(text);}
    }


}

