package kr.co.tjeit.facebookcopy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginBtn;
    Button signUpBtn;
    Button facebookLoginBtn;


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


    }

    void bindViews() {
        loginBtn = (Button) findViewById(R.id.loginBtn);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);
        facebookLoginBtn = (Button) findViewById(R.id.facebookLoginBtn);
    }

    @Override
    public void onClick(View v) {
        // 모든 버튼에 대한 클릭 이벤트를 처리 할 수 있음.

        if (v.getId() == R.id.loginBtn) {
            Toast.makeText(this, "로그인 버튼!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "그 외의 버튼이 눌림!!", Toast.LENGTH_SHORT).show();
        }

        
    }
}









