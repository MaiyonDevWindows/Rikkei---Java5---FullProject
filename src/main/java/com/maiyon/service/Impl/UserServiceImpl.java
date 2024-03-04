package com.maiyon.service.Impl;

import com.maiyon.model.entity.User;
import com.maiyon.model.enums.ActiveStatus;
import com.maiyon.repository.UserRepository;
import com.maiyon.service.RoleService;
import com.maiyon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    @Override
    public User findByUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public void changeUserStatus(Long userId) {
        User user = findByUserId(userId);
        if(user.getActiveStatus() == ActiveStatus.ACTIVE)
            user.setActiveStatus(ActiveStatus.INACTIVE);
        else user.setActiveStatus(ActiveStatus.ACTIVE);
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void register(User user) {

    }
}
