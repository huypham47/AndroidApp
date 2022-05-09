package com.example.two_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    public static final String EXTRA_MESSAGE = "com.example.two_activity.MainActivity";
    public static final int TEXT_REQUEST = 1;
    EditText edtMessage;
    TextView txtView;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String strReplymsg = data.getStringExtra(secondActivity.RELY_MESSAGE);
                txtView.setText(strReplymsg);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = findViewById(R.id.btnSend);
        edtMessage = findViewById(R.id.editMessage);
        txtView = findViewById(R.id.txtRely);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, secondActivity.class);
                String strMessage = edtMessage.getText().toString();
                myIntent.putExtra(EXTRA_MESSAGE, strMessage);
                startActivityForResult(myIntent, TEXT_REQUEST);
            }
        });
    }
}