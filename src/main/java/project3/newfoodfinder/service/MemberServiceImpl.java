package project3.newfoodfinder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import project3.newfoodfinder.dto.MemberDTO;
import project3.newfoodfinder.repository.MemberRepository;

import javax.inject.Inject;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl {

    private final MemberRepository repository;





}
