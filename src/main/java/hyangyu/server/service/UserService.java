package hyangyu.server.service;

import java.util.Collections;
import java.util.Optional;
import hyangyu.server.dto.UserDto;
import hyangyu.server.domain.Authority;
import hyangyu.server.domain.User;
import hyangyu.server.jwt.DuplicateMemberException;
import hyangyu.server.repository.UserRepository;
import hyangyu.server.jwt.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserDto signup(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();
        
        User user = User.builder()
        		.email(userDto.getEmail())
                .username(userDto.getUsername())
                .sub(userDto.getSub())
                .token(userDto.getToken())
                .image(userDto.getImage())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .authorities(Collections.singleton(authority))
                .build();

        return UserDto.from(userRepository.save(user));
    }
    
    public void modify(UserDto userDto) {
    	User user = userRepository.findByEmail(userDto.getEmail()).orElseThrow(()-> 
    		new IllegalArgumentException("해당 회원이 없습니다. id="+userDto.getEmail()));
    	
    	String encPassword =passwordEncoder.encode(userDto.getPassword());
    	user.modify(userDto.getUsername(), encPassword);
    }

    @Transactional(readOnly = true)
    public UserDto getUserWithAuthorities(String email) {
        return UserDto.from(userRepository.findByEmail(email).orElse(null));
    }

    @Transactional(readOnly = true)
    public UserDto getMyUserWithAuthorities() {
        return UserDto.from(SecurityUtil.getCurrentEmail().flatMap(userRepository::findByEmail).orElse(null));
    }
}
