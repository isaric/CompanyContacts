package edu.tvz.isaric.facades.authentication.impl;

import edu.tvz.isaric.entities.User;
import edu.tvz.isaric.facades.authentication.AuthenticationFacade;
import edu.tvz.isaric.facades.converter.UserConverter;
import edu.tvz.isaric.facades.data.UserData;
import edu.tvz.isaric.forms.LoginForm;
import edu.tvz.isaric.services.users.UserService;
import edu.tvz.isaric.services.users.details.UserDetailsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Component
public class DefaultAuthenticationFacade implements AuthenticationFacade
{
    private UserConverter userConverter;

    private UserDetailsConverter userDetailsConverter;

    private AuthenticationManager authenticationManager;

    private UserService userService;

    @Autowired
    public DefaultAuthenticationFacade(
            UserConverter userConverter,
            UserDetailsConverter userDetailsConverter,
            AuthenticationManager authenticationManager, UserService userService)
    {
        this.userConverter = userConverter;
        this.userDetailsConverter = userDetailsConverter;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @Override
    public UserData authenticate(LoginForm login)
    {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                login.getUid(),
                login.getPassword()
        );
        User attemptToLogin = new User();
        attemptToLogin.setUid(login.getUid());
        UserDetails details = userDetailsConverter.convert(attemptToLogin);
        token.setDetails(details);
        try
        {
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user = userService.findByUid(login.getUid());
            UserData currentUserData = userConverter.convert(user);
            currentUserData.setSessionId(RequestContextHolder.currentRequestAttributes().getSessionId());
            return currentUserData;
        }
        catch (Exception ex)
        {
            return new UserData();
        }
    }

    @Override
    public UserData logout(HttpServletRequest request)
    {
        UserData anonymous = new UserData();
        anonymous.setFirstName("anonymous");
        anonymous.setRole("ANONYMOUS");
        try
        {
            request.logout();
            SecurityContextHolder.clearContext();

        }
        catch (ServletException e)
        {
            e.printStackTrace();
        }
        return anonymous;
    }
}
