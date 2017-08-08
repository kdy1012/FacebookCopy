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

        String minuteStr = "";

        if (data.getMinuteAgo() <= 2) {
            minuteStr = "방금 전";
        }
        else if (data.getMinuteAgo() <= 40) {
            // 2보다는 크고, 40보다는 작은 상황임.

            minuteStr = String.format(Locale.KOREA, "%d분 전", data.getMinuteAgo());

        }
        else if (data.getMinuteAgo() <= 90) {
            minuteStr = "한시간 전";
        }
        else if (data.getMinuteAgo() <= 510) {
            int hour = (data.getMinuteAgo() + 29) / 60;
            minuteStr = String.format(Locale.KOREA, "%d시간 전", hour);

        }
        else  {
            minuteStr = "오래 전";
        }

        minuteAgoTxt.setText(minuteStr);


        return row;
    }

}
