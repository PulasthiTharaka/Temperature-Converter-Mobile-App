package com.example.tute_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_temp;
    RadioButton rb_btn_c;
    RadioButton rb_btn_f;
    Button btn_cal;
    TextView tv_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_value);
        rb_btn_c = findViewById(R.id.btn_c);
        rb_btn_f = findViewById(R.id.btn_f);
        btn_cal = findViewById(R.id.btn_Calculate);
        tv_answer = findViewById(R.id.tv_answ);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculateAnswer();
            }
        });
    }

    public void calculateAnswer(){

        Calculations cal= new Calculations();
        String value = et_temp.getText().toString();

        if(TextUtils.isEmpty(value)){

            Toast.makeText(this, "Empty Feild", Toast.LENGTH_SHORT).show();
        }else{
            Float temp =Float.parseFloat(value);
            Float answer;

            if(rb_btn_c.isChecked()){
                answer = cal.convertCelciusToFahrenheit(temp);
            }else if(rb_btn_f.isChecked()){
                answer = cal.convertFahrenheitToCelcius(temp);
            }else{
                Toast.makeText(this, "Select the Any Radio Button", Toast.LENGTH_SHORT).show();
                answer=0.0f;
            }
            tv_answer.setText(new Float(answer).toString());
        }
    }
}