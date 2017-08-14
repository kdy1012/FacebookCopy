package kr.co.tjeit.facebookcopy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AddPhotoActivity extends AppCompatActivity {

    private android.widget.TextView testTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);
        bindViews();
        setupEvents();
        setValues();
        Log.d("사진액티비티", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        testTxt.setText("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        testTxt.setText("onResume");
        Log.d("사진액티비티", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("사진액티비티", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("사진액티비티", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("사진액티비티", "onDestory");
    }

    private void setValues() {
        // 화면에 뜰 데이터 (값) 설정.
        testTxt.setText("onCreate에서 문자 설정");
    }

    private void setupEvents() {
        // 버튼 / 에딧텍스트 /리스트뷰 등의 터치 이벤트 설정

        testTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPhotoActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bindViews() {

        this.testTxt = (TextView) findViewById(R.id.testTxt);
    }
}
