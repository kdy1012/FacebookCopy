package kr.co.tjeit.facebookcopy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.tjeit.facebookcopy.adapter.ReplyAdapter;
import kr.co.tjeit.facebookcopy.data.ReplyData;

public class ReplyListActivity extends AppCompatActivity {

    private android.widget.ListView replyList;
    List<ReplyData> replyDatas = new ArrayList<>();
    ReplyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_list);
        bindViews();
        setupEvents();
        setValues();
        addDatas();
    }

    private void addDatas() {
        replyDatas.clear();
        replyDatas.add(new ReplyData(1,0,"김태희","김태희입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(2,1,"아이유","아이유입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(3,1,"수지","수지입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(5,1,"조경진","조경진입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(4,0,"비","비입니다.", Calendar.getInstance()));

        mAdapter.notifyDataSetChanged();
    }

    private void setValues() {
        mAdapter = new ReplyAdapter(ReplyListActivity.this, replyDatas);
        replyList.setAdapter(mAdapter);
    }

    private void setupEvents() {

    }

    private void bindViews() {

        this.replyList = (ListView) findViewById(R.id.replyList);
    }
}
