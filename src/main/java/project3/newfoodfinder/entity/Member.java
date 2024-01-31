package project3.newfoodfinder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mbnum;

    @Column(length=50, nullable = false)
    private String userid;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String mail;

    @Column(length = 100, nullable = false)
    private String phone;

    @Column(length = 50, nullable = false)
    private String ssn;

    @Column(length = 200, nullable = false)
    private String nickname;

    public void changePassword(String password){
        this.password = password;
    }
    public void changeName(String name){
        this.name = name;
    }
    public void changeMail(String mail){
        this.mail = mail;
    }
    public void changePhone(String phone){
        this.phone = phone;
    }
    public void changeNickname(String nickname){
        this.nickname = nickname;
    }
}
