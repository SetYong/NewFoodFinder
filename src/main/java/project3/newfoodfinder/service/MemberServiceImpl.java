package project3.newfoodfinder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import project3.newfoodfinder.dto.MemberDTO;
import project3.newfoodfinder.entity.Member;
import project3.newfoodfinder.repository.MemberRepository;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;

    @Override
    public Long register(MemberDTO dto){
        log.info("DTO----------------------------");
        log.info(dto);

        Member entity = dtoToEntity(dto);
        log.info(entity);

        repository.save(entity);
        return entity.getMbnum();
    }

//    @Override
//    public boolean login(MemberDTO dto){
//        log.info("login dto----------------------");
//        log.info(dto);
//        boolean pass = true;
//        return pass;
//    }
}
