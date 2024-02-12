package project3.newfoodfinder.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DiaryBoard extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long headnum;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member User_num;

    private String title;
    private String content;
    private Long kcal;

}
