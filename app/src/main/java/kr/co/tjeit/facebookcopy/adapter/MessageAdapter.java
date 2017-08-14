package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.ViewUserInfoActivity;
import kr.co.tjeit.facebookcopy.data.FriendRequestData;
import kr.co.tjeit.facebookcopy.data.MessageData;

/**
 * Created by user on 2017-08-08.
 */

public class MessageAdapter extends ArrayAdapter<MessageData> {


    Context mContext;
    List<MessageData> mList;
    LayoutInflater inf;

    public MessageAdapter(Context context, List<MessageData> list) {
        super(context, R.layout.friend_request_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.message_list_item, null);
        }

        final MessageData data = mList.get(position);

        ImageView profileImg = (ImageView) row.findViewById(R.id.profileImg);
        TextView userNameTxt = (TextView) row.findViewById(R.id.userNameTxt);
        TextView contentTxt = (TextView) row.findViewById(R.id.contentTxt);

        userNameTxt.setText(data.getSendUserData().getUserName());
        contentTxt.setText(data.getContent());

        View.OnClickListener infoListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ViewUserInfoActivity.class);
                intent.putExtra("친구요청데이터", new FriendRequestData(12, data.getSendUserData()));
                mContext.startActivity(intent);
            }
        };

        profileImg.setOnClickListener(infoListener);
        userNameTxt.setOnClickListener(infoListener);

        return row;
    }

}
