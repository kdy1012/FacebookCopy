package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.ReplyListActivity;
import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.data.ReplyData;

/**
 * Created by user on 2017-08-09.
 */

public class ReplyAdapter extends ArrayAdapter<ReplyData> {

    public String myName = "임시변수";

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

        final ReplyData data = mList.get(position);

        LinearLayout replyLayout = (LinearLayout) row.findViewById(R.id.replyLayout);
        LinearLayout replyOfReplyLayout = (LinearLayout) row.findViewById(R.id.replyOfReplyLayout);

        if (data.getParentReplyId() == 0) {
            // 댓글인 상황
            replyLayout.setVisibility(View.VISIBLE);
            replyOfReplyLayout.setVisibility(View.GONE);

            TextView replyUserNameTxt = (TextView) row.findViewById(R.id.replyUserNameTxt);
            TextView replyContentTxt = (TextView) row.findViewById(R.id.replyContentTxt);

            replyUserNameTxt.setText(data.getWriterName());
            replyContentTxt.setText(data.getReplyContent());

            TextView makeRorTxt1 = (TextView) row.findViewById(R.id.makeRorTxt1);
            makeRorTxt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int originalReplyNum = data.getReplyId();
                    Log.d("original", originalReplyNum+"");

                    // Adapter처럼 부속품으로 활용되는 코드에서
                    // Activity에 접근을 해야하는 상황이 발생.

                    // 그럴때 처리하는 방법?
                    // => ((액티비티이름) mContext).활용
                    // 액티비티에서는 반드시 public 열어줘야함.
                    // getter setter 활용해서 메쏘드만 public으로 열어줘도 됨.
                    ((ReplyListActivity) mContext).replyEdt.setTag(originalReplyNum);

                }
            });

        }
        else {
            // 대댓글인 상황
            replyLayout.setVisibility(View.GONE);
            replyOfReplyLayout.setVisibility(View.VISIBLE);

            TextView rorNameTxt = (TextView) row.findViewById(R.id.rorNameTxt);
            TextView rorContentTxt = (TextView) row.findViewById(R.id.rorContentTxt);

            rorNameTxt.setText(data.getWriterName());
            rorContentTxt.setText(data.getReplyContent());

            TextView makeRorTxt2 = (TextView) row.findViewById(R.id.makeRorTxt2);
            makeRorTxt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int originalReplyNum = data.getParentReplyId();
                    Log.d("original", originalReplyNum+"");

                    ((ReplyListActivity) mContext).replyEdt.setTag(originalReplyNum);
                }
            });
        }


        return row;
    }

}











