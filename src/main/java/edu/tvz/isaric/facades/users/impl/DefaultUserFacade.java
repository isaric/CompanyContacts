package edu.tvz.isaric.facades.users.impl;

import edu.tvz.isaric.entities.User;
import edu.tvz.isaric.facades.data.UserData;
import edu.tvz.isaric.facades.users.UserFacade;
import edu.tvz.isaric.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultUserFacade implements UserFacade
{
    private UserService userService;

    @Autowired
    public DefaultUserFacade(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public void updateProfile(UserData userData)
    {
        User user = userService.getCurrentUser();
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
    }
}
