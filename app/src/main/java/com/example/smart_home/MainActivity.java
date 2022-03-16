package com.example.smart_home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    String dateTime, dateDate;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat, simpleTimeFormat;
    boolean change = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text1);
        button = findViewById(R.id.btn1);

        calendar = Calendar.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!change) {
                    getDate();
                    change = true;
                } else {
                    getTime();
                    change = false;
                }
            }
        });
    }

    public void getDate() {
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateDate = simpleDateFormat.format(calendar.getTime()).toString();
        textView.setText(dateDate);
    }

    public void getTime() {
        simpleTimeFormat = new SimpleDateFormat("HH:mm:ss");
        dateTime = simpleTimeFormat.format(calendar.getTime()).toString();
        textView.setText(dateTime);
    }
}