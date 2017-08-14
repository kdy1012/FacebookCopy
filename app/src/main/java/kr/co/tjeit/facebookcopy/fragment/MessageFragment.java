package kr.co.tjeit.facebookcopy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import kr.co.tjeit.facebookcopy.ChattingActivity;
import kr.co.tjeit.facebookcopy.MainActivity;
import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.adapter.MessageAdapter;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

/**
 * Created by user on 2017-08-08.
 */

public class MessageFragment extends Fragment {

    ListView messageListView;
    MessageAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message, container, false);
        messageListView = (ListView) v.findViewById(R.id.messageListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setValues() {
        mAdapter = new MessageAdapter(getActivity(), GlobalDatas.messageDatas);
        messageListView.setAdapter(mAdapter);
    }

    private void setupEvents() {
        messageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ChattingActivity.class);
                intent.putExtra("messageData", GlobalDatas.messageDatas.get(position));
                startActivity(intent);
            }
        });

    }
}
