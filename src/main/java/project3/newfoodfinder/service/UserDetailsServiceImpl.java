package project3.newfoodfinder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project3.newfoodfinder.entity.Member;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException{
        Member users = usersRepository.findByLoginId(loginId)
                .orElseThrow(()-> new IllegalArgumentException(loginId));
        return new UserDetailsImpl(users);
    }
}
