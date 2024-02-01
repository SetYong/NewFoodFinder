package project3.newfoodfinder.service;

import project3.newfoodfinder.dto.MemberDTO;
import project3.newfoodfinder.entity.Member;
import project3.newfoodfinder.repository.MemberRepository;

import java.util.Optional;

public interface MemberService {
    Long register(MemberDTO dto);

    default Member dtoToEntity(MemberDTO dto){
        Member entity = Member.builder()
                .name(dto.getName())
                .userid(dto.getUserid())
                .password(dto.getPassword())
                .mail(dto.getMail1()+"@"+dto.getMail2())
                .nickname(dto.getNickname())
                .phone(dto.getPhone1()+"-"+dto.getPhone2()+"-"+dto.getPhone3())
                .ssn(dto.getSsn1()+"-"+dto.getSsn2())
                .build();
        return entity;
    }

    default MemberDTO entityToDto(Member entity){
        MemberDTO dto = MemberDTO.builder()
                .mbnum(entity.getMbnum())
                .name(entity.getName())
                .mail(entity.getMail())
                .nickname(entity.getNickname())
                .phone(entity.getPhone())
                .build();
        return dto;
    }

}
