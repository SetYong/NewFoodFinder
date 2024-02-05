package project3.newfoodfinder.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
public class MemberFormDTO {

    @NotBlank(message = "이름을 입력해주세요.")
    private String username;

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userid;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotBlank(message = "주민등록번호를 입력해주세요.")
    private String ssn;

    @NotBlank(message = "이메일을 입력해주세요.")
    private String mail;

    @NotBlank(message = "핸드폰 번호를 입력해주세요.")
    private String phone;

    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickname;

    @NotBlank(message = "주소를 입력해주세요.")
    private String address;

    @Builder
    public MemberFormDTO(String username, String userid, String password, String ssn, String mail, String phone, String nickname, String address){
        this.username = username;
        this.userid = userid;
        this.password = password;
        this.ssn = ssn;
        this.mail = mail;
        this.phone = phone;
        this.nickname = nickname;
        this.address = address;
    }
}
