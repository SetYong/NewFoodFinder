package project3.newfoodfinder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Reply extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    private Member User_num;

    @Id
    private Long headnum;

    private String nickname;
    private String text;
    private String cate;
}
