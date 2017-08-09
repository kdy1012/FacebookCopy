package kr.co.tjeit.facebookcopy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EditStatusActivity extends AppCompatActivity {

    private android.widget.TextView titleTxt;
    private android.widget.LinearLayout photoBtnLayout;
    private android.widget.LinearLayout liveBtnLayout;
    private android.widget.LinearLayout checkInBtnLayout;
    private android.widget.LinearLayout stickerBtnLayout;
    private android.widget.Button postBtn;
    private android.widget.EditText postContentEdt;
    private Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_status);
        bindViews();
        setupEvents();
        setValues();
    }

    private void setValues() {

    }

    private void setupEvents() {

        View.OnClickListener preparingListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditStatusActivity.this, "준비중인 기능 입니다.", Toast.LENGTH_SHORT).show();
            }
        };

        photoBtnLayout.setOnClickListener(preparingListener);
        liveBtnLayout.setOnClickListener(preparingListener);
        checkInBtnLayout.setOnClickListener(preparingListener);
        stickerBtnLayout.setOnClickListener(preparingListener);

        postContentEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String inputText = s.toString();
                if (inputText.length() > 0) {
                    postBtn.setTextColor(Color.parseColor("#3333FF"));
                } else {
                    postBtn.setTextColor(Color.parseColor("#A0A0A0"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (postContentEdt.getText().toString().length() == 0) {
                    Toast.makeText(EditStatusActivity.this, "게시글을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditStatusActivity.this, "게시글이 등록됩니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void bindViews() {
        this.stickerBtnLayout = (LinearLayout) findViewById(R.id.stickerBtnLayout);
        this.checkInBtnLayout = (LinearLayout) findViewById(R.id.checkInBtnLayout);
        this.liveBtnLayout = (LinearLayout) findViewById(R.id.liveBtnLayout);
        this.photoBtnLayout = (LinearLayout) findViewById(R.id.photoBtnLayout);
        this.postContentEdt = (EditText) findViewById(R.id.postContentEdt);
        this.postBtn = (Button) findViewById(R.id.postBtn);
        this.titleTxt = (TextView) findViewById(R.id.titleTxt);
        this.cancelBtn = (Button) findViewById(R.id.cancelBtn);
    }
}
