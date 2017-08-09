package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.data.ReplyData;

/**
 * Created by user on 2017-08-09.
 */

public class ReplyAdapter extends ArrayAdapter<ReplyData> {



    Context mContext;
    List<ReplyData> mList;
    LayoutInflater inf;

    public ReplyAdapter(Context context, List<ReplyData> list) {
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
            row = inf.inflate(R.layout.reply_list_item, null);
        }

        ReplyData data = mList.get(position);

        LinearLayout replyLayout = (LinearLayout) row.findViewById(R.id.replyLayout);
        LinearLayout replyOfReplyLayout = (LinearLayout) row.findViewById(R.id.replyOfReplyLayout);

        if (data.getParentReplyId() == 0) {
            // 댓글인 상황
            replyLayout.setVisibility(View.VISIBLE);
            replyOfReplyLayout.setVisibility(View.GONE);

        }
        else {
            // 대댓글인 상황
            replyLayout.setVisibility(View.GONE);
            replyOfReplyLayout.setVisibility(View.VISIBLE);
        }


        return row;
    }

}











