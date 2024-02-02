package project3.newfoodfinder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date time = new Date();
    String localTime = format.format(time);

    private final MemberMapper memberMapper;

    @Transactional
    public void joinMember(Member member){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setMemberPwd(passwordEncoder.encode(member.getPassword()));
        member.setMGradeStr("ROLE_USER");
        memberMapper.save(member);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return null;
    }
}
