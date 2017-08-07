package kr.co.tjeit.facebookcopy;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginBtn;
    Button signUpBtn;
    Button facebookLoginBtn;
    EditText idEdt;
    EditText pwEdt;
    Button hpBtn;
    Button mailBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        setupEvents();
    }

    void setupEvents() {
        // 버튼들이 눌릴때 하는 일들을 설정.
        // 이벤트 처리 모음

        loginBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);
        facebookLoginBtn.setOnClickListener(this);

        hpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.naver.com"));
                startActivity(intent);
            }
        });

        mailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:contact@tje.co.kr"));
                startActivity(intent);
            }
        });


    }

    void bindViews() {
        idEdt = (EditText) findViewById(R.id.idEdt);
        pwEdt = (EditText) findViewById(R.id.pwEdt);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);
        facebookLoginBtn = (Button) findViewById(R.id.facebookLoginBtn);

        hpBtn = (Button) findViewById(R.id.hpBtn);
        mailBtn = (Button) findViewById(R.id.mailBtn);
    }

    @Override
    public void onClick(View v) {
        // 모든 버튼에 대한 클릭 이벤트를 처리 할 수 있음.

        if (v.getId() == R.id.loginBtn) {
            String inputId = idEdt.getText().toString();
            String inputPw = pwEdt.getText().toString();
            if (inputId.equals("user") && inputPw.equals("1234")) {
                Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(myIntent);
                finish();
            }
            else {
                Toast.makeText(this, "로그인에 실패했습니다.\n아이디와 비번을 확인해주세요.", Toast.LENGTH_SHORT).show();

            }
        }
        else if (v.getId() == R.id.signUpBtn) {

            Intent myIntent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(myIntent);

        }
        else if (v.getId() == R.id.facebookLoginBtn) {

            AlertDialog.Builder facebookAlert = new AlertDialog.Builder(LoginActivity.this);
            facebookAlert.setTitle("페이스북 로그인 알림");
            facebookAlert.setMessage("준비중인 기능입니다.");
            facebookAlert.setPositiveButton("확인", null);
            facebookAlert.show();

        }

        
    }
}









