package com.h071211059.pertemuan_08.util;

import android.database.Cursor;

import com.h071211059.pertemuan_08.db.DatabaseContract;
import com.h071211059.pertemuan_08.model.Note;

import java.util.ArrayList;

public class MappingHelper {
    public static ArrayList<Note> mapCursorToArrayList(Cursor cursor) {
        ArrayList<Note> notesList = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION));
            String createdAt = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.CREATED_AT));
            int isEdited = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.IS_EDITED));
            notesList.add(new Note(
                    id,
                    title,
                    description,
                    createdAt,
                    isEdited
            ));
        }
        return notesList;
    }
}
