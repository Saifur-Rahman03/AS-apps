package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Transactions> dates = new ArrayList<>();
    private EditText editText1, editText2, totalToday;
    private TextView textView, textView2, textView3;
    private Button button, button2;
    double totalCost = 0.0;
    double totalforToday;
    double left;
    int i;
    String Left, valueToday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalToday = findViewById(R.id.totalTodayID);
        textView = findViewById(R.id.textViewID);
        textView2 = findViewById(R.id.textView2ID);
        textView3 = findViewById(R.id.textView3ID);
        button = findViewById(R.id.buttonID);
        button2 = findViewById(R.id.button2ID);
        editText1 = findViewById(R.id.editText1ID);
        editText2 = findViewById(R.id.editText2ID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueToday = totalToday.getText().toString();
                totalforToday = Double.parseDouble(valueToday);
                String value = editText1.getText().toString();
                String value2 = editText2.getText().toString();
                double valueD = Double.parseDouble(value2);
                dates.add(new Transactions(value, valueD));
                totalCost();
            }
    });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftMoney();
                show();
            }
        });
    }

    private void totalCost(){
            totalCost += dates.get(i).cost;
            i++;

    }

    private void leftMoney(){
        left = totalforToday - totalCost;
        Left = String.valueOf(left);
        textView.setText("left: " + Left);
    }

    private void show(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < dates.size(); i++){
            stringBuilder.
                    append(dates.get(i).description).
                    append("\t\t").
                    append(dates.get(i).cost).
                    append("\n");
        }
        textView2.setText(stringBuilder.toString());
        textView3.setText("Total cost Today: " + totalCost);
    }
}
