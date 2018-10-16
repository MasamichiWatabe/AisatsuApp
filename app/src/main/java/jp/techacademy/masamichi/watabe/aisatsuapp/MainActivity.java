package jp.techacademy.masamichi.watabe.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int hourTime = 23;
    int minuteTime = 59;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
            }
        },
        hourTime,
                minuteTime,
                true);
        timePickerDialog.show();

        TextView textView = (TextView) findViewById(R.id.textView);
        if (hourTime >= 2 && hourTime < 10) {
            textView.setText("おはよう");
        } else if (hourTime >= 10 && hourTime < 18) {
            textView.setText("こんにちは");
        } else if ((hourTime >= 18 && hourTime < 24) || (hourTime >= 0 && hourTime < 2)) {
            textView.setText("こんばんは");
        } else {
            textView.setText("時間が不明です");
        }
    }
}
