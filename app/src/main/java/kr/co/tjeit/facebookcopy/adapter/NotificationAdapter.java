package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.data.FriendRequestData;
import kr.co.tjeit.facebookcopy.data.NotificationData;
import kr.co.tjeit.facebookcopy.util.TimeAgoUtil;

/**
 * Created by user on 2017-08-08.
 */

public class NotificationAdapter extends ArrayAdapter<NotificationData> {

    Context mContext;
    List<NotificationData> mList;
    LayoutInflater inf;

    public NotificationAdapter(Context context, List<NotificationData> list) {
        super(context, R.layout.notification_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.notification_list_item, null);
        }

        // 1. 뿌려줄 데이터를 가져오기.
        // 어떤 데이터? 알림 데이터. 변수로 저장.

        NotificationData data = mList.get(position);

        // 2. 데이터가 들어갈 뷰들을 바인딩
        TextView notificationTxt = (TextView) row.findViewById(R.id.notificationTxt);
        TextView minuteAgoTxt = (TextView) row.findViewById(R.id.minuteAgoTxt);

        // 3. 데이터 세팅 (setText)

        notificationTxt.setText(data.getNotificaionText());

        String minuteStr = TimeAgoUtil.getTimeAgoString(data.getMinuteAgo());
        minuteAgoTxt.setText(minuteStr);


        return row;
    }

}
