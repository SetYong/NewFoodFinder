package project3.newfoodfinder.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.thymeleaf.util.StringUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRequest {

    private Long User_num;
    private String user_id;
    private String password;
    private String user_name;
    private String mail;
    private String phone;
    private String ssn;
    private String nickname;
    private Long admin_check;


}
