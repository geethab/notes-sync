package com.notessync.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.notessync.R;

import java.io.FileOutputStream;

public class MyActivity extends Activity {

    public static final String EXTRA_NOTE = "com.notessync.MESSAGE";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void createNote(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.welcome_message);

//        intent.putExtra(EXTRA_NOTE,editText.getText().toString());
        try {
            FileOutputStream fileOutputStream = openFileOutput("notes-sync", Context.MODE_APPEND);
            String newNote = editText.getText().toString() + "\n";
            fileOutputStream.write(newNote.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        startActivity(intent);
    }
}
