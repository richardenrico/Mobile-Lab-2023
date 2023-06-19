package com.example.chat;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_CHAT = "extra_chat";
    private ImageView backButton;
    RecyclerView recyclerView;
    ModelClass2 modelClass2;
    com.example.chat.Adapter2 adapter2;
    ArrayList<ModelClass2> List;
    private ImageView profilePict;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.rv_message);
        backButton = findViewById(R.id.backArrow);
        profilePict = findViewById(R.id.profilePict);
        name = findViewById(R.id.name);
        List = new ArrayList<>();

        List.add(new ModelClass2(ModelClass2.LAYOUT_ONE, "Hi. Nice to meet you", "07.30 am"));
        List.add(new ModelClass2(ModelClass2.LAYOUT_TWO, "Hey. Nice to meet you too", "08.45 am"));
        List.add(new ModelClass2(ModelClass2.LAYOUT_ONE, "How's it going?", "10.00 am"));
        List.add(new ModelClass2(ModelClass2.LAYOUT_ONE, "I hope you're okay", "10.00 am"));

        adapter2 = new com.example.chat.Adapter2(List, MainActivity2.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();

        backButton.setOnClickListener(view -> finish());

        ModelClass modelClass = getIntent().getParcelableExtra(EXTRA_CHAT);

        profilePict.setImageResource(modelClass.getImageView1());
        name.setText(modelClass.getTextView1());

    }
}