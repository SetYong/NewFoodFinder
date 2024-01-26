package project3.newfoodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDTO {
    private Long mbnum;
    private String userid;
    private String password;
    private String name;
    private String mail;
    private String mail1;
    private String mail2;
    private String phone;
    private String phone1;
    private String phone2;
    private String phone3;
    private String ssn;
    private String ssn1;
    private String ssn2;
    private String nickname;
}
