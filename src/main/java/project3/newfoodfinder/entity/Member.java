package project3.newfoodfinder.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.security.PublicKey;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "MEMBER_TB")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "MEMBER_LOGIN_ID", nullable = false)
    private String loginId;

    @Column(name = "MEMBER_NAME", nullable = false)
    private String name;

    @Column(name = "MEMBER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "MEMBER_EMAIL", nullable = false)
    private String email;

    @Column(name = "ISRT_DATE")
    private LocalDateTime isrtDate;

    @Column(name = "UPDT_DATE")
    private LocalDateTime updtDate;

    private String imgUrl;

}
