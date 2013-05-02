package com.notessync.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;

public class DisplayMessageActivity extends Activity {

    @SuppressWarnings("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        String note = (String) getIntent().getExtras().get(MyActivity.EXTRA_NOTE);
        StringBuilder notes = new StringBuilder();
        try {
            FileInputStream fileInputStream = openFileInput("notes-sync");
            int content;
            while ((content = fileInputStream.read()) != -1){
                notes.append((char) content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(notes);

        setContentView(textView);
    }
}