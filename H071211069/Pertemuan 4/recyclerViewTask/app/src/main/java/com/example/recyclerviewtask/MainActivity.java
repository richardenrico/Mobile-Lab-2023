package com.example.recyclerviewtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass>userlist;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();

    }

    private void initData() {
        userlist = new ArrayList<>();
        userlist.add(new ModelClass(R.drawable._681483842180,"nama1","22:10 Pm","gasskan"));
        userlist.add(new ModelClass(R.drawable._681483842190,"nama2","09:11 Am","Ayo aja gue mah"));
        userlist.add(new ModelClass(R.drawable._681483842204,"nama3","13:10 Pm","pala lo sini gw genjreng"));
        userlist.add(new ModelClass(R.drawable._681483842218,"nama4","16:10 Pm","pinjam dulu 100"));
        userlist.add(new ModelClass(R.drawable._681483842230,"nama5","12:04 Pm","Y in aja Gw Mah"));
        userlist.add(new ModelClass(R.drawable._681483842243,"nama6","10:11 Am","ywdh sihn"));
        userlist.add(new ModelClass(R.drawable._681483842260,"nama7","18:13 Pm","pakai nanya"));
        userlist.add(new ModelClass(R.drawable._681483842272,"nama8","19:15 Pm","njir"));
        userlist.add(new ModelClass(R.drawable._681483842285,"nama9","11:13 Am","oiiiiiiiiiiiiiiiiiiiiiiiiiiiii"));
        userlist.add(new ModelClass(R.drawable._681483842299,"nama10","12:10 Pm","utiwi"));
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this,userlist);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}