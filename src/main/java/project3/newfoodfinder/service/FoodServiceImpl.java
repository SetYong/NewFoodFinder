package project3.newfoodfinder.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project3.newfoodfinder.dto.FoodBoardDTO;
import project3.newfoodfinder.dto.PageRequestDTO;
import project3.newfoodfinder.dto.PageResultDTO;
import project3.newfoodfinder.entity.FoodBoard;
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
        ArrayBuilders.BooleanBuilder booleanBuilder = getSearch(requestDTO);
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
        if(type.contains("w")){
            conditionBuilder.or(qFoodBoard.writer.contains(keyword));
        }
        booleanBuilder.and(conditionBuilder);
        return booleanBuilder;
    }
    public void write(FoodBoard foodBoard, MultipartFile file) throws Exception{
        String projechPath = System.getProperty("user.dir")
                + "\\src\\main\\resources\\static\\files";
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();
        File saveFile = new File(projechPath, fileName);
        file.transferTo(saveFile);
        foodBoard.setImage(fileName);
        foodBoard.setImagepath("/files/"+fileName);
        foodBoardRepository.save(foodBoard);
    }

    public List<FoodBoard> boardList(){
        return foodBoardRepository.findAll();
    }

    public FoodBoard foodBoardView(Long headnum){
        return foodBoardRepository.findById(headnum).get();
    }

    public void foodBoardDelete(Long headnum){
        foodBoardRepository.deleteById(headnum);
    }
}
