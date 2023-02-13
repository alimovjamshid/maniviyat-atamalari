package com.chinthanrk.readexcel;

import android.os.Bundle;
import android.widget.TextView;

public class Manosi extends MainActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manosi);
        textView=findViewById(R.id.manotext);

        textView.setText(aka);
    }
}