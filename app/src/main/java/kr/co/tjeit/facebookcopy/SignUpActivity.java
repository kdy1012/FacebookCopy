package kr.co.tjeit.facebookcopy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    Button idCheckBtn;
    EditText idEdt;
    EditText pwEdt;
    EditText pwCheckEdt;
    Button signUpBtn;

    boolean isIdOk = false;

    TextView messageTxt;
    ImageView alertImg;
    TextView birthDayTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindViews();
        setupEvents();
    }

    private void setupEvents() {
        idCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputId = idEdt.getText().toString();
                if (inputId.equals("user")) {
                    Toast.makeText(SignUpActivity.this, "이미 사용중인 아이디입니다.", Toast.LENGTH_SHORT).show();
                }
                else if (inputId.length() == 0) {
                    Toast.makeText(SignUpActivity.this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (inputId.length() < 8) {
                    Toast.makeText(SignUpActivity.this, "ID의 길이가 너무 짧습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignUpActivity.this, "사용해도 좋습니다.", Toast.LENGTH_SHORT).show();
                    isIdOk = true;
                }
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputPw = pwEdt.getText().toString();
                String inputCheckPw = pwCheckEdt.getText().toString();

                if (inputPw.length() >= 8 && inputPw.equals(inputCheckPw) && isIdOk) {

                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(SignUpActivity.this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });


        idEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String changedStr = s.toString();
                Log.d("바뀐글자", changedStr);

                isIdOk = false;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pwEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkPwAndChangeMessage();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pwCheckEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkPwAndChangeMessage();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        final Calendar tempCal = Calendar.getInstance();

        birthDayTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(SignUpActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                birthDayTxt.setText(""+year+month+dayOfMonth);
                            }
                        },
                        tempCal.get(Calendar.YEAR),
                        tempCal.get(Calendar.MONTH),
                        tempCal.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

    }


    void checkPwAndChangeMessage() {
        String pw = pwEdt.getText().toString();
        String pwCheck = pwCheckEdt.getText().toString();

        if (pw.length() == 0) {
            messageTxt.setText("비밀번호를 입력해주세요.");
            messageTxt.setTextColor(Color.parseColor("#FF0000"));
            alertImg.setImageResource(R.drawable.red_alert_icon);
        }
        else if (pw.length() < 8) {
            messageTxt.setText("비밀번호의 길이가 너무 짧습니다.");
            messageTxt.setTextColor(Color.parseColor("#FF0000"));
            alertImg.setImageResource(R.drawable.red_alert_icon);
        }
        else if (!pw.equals(pwCheck)) {
            messageTxt.setText("두개의 비밀번호가 서로 다릅니다.");
            messageTxt.setTextColor(Color.parseColor("#FF0000"));
            alertImg.setImageResource(R.drawable.red_alert_icon);
        }
        else {
            messageTxt.setText("회원가입이 가능합니다.");
            messageTxt.setTextColor(Color.parseColor("#00FF00"));
            alertImg.setImageResource(R.drawable.ok_icon);
        }

    }


    private void bindViews() {
        idCheckBtn = (Button) findViewById(R.id.idCheckBtn);
        idEdt = (EditText) findViewById(R.id.idEdt);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);
        pwEdt = (EditText) findViewById(R.id.pwEdt);
        pwCheckEdt = (EditText) findViewById(R.id.pwCheckEdt);
        messageTxt = (TextView) findViewById(R.id.messageTxt);
        alertImg = (ImageView) findViewById(R.id.alertImg);
        birthDayTxt = (TextView) findViewById(R.id.birthDayTxt);
    }


}
