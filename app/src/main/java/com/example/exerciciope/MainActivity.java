package com.example.exerciciope;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText n1;
    private TextView res;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        n1 = findViewById(R.id.ETnum);
        res = findViewById(R.id.TVresultado);
        Button calc = findViewById(R.id.BTcalc);
        calc.setOnClickListener(op -> calc());

    }
    private void calc() {
        try {
            int num1 = Integer.parseInt(n1.getText().toString());

            if (num1 <= 0 || num1 > 20) {
                res.setText(R.string.erro);
                return;
            }

            StringBuilder contrutor = new StringBuilder();
            int a = 0, b = 1;

            if (num1 >= 1) contrutor.append(a);
            if (num1 >= 2) contrutor.append(", ").append(b);

            for (int i = 3; i <= num1; i++) {
                int proximo = a + b;
                contrutor.append(", ").append(proximo);
                a = b;
                b = proximo;
            }

            res.setText(contrutor.toString());

        } catch (NumberFormatException e) {
            res.setText(R.string.erro);
        }
    }}
