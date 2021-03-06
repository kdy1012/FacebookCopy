package kr.co.tjeit.facebookcopy.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.tjeit.facebookcopy.data.FriendRequestData;
import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.data.NewsfeedData;
import kr.co.tjeit.facebookcopy.data.NotificationData;
import kr.co.tjeit.facebookcopy.data.UserData;

/**
 * Created by user on 2017-08-08.
 */

public class GlobalDatas {

    public static UserData loginUserData = null;
    // 로그인한 사용자의 정보를 저장하는 클래스.
    // null 일 경우에는, 아직 로그인 하지 않은 상태.
    // 객체화 되어있을 경우, 이 객체에 담긴 사람이 로그인한걸로 간주.

    public static List<UserData> userDatas = new ArrayList<>();
    public static List<FriendRequestData> friendRequestDatas = new ArrayList<>();
    public static List<NotificationData> notificationDatas = new ArrayList<>();
    public static List<NewsfeedData> newsfeedDatas = new ArrayList<>();
    public static List<MessageData> messageDatas = new ArrayList<>();

    public static void initDatas() {

        loginUserData= new UserData(10, "조경진", "https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/images.jpg");

        userDatas.add(new UserData(1, "고동윤", ""));
        userDatas.add(new UserData(2, "권성민", ""));
        userDatas.add(new UserData(3, "김현철", ""));
        userDatas.add(new UserData(4, "박석영", ""));
        userDatas.add(new UserData(5, "박수현", ""));

        friendRequestDatas.clear();
        friendRequestDatas.add(new FriendRequestData(10, userDatas.get(0)));
        friendRequestDatas.add(new FriendRequestData(12, userDatas.get(1)));
        friendRequestDatas.add(new FriendRequestData(15, userDatas.get(2)));
        friendRequestDatas.add(new FriendRequestData(31, userDatas.get(3)));
        friendRequestDatas.add(new FriendRequestData(2, userDatas.get(4)));


        notificationDatas.clear();
        notificationDatas.add(new NotificationData("", "10명이 내 글을 좋아합니다.", 1, 1));
        notificationDatas.add(new NotificationData("", "~~가 내 글에 댓글을 남겼습니다.", 2, 40));
        notificationDatas.add(new NotificationData("", "~~가 회원님을 팔로우 합니다.", 3, 70));
        notificationDatas.add(new NotificationData("", "~~가 내 댓글을 좋아합니다.", 4, 230));
        notificationDatas.add(new NotificationData("", "~~가 친구 요청을 수락했습니다.", 5, 600));


        newsfeedDatas.clear();
        newsfeedDatas.add(new NewsfeedData(userDatas.get(0), "http://naver.com", "", 2, "네이버로 링크를 걸어주는 뉴스피드입니다.", 12));
        newsfeedDatas.add(new NewsfeedData(userDatas.get(2), "http://google.com", "", 10, "구글로 링크를 걸어주는 뉴스피드입니다.", 5));
        newsfeedDatas.add(new NewsfeedData(userDatas.get(2), "", "", 45, "일기처럼 글만 적힌 뉴스피드.", 125));
        newsfeedDatas.add(new NewsfeedData(userDatas.get(2), "", "", 230, "사진 올린 뉴스피드.", 2453));
        newsfeedDatas.add(new NewsfeedData(userDatas.get(1), "", "", 800, "동영상 뉴스피드", 121371));


        messageDatas.clear();
        messageDatas.add(new MessageData(userDatas.get(0), "고동윤입니다.",
                Calendar.getInstance()));
        messageDatas.add(new MessageData(userDatas.get(1), "권성민입니다.",
                Calendar.getInstance()));
        messageDatas.add(new MessageData(userDatas.get(2), "김현철입니다.",
                Calendar.getInstance()));
        messageDatas.add(new MessageData(userDatas.get(3), "박석영입니다.",
                Calendar.getInstance()));
        messageDatas.add(new MessageData(userDatas.get(4), "박수현입니다.",
                Calendar.getInstance()));

    }

}









