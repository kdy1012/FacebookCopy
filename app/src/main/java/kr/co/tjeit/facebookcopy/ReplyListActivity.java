package kr.co.tjeit.facebookcopy;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.tjeit.facebookcopy.adapter.ReplyAdapter;
import kr.co.tjeit.facebookcopy.data.ReplyData;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

public class ReplyListActivity extends AppCompatActivity {

    private android.widget.ListView replyList;
    List<ReplyData> replyDatas = new ArrayList<>();
    ReplyAdapter mAdapter;
    public android.widget.EditText replyEdt;
    private android.widget.Button sendBtn;
    private Button likeBtn;
    private Button replyBtn;

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
        replyDatas.add(new ReplyData(1, 0, "김태희", "김태희입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(2, 1, "아이유", "아이유입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(3, 1, "수지", "수지입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(5, 1, "조경진", "조경진입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(4, 0, "비", "비입니다.", Calendar.getInstance()));

        mAdapter.notifyDataSetChanged();


    }

    private void setValues() {
        mAdapter = new ReplyAdapter(ReplyListActivity.this, replyDatas);
        replyList.setAdapter(mAdapter);
    }

    private void setupEvents() {

        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReplyListActivity.this, "해당 게시물을 좋아합니다.", Toast.LENGTH_SHORT).show();
            }
        });

        replyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 구글링해서 찾아넣은 키보드 띄우는 부분.
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

                // EditText에 입력 모드로 전환

                if(replyEdt.requestFocus()) {
                    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }


            }
        });



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputString = replyEdt.getText().toString();

                // Adapter에서 EditText에 달아둔 태그를 받아서
                // 숫자로 변환해 저장하는 부분.
                int parentId = Integer.parseInt(replyEdt.getTag().toString());


                // 파고 들어갈 위치를 찾는 알고리즘.
                int index = replyDatas.size();

                if (parentId != 0) {
                    // 누군가의 대댓글로 들어가야 하는 상황.
                    // index를 적절하게 찾아줘야함.

                    // 1,2,3,5,8,9 => 6 => 정렬
                    // 2,1,3,4,6,8 => 작은것부터 차례대로

                    for (int i = 0; i < replyDatas.size(); i++) {
                        ReplyData data = replyDatas.get(i);
                        if (parentId == data.getReplyId()) {
                            index = i;
                        } else if (parentId == data.getParentReplyId()) {
                            index = i;
                        }
                    }
                }

                if (parentId == 0) {
                    replyDatas.add(index, new ReplyData(replyDatas.size() + 1, parentId,
                            GlobalDatas.loginUserData.getUserName(), inputString, Calendar.getInstance()));
                }
                else {
                    replyDatas.add(index + 1, new ReplyData(replyDatas.size() + 1, parentId,
                            GlobalDatas.loginUserData.getUserName(), inputString, Calendar.getInstance()));
                }
                mAdapter.notifyDataSetChanged();


                // 리스트뷰 맨 밑으로 끌어내리기
                replyList.setSelection(mAdapter.getCount() - 1);

                replyEdt.setText("");
            }
        });
    }

    private void bindViews() {
        this.sendBtn = (Button) findViewById(R.id.sendBtn);
        this.replyEdt = (EditText) findViewById(R.id.replyEdt);
        this.replyList = (ListView) findViewById(R.id.replyList);
        this.replyBtn = (Button) findViewById(R.id.replyBtn);
        this.likeBtn = (Button) findViewById(R.id.likeBtn);
    }
}
