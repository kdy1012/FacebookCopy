package kr.co.tjeit.facebookcopy.data;

import java.io.Serializable;

/**
 * Created by user on 2017-08-08.
 */

public class NewsfeedData implements Serializable {

    private UserData writerData;
    private String linkUrl;
    private String userImagePath;
    private int minuteAgo;
    private String contentText;
    private int likeCount;

    public NewsfeedData() {
    }

    public NewsfeedData(UserData writerData, String linkUrl, String userImagePath, int minuteAgo, String contentText, int likeCount) {
        this.writerData = writerData;
        this.linkUrl = linkUrl;
        this.userImagePath = userImagePath;
        this.minuteAgo = minuteAgo;
        this.contentText = contentText;
        this.likeCount = likeCount;
    }

    public UserData getWriterData() {
        return writerData;
    }

    public void setWriterData(UserData writerData) {
        this.writerData = writerData;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getUserImagePath() {
        return userImagePath;
    }

    public void setUserImagePath(String userImagePath) {
        this.userImagePath = userImagePath;
    }

    public int getMinuteAgo() {
        return minuteAgo;
    }

    public void setMinuteAgo(int minuteAgo) {
        this.minuteAgo = minuteAgo;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
