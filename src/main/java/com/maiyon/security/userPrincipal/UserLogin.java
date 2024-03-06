package com.maiyon.security.userPrincipal;

import com.maiyon.model.entity.User;
import com.maiyon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLogin {
    private final UserService userService;
    public User userLogin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            UserPrincipal userPrinciple = (UserPrincipal) authentication.getPrincipal();
            return userService.findByUserId(userPrinciple.getUser().getUserId());
        }
        return null;
    }
}
