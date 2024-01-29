package project3.newfoodfinder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project3.newfoodfinder.dto.ListDTO;
import project3.newfoodfinder.dto.PageRequestDTO;
import project3.newfoodfinder.dto.PageResultDTO;
import project3.newfoodfinder.entity.Testlist;
import project3.newfoodfinder.repository.TestlistRepository;

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
        Page<Testlist> result = repository.findAll(pageable);
        Function<Testlist, ListDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn);
    }
}
