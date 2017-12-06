package edu.tvz.isaric.controllers;

import edu.tvz.isaric.entities.User;
import edu.tvz.isaric.forms.LoginForm;
import edu.tvz.isaric.services.users.UserService;
import edu.tvz.isaric.services.users.details.UserDetailsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController
{
    private UserDetailsConverter userDetailsConverter;

    private AuthenticationManager authenticationManager;

    private UserService userService;

    @Autowired
    public AuthenticationController(
            UserDetailsConverter userDetailsConverter,
            @Qualifier("authenticationManager")
                    AuthenticationManager authenticationManager,
            UserService userService)
    {
        this.userDetailsConverter = userDetailsConverter;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser()
    {
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return userService.findByUid(details.getUsername());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User doLogin(
            @RequestBody
                    LoginForm login)
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
            return userService.findByUid(login.getUid());
        }
        catch (BadCredentialsException ex)
        {
            return new User();
        }

    }
}
