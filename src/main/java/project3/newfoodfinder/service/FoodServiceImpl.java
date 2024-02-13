package project3.newfoodfinder.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project3.newfoodfinder.dto.FoodBoardDTO;
import project3.newfoodfinder.dto.PageRequestDTO;
import project3.newfoodfinder.dto.PageResultDTO;
import project3.newfoodfinder.entity.FoodBoard;
import project3.newfoodfinder.entity.QFoodBoard;
import project3.newfoodfinder.repository.FoodBoardRepository;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodBoardRepository foodBoardRepository;

    @Override
    public Long register(FoodBoardDTO dto) {
        log.info("DTO---------------------------------");
        log.info(dto);
        FoodBoard entity = dtoToEntity(dto);
        log.info(entity);
        foodBoardRepository.save(entity);
        return entity.getHeadnum();
    }

    @Override
    public PageResultDTO<FoodBoardDTO, FoodBoard> getList(PageRequestDTO requestDTO){
        Pageable pageable = requestDTO.getPageable(Sort.by("headnum").descending());
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<FoodBoard> result = foodBoardRepository.findAll(booleanBuilder, pageable);
        Function<FoodBoard, FoodBoardDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public FoodBoardDTO read(Long gno){
        Optional<FoodBoard> result = foodBoardRepository.findById(gno);
        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public void remove(Long gno){
        foodBoardRepository.deleteById(gno);
    }

    @Override
    public void modify(FoodBoardDTO dto){
        Optional<FoodBoard> result = foodBoardRepository.findById(dto.getHeadnum());
        if(result.isPresent()){
            FoodBoard entity = result.get();
            entity.changeTitle(dto.getTitle());
            entity.changeContent(dto.getContent());
            foodBoardRepository.save(entity);
        }
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        String type = requestDTO.getType();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QFoodBoard qFoodBoard = QFoodBoard.foodBoard;
        String keyword = requestDTO.getKeyword();
        BooleanExpression expression = qFoodBoard.headnum.gt(0L);
        booleanBuilder.and(expression);
        if(type == null || type.trim().length() == 0){
            return booleanBuilder;
        }
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if(type.contains("t")){
            conditionBuilder.or(qFoodBoard.title.contains(keyword));
        }
        if(type.contains("c")){
            conditionBuilder.or(qFoodBoard.content.contains(keyword));
        }

        booleanBuilder.and(conditionBuilder);
        return booleanBuilder;
    }

}
