package edu.tvz.isaric.services.users.impl;

import edu.tvz.isaric.entities.User;
import edu.tvz.isaric.services.users.UserService;
import edu.tvz.isaric.services.users.details.UserDetailsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountUserDetailsService implements UserDetailsService
{
    private UserService userService;

    private UserDetailsConverter userDetailsConverter;

    @Autowired
    public AccountUserDetailsService(
            UserService userService,
            UserDetailsConverter userDetailsConverter)
    {
        this.userService = userService;
        this.userDetailsConverter = userDetailsConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException
    {
        User user = userService.findByUid(uid);
        return userDetailsConverter.convert(user);
    }
}
