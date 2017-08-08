package kr.co.tjeit.facebookcopy.util;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.facebookcopy.data.FriendRequestData;
import kr.co.tjeit.facebookcopy.data.NotificationData;

/**
 * Created by user on 2017-08-08.
 */

public class GlobalDatas {

    public static List<FriendRequestData> friendRequestDatas = new ArrayList<>();
    public static List<NotificationData> notificationDatas = new ArrayList<>();

    public static void initDatas() {
        friendRequestDatas.clear();
        friendRequestDatas.add(new FriendRequestData("",7,"고동윤"));
        friendRequestDatas.add(new FriendRequestData("",1,"권성민"));
        friendRequestDatas.add(new FriendRequestData("",10,"김현철"));
        friendRequestDatas.add(new FriendRequestData("",15,"박석영"));
        friendRequestDatas.add(new FriendRequestData("",8,"박수현"));
        friendRequestDatas.add(new FriendRequestData("",7,"박영주"));
        friendRequestDatas.add(new FriendRequestData("",4,"손익상"));
        friendRequestDatas.add(new FriendRequestData("",8,"이승헌"));
        friendRequestDatas.add(new FriendRequestData("",10,"이요한"));
        friendRequestDatas.add(new FriendRequestData("",12,"최종환"));
        friendRequestDatas.add(new FriendRequestData("",13,"한상열"));


        notificationDatas.clear();
        notificationDatas.add(new NotificationData("", "10명이 내 글을 좋아합니다.", 1, 1));
        notificationDatas.add(new NotificationData("", "~~가 내 글에 댓글을 남겼습니다.", 2, 40));
        notificationDatas.add(new NotificationData("", "~~가 회원님을 팔로우 합니다.", 3, 70));
        notificationDatas.add(new NotificationData("", "~~가 내 댓글을 좋아합니다.", 4, 230));
        notificationDatas.add(new NotificationData("", "~~가 친구 요청을 수락했습니다.", 5, 600));

    }

}









