package com.example.localdatapersistenttuprak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.localdatapersistenttuprak.helper.DatabaseContract;
import com.example.localdatapersistenttuprak.helper.NoteHelper;
import com.example.localdatapersistenttuprak.model.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddNotesActivity extends AppCompatActivity {

    public static final String EXTRA_NOTE = "extra_note";
    public static final int RESULT_ADD = 101;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;

    private NoteHelper noteHelper;

    private Note note;

    private EditText etTitle, etDescription;
    private Button btnSave, btnDelete;

    private boolean isEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        etTitle = findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_description);
        btnSave = findViewById(R.id.btn_save);
        btnDelete = findViewById(R.id.btn_delete);

        noteHelper = NoteHelper.getInstance(getApplicationContext());
        noteHelper.open();

        setupNote();
        setupButtonSave();
        setupButtonDelete();
    }

    private void setupNote() {
        note = getIntent().getParcelableExtra(EXTRA_NOTE);
        if (note != null) {
            isEdit = true;
            etTitle.setText(note.getTitle());
            etDescription.setText(note.getDescription());
            btnDelete.setVisibility(View.VISIBLE);
        } else {
            note = new Note();
        }
    }

    private void setupButtonSave() {
        String buttonTitle = isEdit ? "Update" : "Save";
        btnSave.setText(buttonTitle);

        btnSave.setOnClickListener(view -> save());
    }

    private void setupButtonDelete() {
        btnDelete.setOnClickListener(view -> delete());
    }

    private void save() {
        String title = etTitle.getText().toString().trim();
        String description = etDescription.getText().toString().trim();

        // Validasi input
        if (title.isEmpty()) {
            etTitle.setError("Please fill this field");
            return;
        }

        // Update data note
        note.setTitle(title);
        note.setDescription(description);
        note.setEditedAt(getCurrentTimestamp());

        // Simpan data ke database
        if (isEdit) {
            updateNote();
        } else {
            addNote();
        }
    }

    private void addNote() {
        note.setCreatedAt(getCurrentTimestamp());
        long result = noteHelper.insert(getContentValuesFromNote());
        if (result > 0) {
            note.setId((int) result);
            setResult(RESULT_ADD, createResultIntent());
            finish();
        } else {
            Toast.makeText(this, "Failed to add data", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateNote() {
        long result = noteHelper.update(String.valueOf(note.getId()), getContentValuesFromNote());
        if (result > 0) {
            setResult(RESULT_UPDATE, createResultIntent());
            finish();
        } else {
            Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show();
        }
    }

    private void delete() {
        long result = noteHelper.deleteById(String.valueOf(note.getId()));
        if (result > 0) {
            setResult(RESULT_DELETE, new Intent());
            finish();
        } else {
            Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show();
        }
    }

    private ContentValues getContentValuesFromNote() {
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.NoteColumns.TITLE, note.getTitle());
        values.put(DatabaseContract.NoteColumns.DESCRIPTION, note.getDescription());
        values.put(DatabaseContract.NoteColumns.EDITED_AT, note.getEditedAt());
        if (!isEdit) {
            values.put(DatabaseContract.NoteColumns.CREATED_AT, note.getCreatedAt());
        }
        return values;
    }

    private Intent createResultIntent() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_NOTE, note);
        return intent;
    }

    private String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        return dateFormat.format(new Date());
    }
}