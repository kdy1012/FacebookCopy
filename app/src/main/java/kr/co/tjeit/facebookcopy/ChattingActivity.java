package kr.co.tjeit.facebookcopy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
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
