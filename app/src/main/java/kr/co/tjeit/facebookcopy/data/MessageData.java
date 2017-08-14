package kr.co.tjeit.facebookcopy.data;

import java.util.Calendar;

/**
 * Created by user on 2017-08-08.
 */

public class MessageData {

    private UserData sendUserData;
    private String content;
    private Calendar sendTime;

    public MessageData() {
    }

    public MessageData(UserData sendUserData, String content, Calendar sendTime) {
        this.sendUserData = sendUserData;
        this.content = content;
        this.sendTime = sendTime;
    }

    public UserData getSendUserData() {
        return sendUserData;
    }

    public void setSendUserData(UserData sendUserData) {
        this.sendUserData = sendUserData;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getSendTime() {
        return sendTime;
    }

    public void setSendTime(Calendar sendTime) {
        this.sendTime = sendTime;
    }
}

