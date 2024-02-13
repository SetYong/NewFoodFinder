package project3.newfoodfinder.service;

import project3.newfoodfinder.dto.FoodBoardDTO;
import project3.newfoodfinder.dto.PageRequestDTO;
import project3.newfoodfinder.dto.PageResultDTO;
import project3.newfoodfinder.entity.FoodBoard;

public interface FoodService {
    Long register(FoodBoardDTO dto);

    FoodBoardDTO read(Long gno);

    void remove(Long gno);

    void modify(FoodBoardDTO dto);
    PageResultDTO<FoodBoardDTO, FoodBoard> getList(PageRequestDTO requestDTO);
    default FoodBoard dtoToEntity(FoodBoardDTO dto){
        FoodBoard entity = FoodBoard.builder()
                .headnum(dto.getHeadnum())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        return entity;
    }

    default FoodBoardDTO entityToDto(FoodBoard entity){
        FoodBoardDTO dto = FoodBoardDTO.builder()
                .headnum(entity.getHeadnum())
                .title(entity.getTitle())
                .content(entity.getContent())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
