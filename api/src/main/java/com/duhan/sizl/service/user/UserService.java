package com.duhan.sizl.service.user;

import com.duhan.sizl.domain.user.User;
import com.duhan.sizl.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@RequiredArgsConstructor
@Service
public class UserService {
    public final UserRepository userRepository;
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
}
