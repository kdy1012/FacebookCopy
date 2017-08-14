package kr.co.tjeit.facebookcopy.data;

/**
 * Created by user on 2017-08-14.
 */

public class UserData {
    private int userId; // DB에 몇번째 사용자로 등록되었는지.
    // 몇번째? 의미 없다. => 이 숫자는 절대 중복되지 않음.
    // 10번 사용자 : 조경진 => 절대 다른 10번 사용자는 존재하지 않음.
    // 반대로, 10번 사용자가 반드시 조경진이다 라는 확신을 주는 역할.
    private String userName;
    private String profileImgPath;

    public UserData() {
    }

    public UserData(int userId, String userName, String profileImgPath) {
        this.userId = userId;
        this.userName = userName;
        this.profileImgPath = profileImgPath;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileImgPath() {
        return profileImgPath;
    }

    public void setProfileImgPath(String profileImgPath) {
        this.profileImgPath = profileImgPath;
    }
}
