package project3.newfoodfinder.service;

import project3.newfoodfinder.dto.ListDTO;
import project3.newfoodfinder.dto.PageRequestDTO;
import project3.newfoodfinder.dto.PageResultDTO;
import project3.newfoodfinder.entity.Testlist;

public interface TestlistService {
    Long register(ListDTO dto);

    PageResultDTO<ListDTO, Testlist> getList(PageRequestDTO requestDTO);

    default Testlist dtoToEntity(ListDTO dto) {
        Testlist entity = Testlist.builder()
                .listno(dto.getListno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default ListDTO entityToDto(Testlist entity){
        ListDTO dto = ListDTO.builder()
                .listno(entity.getListno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
