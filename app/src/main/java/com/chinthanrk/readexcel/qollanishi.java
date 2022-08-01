package com.chinthanrk.readexcel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class qollanishi extends MainActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qollanishi);
        textView=findViewById(R.id.qollanishi);

        textView=findViewById(R.id.qollanishi);
        textView.setText(uka);
    }
}