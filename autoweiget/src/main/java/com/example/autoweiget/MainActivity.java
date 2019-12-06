package com.example.autoweiget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoEdt1;
    MultiAutoCompleteTextView MultautoEdt1;
    String words[] = {"가나다라","나다라마","다라마","라마사","마사","아자차","자차","차"};
    // 1. 단어의 배열 설정
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        autoEdt1=(AutoCompleteTextView)findViewById(R.id.autoEdt1);
        MultautoEdt1=(MultiAutoCompleteTextView)findViewById(R.id.MultautoEdt1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,words);
    //2. ArrayAdapter<String> 글자를 어뎁터에 담는다. adapter 이름생성 new ArrayAdapter<String>(어디다,레이아웃,자료) 를 적는다.
        // (this = 나자신, 레이아웃 = android.R.layout.simple_dropdown_item_1line  안드로이드에 있는 레이아웃을 가져옴, word = 외부자료를 가져옴)
        autoEdt1.setAdapter(adapter);
        //3. autoEdt1.setAdapter(adapter)

        MultiAutoCompleteTextView.CommaTokenizer tokenizer = new MultiAutoCompleteTextView.CommaTokenizer();
        MultautoEdt1.setTokenizer(tokenizer);
        MultautoEdt1.setAdapter(adapter);
        //4. CommaTokenizer : 대상을 나누어 주는 기능
        //4. MultiAutoCompleteTextView  는 .setTokenizer .setAdapter  두가지 다 세팅해줘야 한다.  -> 단어를 선택해주었을 때 ,로 구분하여 세팅해준다. (자주 쓰이진 않음)



    }
}
