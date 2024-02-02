package project3.newfoodfinder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import project3.newfoodfinder.domain.MemberRole;
import project3.newfoodfinder.dto.MemberFormDTO;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mbnum;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String ssn;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Builder
    public Member(String username, String userid, String password, String ssn, String mail, String phone, String nickname){
        this.username = username;
        this.userid = userid;
        this.password = password;
        this.ssn = ssn;
        this.mail = mail;
        this.phone = phone;
        this.nickname = nickname;
    }

    public static Member createMember(MemberFormDTO memberFormDTO, PasswordEncoder passwordEncoder){
        Member member = Member.builder()
                .username(memberFormDTO.getUsername())
                .userid(memberFormDTO.getUserid())
                .password(memberFormDTO.getPassword())
                .ssn(memberFormDTO.getSsn())
                .mail(memberFormDTO.getMail())
                .phone(memberFormDTO.getPhone())
                .nickname(memberFormDTO.getNickname())
                .build();
        return member;
    }

}
