package project3.newfoodfinder.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
public class FoodBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long headnum;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member User_num;

    private String title;
    private String content;
    private String recipe;
    private String image;
    private String imagepath;
    private Long visitcount;
    private Long heartcount;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Long admin_check;
}
