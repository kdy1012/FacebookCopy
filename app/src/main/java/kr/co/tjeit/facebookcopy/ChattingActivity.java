package kr.co.tjeit.facebookcopy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.tjeit.facebookcopy.adapter.ChattingAdapter;
import kr.co.tjeit.facebookcopy.data.MessageData;

public class ChattingActivity extends AppCompatActivity {

    private android.widget.ListView chattingListView;
    List<MessageData> messageDatas = new ArrayList<>();
    ChattingAdapter mAdapter;

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

    }

    private void bindViews() {

        this.chattingListView = (ListView) findViewById(R.id.chattingListView);
    }
}
