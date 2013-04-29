package com.notessync.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

    @SuppressWarnings("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String note = (String) getIntent().getExtras().get(MyActivity.EXTRA_NOTE);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(note);

        setContentView(textView);
    }
}