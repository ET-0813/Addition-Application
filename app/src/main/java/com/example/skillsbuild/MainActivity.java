package com.example.skillsbuild;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Button add;
    private TextView answer;

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

        num1 = (EditText) findViewById(R.id.editTextNumber);
        num2 = (EditText) findViewById(R.id.editTextNumber2);
        add = (Button) findViewById(R.id.button);
        answer = (TextView) findViewById(R.id.textView2);

        /**
         * Logic to display the number added from the EditText widgets into the "answer" TextView
         */
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = checkNumber(num1.getText().toString());
                int number2 = checkNumber(num2.getText().toString());
                int sum = number1 + number2;

                answer.setText("The Answer is: " + sum);
            }
        });
    }

    /**
     * Method that checks whether the value in the EditText widget exists
     * @param numStr A user's input number as a String
     * @return The number a user inputs if it exists, else 0
     */
    private int checkNumber(String numStr)
    {
        int num;
        try {
            num = Integer.parseInt(numStr);
        }
        catch (Exception e) {
            num = 0;
        }
        return num;
    }
}