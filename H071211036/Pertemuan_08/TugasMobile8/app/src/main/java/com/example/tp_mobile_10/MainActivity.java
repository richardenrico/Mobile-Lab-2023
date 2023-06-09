package com.example.tp_mobile_10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.tp_mobile_10.adapter.NoteAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMain;
    private FloatingActionButton floatingActionButton;
    private NoteDatabase database;
    private NoteAdapter noteAdapter;
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rvMain);
        floatingActionButton = findViewById(R.id.fabAddNote);
        etSearch = findViewById(R.id.et_search);

        database = new NoteDatabase(this);

        rvMain.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(this, database.getAllNote());
        rvMain.setAdapter(noteAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddEditNote.class));
            }
        });

        etSearch.setHorizontallyScrolling(true);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        noteAdapter.setOnClickListenerNote(new NoteAdapter.OnClickListenerNote() {
            @Override
            public void onItemClickNote(long id) {
                Intent editNote = new Intent(MainActivity.this, AddEditNote.class);
                editNote.putExtra(NoteDatabase.id_note, id);
                startActivity(editNote);
            }
        });
    }

    private void searchData(String query) {
        noteAdapter = new NoteAdapter(this, database.searchNotes(query));
        rvMain.setAdapter(noteAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.swapCursor(database.getAllNote());
    }
}
