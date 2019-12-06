package com.example.viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button btnPrev,btnNext;
    ViewFlipper vFilpper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrev=(Button)findViewById(R.id.btnPrev);
        btnNext=(Button)findViewById(R.id.btnNext);
        vFilpper1=(ViewFlipper)findViewById(R.id.vFilpper1);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vFilpper1.startFlipping();
                vFilpper1.setFlipInterval(2000);
//               . setFlipInterval(숫자);  1000 에 1초(밀리초)이기 때문에 숫자를 잘 맞추어 써야 한다.
//                .startFlipping();  화면넘김 시작 메소드
//                vFilpper1.showPrevious();
//                .showPrevious();  다음으로 넘긴다.
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vFilpper1.stopFlipping();
//                .stopFlipping();  중단 메소드
//                vFilpper1.showNext();
//                .showNext(); 이전으로 넘긴다.
            }
        });

    }
}
