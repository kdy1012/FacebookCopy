package kr.co.tjeit.facebookcopy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import kr.co.tjeit.facebookcopy.fragment.FriendRequestFragment;
import kr.co.tjeit.facebookcopy.fragment.MessageFragment;
import kr.co.tjeit.facebookcopy.fragment.NewsfeedFragment;
import kr.co.tjeit.facebookcopy.fragment.NotificationFragment;
import kr.co.tjeit.facebookcopy.fragment.SeeMoreFragment;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

public class MainActivity extends AppCompatActivity {

    ViewPager mainViewPager;
    private android.widget.LinearLayout newsfeedBtnLayout;
    private android.widget.LinearLayout friendRequestBtnLayout;
    private android.widget.LinearLayout messageBtnLayout;
    private android.widget.LinearLayout notificationBtnLayout;
    private android.widget.LinearLayout seeMoreBtnLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();

    }

    private void setValues() {
        GlobalDatas.initDatas();
        mainViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private void setupEvents() {
        newsfeedBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(0);
            }
        });
    }

    private void bindViews() {
        this.seeMoreBtnLayout = (LinearLayout) findViewById(R.id.seeMoreBtnLayout);
        this.notificationBtnLayout = (LinearLayout) findViewById(R.id.notificationBtnLayout);
        this.messageBtnLayout = (LinearLayout) findViewById(R.id.messageBtnLayout);
        this.friendRequestBtnLayout = (LinearLayout) findViewById(R.id.friendRequestBtnLayout);
        this.newsfeedBtnLayout = (LinearLayout) findViewById(R.id.newsfeedBtnLayout);
        mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {

                return new NewsfeedFragment();
            }
            else if (position == 1) {

                return new FriendRequestFragment();
            }
            else if (position == 2) {
                return new MessageFragment();
            }
            else if (position == 3) {
                return new NotificationFragment();
            }
            else {
                return new SeeMoreFragment();
            }

        }
    }
}










