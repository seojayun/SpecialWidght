package com.example.specialwidght;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono1;
    RadioGroup rdogroup;
    RadioButton rdoCal,rdoTime;
    DatePicker dateView;
    TimePicker tPicker;
    TextView tvResult;
    int sYear,sMonth,sDay ;
    FrameLayout farme1;
    //1. 정수형 변수 3개 선언


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrono1=(Chronometer)findViewById(R.id.chrono1);
        rdoCal=(RadioButton)findViewById(R.id.rdoCal);
        rdoTime=(RadioButton)findViewById(R.id.rdoTime);
        dateView=(DatePicker) findViewById(R.id.dateView);
        tPicker=(TimePicker)findViewById(R.id.tPicker);
        tvResult=(TextView)findViewById(R.id.tvResult);
        farme1=(FrameLayout)findViewById(R.id.farme1);
        rdogroup=(RadioGroup)findViewById(R.id.rdogroup);



 chrono1.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {

             rdogroup.setVisibility(View.VISIBLE);
             farme1.setVisibility(View.VISIBLE);
             chrono1.setBase(SystemClock.elapsedRealtime());
             chrono1.start();
             chrono1.setTextColor(Color.RED);




     }
 });

        tvResult.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {




                rdogroup.setVisibility(View.INVISIBLE);
                farme1.setVisibility(View.INVISIBLE);
                chrono1.stop();
                chrono1.setTextColor(Color.BLACK);
                sYear = dateView.getYear();
                sMonth= dateView.getMonth()+1;
                sDay=dateView.getDayOfMonth();

                tvResult.setText(sYear + "년" + sMonth + "월" + sDay + "일" + tPicker.getCurrentHour() + "시" + tPicker.getCurrentMinute() + "분에 예약됨");


                    return false;
                }


        });



        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateView.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateView.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
            }
        });



    }
}






//10월 17일 2~3교시 수업내용 (자바코드)

//public class MainActivity extends AppCompatActivity {
//
//    Chronometer chrono1;
//    Button btnStart,btnend;
//    RadioButton rdoCal,rdoTime;
//    CalendarView calView;
//    TimePicker tPicker;
//    TextView tvResult;
//    int sYear,sMonth,sDay ;
////1. 정수형 변수 3개 선언


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        chrono1=(Chronometer)findViewById(R.id.chrono1);
//        btnStart=(Button)findViewById(R.id.btnStart);
//        btnend=(Button)findViewById(R.id.btnend);
//        rdoCal=(RadioButton)findViewById(R.id.rdoCal);
//        rdoTime=(RadioButton)findViewById(R.id.rdoTime);
//        calView=(CalendarView)findViewById(R.id.calView);
//        tPicker=(TimePicker)findViewById(R.id.tPicker);
//        tvResult=(TextView)findViewById(R.id.tvResult);
//
//
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chrono1.setBase(SystemClock.elapsedRealtime());  // chrono1.setBase(SystemClock.elapsedRealtime());   이것은 btnStart버튼을 누를때마다  Chronometer 초기화 하는 명령
//                chrono1.start();
//                chrono1.setTextColor(Color.RED);
//            }
//        });
//
//        btnend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chrono1.stop();
//                chrono1.setTextColor(Color.BLACK);
//                tvResult.setText(sYear+"년"+sMonth+"월"+sDay+"일"+tPicker.getCurrentHour()+"시"+tPicker.getCurrentMinute()+"분에 예약됨");   //4. .getCurrentHour()  시간을 가져옴   .getCurrentMinute() 분을 가져옴
//            }
//        });
//
//        rdoCal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calView.setVisibility(View.VISIBLE);
//                tPicker.setVisibility(View.INVISIBLE);
//            }
//        });
//
//        rdoTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calView.setVisibility(View.INVISIBLE);
//                tPicker.setVisibility(View.VISIBLE);
//            }
//        });
//
//        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                sYear=year;
//                sMonth=month+1;   //sMonth=month+1;  +1해주는 이유 -> 달력을 배열로 만들었기 때문에 첫번째 가져올 때 0번째 배열을 가져온다.  따라서 배열값에 +1 을 해야된다.
//                sDay=dayOfMonth;  // dayOfMonth;  달마다 배열이 틀리기 때문에 월마다 가져온다는 뜻으로 dayOfMonth
//            }
//        });
//        //2.setOnDateChangeListener(new CalendarView.OnDateChangeListener()   ※DateChangeListener-->원하는 날짜를 눌러서 바뀌면, 아래로 넘어온다는 뜻
//        //(CalendarView view, int year, int month, int dayOfMonth ) 연도/월/일 값이 변경되도록 짜기 위해 정수형 변수를 선언하였다.(매개변수)
//
//
//        //3.TimePicker는 ChangeListener를 하지 않아도 된다.(화면에보이는 값을 바로 입력해주기 때문)

