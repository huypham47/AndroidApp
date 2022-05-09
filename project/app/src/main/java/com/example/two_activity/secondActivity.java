package com.example.two_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
    Button btnRely;
    public static final String RELY_MESSAGE = "com.example.two_activity.secondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView txtView = findViewById(R.id.txtShowMessage);
        EditText edtRely = findViewById(R.id.etdRely);
        Intent callerIntent = getIntent();
        String strMessage = callerIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if(strMessage != null){
            txtView.setText(strMessage);
        }
        btnRely.findViewById(R.id.btnRely);
        btnRely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent relyIntent = new Intent(secondActivity.this, MainActivity.class);
                String strRelyMessage = edtRely.getText().toString();
                relyIntent.putExtra(RELY_MESSAGE, strRelyMessage);
                setResult(RESULT_OK, relyIntent);
                finish();
            }
        });
    }
}