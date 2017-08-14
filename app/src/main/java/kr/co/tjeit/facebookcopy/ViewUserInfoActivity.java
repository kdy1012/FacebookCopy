package kr.co.tjeit.facebookcopy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

import kr.co.tjeit.facebookcopy.data.FriendRequestData;
import kr.co.tjeit.facebookcopy.data.MessageData;

public class ViewUserInfoActivity extends AppCompatActivity {

    FriendRequestData mFriendRequestData = null;
    private android.widget.TextView userNameTxt;
    private android.widget.TextView commonFriendsCountTxt;
    private android.widget.TextView textView;
    private android.widget.LinearLayout messageBtnLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_info);
        mFriendRequestData = (FriendRequestData) getIntent().getSerializableExtra("친구요청데이터");

//      받아온 데이터를 화면에 출력.
        bindViews();
        setupEvents();
        setValues();
    }

    private void setValues() {
        userNameTxt.setText(mFriendRequestData.getRequestUserData().getUserName());
        String friendsCountStr = String.format(Locale.KOREA, "함께 아는 친구 %d명", mFriendRequestData.getCommonFriendsCount());
        commonFriendsCountTxt.setText(friendsCountStr);
    }

    private void setupEvents() {

        messageBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewUserInfoActivity.this, ChattingActivity.class);
                intent.putExtra("messageData", new MessageData(mFriendRequestData.getRequestUserData(),
                        "", Calendar.getInstance()));
                startActivity(intent);
            }
        });
    }

    private void bindViews() {
        this.textView = (TextView) findViewById(R.id.textView);
        this.messageBtnLayout = (LinearLayout) findViewById(R.id.messageBtnLayout);
        this.commonFriendsCountTxt = (TextView) findViewById(R.id.commonFriendsCountTxt);
        this.userNameTxt = (TextView) findViewById(R.id.userNameTxt);
    }
}
