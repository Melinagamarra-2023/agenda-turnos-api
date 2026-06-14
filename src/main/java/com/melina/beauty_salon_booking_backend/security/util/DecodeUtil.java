package com.melina.beauty_salon_booking_backend.security.util;

import com.melina.beauty_salon_booking_backend.security.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DecodeUtil {

    public String extractCuit(String authorizationHeader) {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return user.getCuit();
    }

    public String extractEmail(String authorizationHeader) {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return user.getUsername();
    }
}
