package project3.newfoodfinder.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
public class QuestionBoard extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long headnum;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member User_num;

    private String title;
    private String content;
    private String answer;

    @ColumnDefault("0")
    private Long admin_check;
}
