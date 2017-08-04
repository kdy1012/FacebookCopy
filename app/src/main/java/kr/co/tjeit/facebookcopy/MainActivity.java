package kr.co.tjeit.facebookcopy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.crypto.spec.PSource;

import kr.co.tjeit.facebookcopy.fragment.FriendRequestFragment;
import kr.co.tjeit.facebookcopy.fragment.NewsfeedFragment;
import kr.co.tjeit.facebookcopy.fragment.SeeMoreFragment;

public class MainActivity extends AppCompatActivity {

    ViewPager mainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mainViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {

                return new NewsfeedFragment();
            }
            else if (position == 1) {

                return new FriendRequestFragment();
            }
            else {
                return new SeeMoreFragment();
            }

        }
    }
}










