package project3.newfoodfinder.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project3.newfoodfinder.dto.ListDTO;
import project3.newfoodfinder.dto.PageRequestDTO;
import project3.newfoodfinder.dto.PageResultDTO;
import project3.newfoodfinder.entity.QTestlist;
import project3.newfoodfinder.entity.Testlist;
import project3.newfoodfinder.repository.TestlistRepository;

import java.util.Optional;
import java.util.function.Function;


@Service
@Log4j2
@RequiredArgsConstructor
public class TestlistServiceImpl implements TestlistService{

    private final TestlistRepository repository;

    @Override
    public Long register(ListDTO dto){
        log.info("DTO------------------------------");
        log.info(dto);

        Testlist entity = dtoToEntity(dto);
        log.info(entity);
        repository.save(entity);

        return entity.getListno();
    }

    @Override
    public PageResultDTO<ListDTO, Testlist> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("listno").descending());
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<Testlist> result = repository.findAll(booleanBuilder, pageable);
        Function<Testlist, ListDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public ListDTO read(Long listno){
        Optional<Testlist> result = repository.findById(listno);
        return result.isPresent() ? entityToDto(result.get()) : null;
    }

    @Override
    public void remove(Long listno){
        repository.deleteById(listno);
    }

    @Override
    public void modify(ListDTO dto){
        Optional<Testlist> result = repository.findById(dto.getListno());
        if(result.isPresent()){
            Testlist entity = result.get();
            entity.changeTitle(dto.getTitle());
            entity.changeContent(dto.getContent());
            repository.save(entity);
        }
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO){
        String type = requestDTO.getType();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QTestlist qTestlist = QTestlist.testlist;
        String keyword = requestDTO.getKeyword();
        BooleanExpression expression = qTestlist.listno.gt(0L);
        booleanBuilder.and(expression);
        if(type == null || type.trim().length() == 0){
            return booleanBuilder;
        }
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if(type.contains("t")){
            conditionBuilder.or(qTestlist.title.contains(keyword));
        }
        if(type.contains("c")){
            conditionBuilder.or(qTestlist.content.contains(keyword));
        }
        if(type.contains("w")){
            conditionBuilder.or(qTestlist.writer.contains(keyword));
        }
        booleanBuilder.and(conditionBuilder);
        return booleanBuilder;
    }
}
