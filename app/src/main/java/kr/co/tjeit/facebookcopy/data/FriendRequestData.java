package kr.co.tjeit.facebookcopy.data;

import java.io.Serializable;

/**
 * Created by user on 2017-08-08.
 */

public class FriendRequestData implements Serializable {

    private int commonFriendsCount;
    private UserData requestUserData;

    public FriendRequestData() {
    }

    public FriendRequestData(int commonFriendsCount, UserData requestUserData) {
        this.commonFriendsCount = commonFriendsCount;
        this.requestUserData = requestUserData;
    }

    public int getCommonFriendsCount() {
        return commonFriendsCount;
    }

    public void setCommonFriendsCount(int commonFriendsCount) {
        this.commonFriendsCount = commonFriendsCount;
    }

    public UserData getRequestUserData() {
        return requestUserData;
    }

    public void setRequestUserData(UserData requestUserData) {
        this.requestUserData = requestUserData;
    }
}
