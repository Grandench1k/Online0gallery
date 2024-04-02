package com.online.gallery.service.auth;

import com.online.gallery.dto.request.SignInRequest;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.online.gallery.dto.request.SignUpRequest;
import com.online.gallery.dto.request.SignInRequest;
import com.online.gallery.dto.response.AuthTokenResponse;
import com.online.gallery.exception.user.UserDuplicationException;

import java.io.IOException;

public interface AuthenticationService {
    AuthTokenResponse processSignUp(SignUpRequest request) throws UserDuplicationException, MessagingException;

    AuthTokenResponse authenticate(SignInRequest request) throws UsernameNotFoundException;

    String completeSignUp(String token);

    String sendMessageForReset(String token) throws MessagingException;

    String checkPasswordResetTokenAndUser(String token);

    String resetPassword(String token, String newPassword);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
