package kr.co.tjeit.facebookcopy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private android.widget.TextView titleTxt;
    private LinearLayout statusBtnLayout;
    private LinearLayout newsfeedUsageBtnsLayout;

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

        statusBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditStatusActivity.class);
                startActivity(intent);
            }
        });

        newsfeedBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(0);
            }
        });

        friendRequestBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(1);
            }
        });
        messageBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(2);
            }
        });
        notificationBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(3);
            }
        });
        seeMoreBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(4);
            }
        });

        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 한장의 페이지로 자리를 잡았을 때.

                // 페이지에 맞는 제목을 설정
                if (position == 0) {
                    titleTxt.setText("뉴스피드");
                } else if (position == 1) {
                    titleTxt.setText("요청");
                } else if (position == 2) {
                    titleTxt.setText("메세지");
                } else if (position == 3) {
                    titleTxt.setText("알림");
                } else if (position == 4) {
                    titleTxt.setText("더 보기");
                }


                // 뉴스피드일때만 버튼들을 보여주고, 그 외엔 숨김.
                if (position == 0) {
                    newsfeedUsageBtnsLayout.setVisibility(View.VISIBLE);
                } else {
                    newsfeedUsageBtnsLayout.setVisibility(View.GONE);
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void bindViews() {
        this.seeMoreBtnLayout = (LinearLayout) findViewById(R.id.seeMoreBtnLayout);
        this.notificationBtnLayout = (LinearLayout) findViewById(R.id.notificationBtnLayout);
        this.messageBtnLayout = (LinearLayout) findViewById(R.id.messageBtnLayout);
        this.friendRequestBtnLayout = (LinearLayout) findViewById(R.id.friendRequestBtnLayout);
        this.newsfeedBtnLayout = (LinearLayout) findViewById(R.id.newsfeedBtnLayout);
        this.mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        this.newsfeedUsageBtnsLayout = (LinearLayout) findViewById(R.id.newsfeedUsageBtnsLayout);
        this.statusBtnLayout = (LinearLayout) findViewById(R.id.statusBtnLayout);
        this.titleTxt = (TextView) findViewById(R.id.titleTxt);
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
            } else if (position == 1) {

                return new FriendRequestFragment();
            } else if (position == 2) {
                return new MessageFragment();
            } else if (position == 3) {
                return new NotificationFragment();
            } else {
                return new SeeMoreFragment();
            }

        }
    }
}










