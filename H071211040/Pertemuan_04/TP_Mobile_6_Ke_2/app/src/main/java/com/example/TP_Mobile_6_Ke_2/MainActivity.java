package com.example.TP_Mobile_6_Ke_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tp_mobile_6_ke_2.R;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Chat>chatList;
    ChatAdapter chatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataSource();
        initRecyclerView();

    }

    private void DataSource() {
        chatList = new ArrayList<>();
        chatList.add(new Chat(R.drawable.aatrox,"Aatrox","23:55","Now, hear the silence of annihilation!","+62 838-3532-3176","We need to rent a room for our party.", "2023-04-17"));
        chatList.add(new Chat(R.drawable.kayn,"Kayn","22:45","Will you prove worthy?. Probably not.", "+62 833-5697-149","25 years later, she still regretted that specific moment.","2023-05-22"));
        chatList.add(new Chat(R.drawable.varus,"Varus","21:10","The guilty will know agony", "+62 838-0589-175", "He always wore his sunglasses at night.", "2023-06-05"));
        chatList.add(new Chat(R.drawable.akali,"Akali","21:00","Fear the assassin with no master.","+62 860-6501-9800","If I don’t like something, I’ll stay away from it.","2023-07-24"));
        chatList.add(new Chat(R.drawable.azir,"Azir","18:40","Shurima! Your emperor has returned!","+62 878-9542-433","The view from the lighthouse excited even the most seasoned traveler.","2023-08-23"));
        chatList.add(new Chat(R.drawable.nasus,"Nasus","16:10","The cycle of life and death continues. We will live, they will die.","+62 814-2065-9408", "I've never seen a more beautiful brandy glass filled with wine.","2023-09-11"));
        chatList.add(new Chat(R.drawable.pantheon,"Pantheon","18:40","In battle, we are reborn.","+62 817-7283-262","The blue parrot drove by the hitchhiking mongoose.","2023-09-12"));
        chatList.add(new Chat(R.drawable.renekton,"Renekton","16:10","As I live, all will die!","+62 899-5613-1383","Behind the window was a reflection that only instilled fear.","2023-09-19"));
        chatList.add(new Chat(R.drawable.thresh,"Thresh","15:40","What delightful agony we shall inflict.","+62 879-3141-179","Cats are good pets, for they are clean and are not noisy.","2023-09-29"));
        chatList.add(new Chat(R.drawable.yasuo,"Yasuo","07:20","Death is like the wind – always by my side.","+62 812-7812-5894","I'll have you know I've written over fifty novels","2023-11-27"));
        chatList.add(new Chat(R.drawable.yone,"Yone","06:25","One to cut, one to seal.","+62 857-7542-69083","He decided to live his life by the big beats manifesto.","2023-12-15"));
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        chatAdapter = new ChatAdapter(this,chatList);
        recyclerView.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();
    }
}