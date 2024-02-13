package project3.newfoodfinder.domain;

import lombok.Getter;

@Getter
public class MemberResponse {

    private Long User_num;
    private String user_id;
    private String password;
    private String user_name;
    private String mail;
    private String phone;
    private String ssn;
    private String nickname;
    private Long admin_check;

    public void clearPassword(){
        this.password = "";
    }
}
