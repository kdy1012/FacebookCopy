package kr.co.tjeit.facebookcopy;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.tjeit.facebookcopy.adapter.ChattingAdapter;
import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

public class ChattingActivity extends AppCompatActivity {

    private android.widget.ListView chattingListView;
    List<MessageData> messageDatas = new ArrayList<>();
    ChattingAdapter mAdapter;
    private android.widget.EditText contentEdt;
    private android.widget.Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        bindViews();
        setupEvents();
        setValues();
        addMessageDatas();
    }

    private void addMessageDatas() {
        messageDatas.clear();

        messageDatas.add(new MessageData(10, "ㅎㅇㅎㅇ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅇㅇ", Calendar.getInstance()));
        messageDatas.add(new MessageData(9, "ㅋㅋㅋ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅁㅎ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㄹ?", Calendar.getInstance()));
        messageDatas.add(new MessageData(9, "ㄴㄴ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅇㅋㅇㅋ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅂㅇㅂㅇ", Calendar.getInstance()));
        messageDatas.add(new MessageData(9, "ㅇㅋ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅇㅇ", Calendar.getInstance()));

        mAdapter.notifyDataSetChanged();


    }

    private void setValues() {
        mAdapter = new ChattingAdapter(ChattingActivity.this, messageDatas);
        chattingListView.setAdapter(mAdapter);
    }

    private void setupEvents() {
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                messageDatas.add(new MessageData(GlobalDatas.loginUserId,
                        contentEdt.getText().toString(),
                        Calendar.getInstance()));

                mAdapter.notifyDataSetChanged();

                contentEdt.setText("");

                View view = ChattingActivity.this.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

                chattingListView.setSelection(mAdapter.getCount() - 1);

            }
        });
    }

    private void bindViews() {
        this.sendBtn = (Button) findViewById(R.id.sendBtn);
        this.contentEdt = (EditText) findViewById(R.id.contentEdt);
        this.chattingListView = (ListView) findViewById(R.id.chattingListView);
    }
}
