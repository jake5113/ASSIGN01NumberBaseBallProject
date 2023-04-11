package com.jake5113.assign01numberbaseballproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    int[] num = new int[3];
    EditText tv1, tv2, tv3;
    TextView answer;
    int num1, num2, num3;
    Button btn, btnRetry;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        // 중복값 제거
        for (int i = 0; i < 3; i++) {
            num[i] = random.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (num[i] == num[j]) {
                    i--;
                    continue;
                }
            }
        }

        tv1 = findViewById(R.id.num1);
        tv2 = findViewById(R.id.num2);
        tv3 = findViewById(R.id.num3);

        btn = findViewById(R.id.btn);
        btnRetry = findViewById(R.id.btn_retry);
        answer = findViewById(R.id.answer);


        tv1.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) tv1.setText("");
            }
        });
        tv2.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(hasFocus) tv2.setText("");
            }
        });
        tv3.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) tv3.setText("");
            }
        });

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 3; i++) {
                    num[i] = random.nextInt(10);
                    for (int j = 0; j < i; j++) {
                        if (num[i] == num[j]) {
                            i--;
                            continue;
                        }
                    }
                }
                answer.setText("새 게임 시작!\n");
                tv1.setText("");
                tv2.setText("");
                tv3.setText("");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //입력된 숫자 저장
                try {
                    num1 = Integer.parseInt(String.valueOf(tv1.getText()));
                    num2 = Integer.parseInt(String.valueOf(tv2.getText()));
                    num3 = Integer.parseInt(String.valueOf(tv3.getText()));

                } catch (Exception e) {
                    answer.append("잘못입력하셨습니다.\n");

                }

                int strike = 0, ball = 0;

                if (num1 == num[0]) {
                    strike++;
                }
                if (num2 == num[1]) {
                    strike++;
                }
                if (num3 == num[2]) {
                    strike++;
                }
                if (num1 == num[1] || num1 == num[2]) {
                    ball++;
                }
                if (num2 == num[0] || num2 == num[2]) {
                    ball++;
                }
                if (num3 == num[0] || num3 == num[1]) {
                    ball++;
                }
                if (strike == 3) {
                    answer.setText("정답");
                }
                answer.append("" + num1 + num2 + num3 + "   :   " + strike + "strike   " + ball + "ball\n");
            }
        });
    }
}