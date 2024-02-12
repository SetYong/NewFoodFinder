package project3.newfoodfinder.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long User_num;

    @Column(length=50, nullable = false)
    private String user_id;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String user_name;

    @Column(length = 100, nullable = false)
    private String mail;

    @Column(length = 100, nullable = false)
    private String phone;

    @Column(length = 50, nullable = false)
    private String ssn;

    @Column(length = 200, nullable = false)
    private String nickname;

    @Column(length = 50, nullable = false)
    @ColumnDefault("0")
    private Long admin_check;

    public void changePassword(String password){
        this.password = password;
    }
    public void changeName(String user_name){
        this.user_name = user_name;
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
