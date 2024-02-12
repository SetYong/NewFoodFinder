package project3.newfoodfinder.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDTO {

    private Long User_num;
    private String user_id;
    private String password;
    private String user_name;
    private String ssn;
    private String mail;
    private String nickname;
    private String phone;
    private Long admin_check;
    private LocalDateTime regdate;
    private LocalDateTime moddate;
}
