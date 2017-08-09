package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

/**
 * Created by user on 2017-08-09.
 */

public class ChattingAdapter extends ArrayAdapter<MessageData> {


    Context mContext;
    List<MessageData> mList;
    LayoutInflater inf;

    public ChattingAdapter(Context context, List<MessageData> list) {
        super(context, R.layout.message_chat_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.message_chat_list_item, null);
        }

        MessageData data = mList.get(position);

        LinearLayout myMessage = (LinearLayout) row.findViewById(R.id.myMessage);
        LinearLayout opponentMessage = (LinearLayout) row.findViewById(R.id.opponentMessage);

        if (GlobalDatas.loginUserId == data.getSendUserId()) {
            // 메세지를 보낸 사람이 나다
            myMessage.setVisibility(View.VISIBLE);
            opponentMessage.setVisibility(View.GONE);

            TextView myMessageTxt = (TextView) row.findViewById(R.id.myMessageTxt);
            myMessageTxt.setText(data.getContent());

        }
        else {
            myMessage.setVisibility(View.GONE);
            opponentMessage.setVisibility(View.VISIBLE);
            // 다른 사람이 보낸 메세지다

            TextView opponentMessageTxt = (TextView) row.findViewById(R.id.opponentMessageTxt);
            opponentMessageTxt.setText(data.getContent());
        }


//        opponentMessageTxt.bringToFront();


        return row;
    }


}
