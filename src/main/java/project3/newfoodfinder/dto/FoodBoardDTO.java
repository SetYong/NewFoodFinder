package project3.newfoodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project3.newfoodfinder.entity.Member;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodBoardDTO {

    private Long headnum;
    private String title;
    private String content;
    private String recipe;
    private Member User_num;

    private LocalDateTime regDate, modDate;
}
