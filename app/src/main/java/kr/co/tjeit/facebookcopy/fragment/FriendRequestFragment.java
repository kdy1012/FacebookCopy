package kr.co.tjeit.facebookcopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import kr.co.tjeit.facebookcopy.MainActivity;
import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.adapter.FriendRequestAdapter;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

/**
 * Created by user on 2017-08-04.
 */

public class FriendRequestFragment extends Fragment {

    ListView friendRequestListView;
    FriendRequestAdapter friendRequestAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_friend_request, container, false);
        // XML, JAVA 매핑 => bindViews 역할.
        friendRequestListView = (ListView) v.findViewById(R.id.friendRequestListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // fragment에서 onCreate 대신 사용하는 메쏘드.

        setupEvents();
        setValues();
    }

    private void setupEvents() {
        // 객체들이 터치된 이벤트를 처리
    }

    private void setValues() {
        // 화면에 표시될 데이터 가공 / set

        friendRequestAdapter = new FriendRequestAdapter(getActivity(), GlobalDatas.friendRequestDatas);
        friendRequestListView.setAdapter(friendRequestAdapter);


    }

}







