package edu.tvz.isaric.services.users.details;

import edu.tvz.isaric.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsConverter
{
    public UserDetails convert(User user)
    {
        AccountUserDetails result = new AccountUserDetails();
        result.setPassword(user.getPasswordHash());
        result.setUid(user.getUid());
        result.setRole(user.getRole());
        return result;
    }
}
