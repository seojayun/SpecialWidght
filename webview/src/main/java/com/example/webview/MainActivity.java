package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    EditText edtUrl;
    ImageButton btnGo, btnBack;
    Button btn3;
    WebView wepView1;
    String urlStr;

//    6.     String urlStr; 스트링 변수 한개 선언


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUrl=(EditText)findViewById(R.id.edtUrl);
        btnGo=(ImageButton)findViewById(R.id.btnGo);
        btnBack=(ImageButton) findViewById(R.id.btnBack);
        wepView1=(WebView)findViewById(R.id.wepView1);
        btn3=(Button)findViewById(R.id.btn3) ;

//        4. 코딩작업 setWebViewClient(new Homeshow())
        wepView1.setWebViewClient(new Homeshow());
//        5. 이동 버튼 을 누르면 url이 뜨게 작업
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlStr=edtUrl.getText().toString();
//                7.if문 작성 substring(0,7) 0번째부터 6번째까지 라는 뜻임(뒷자리 숫자-1)
                if(urlStr.substring(0,7).equals("http://")) {
                    wepView1.loadUrl(urlStr);
                }else  {
                    wepView1.loadUrl("http://"+urlStr);
                }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wepView1.goBack();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wepView1.goForward();
            }
        });




    }
//   1. class Homeshow extends WebViewClient  클래스 생성  WebViewClient  외부에 있는 홈페이지를 불러와 화면에 구현함
 class Homeshow extends WebViewClient {
//        2. 코드 -> 오버라이드 로딩 으로  shouldOverrideUrlLoading 불러오기
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//         3. return super.shouldOverrideUrlLoading(view, url);  부모의 것을 띄어준다.
        return super.shouldOverrideUrlLoading(view, url);
    }
}

}

//8. 좌측에 manifests 로 이동