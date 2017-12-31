package edu.tvz.isaric.facades.converter;

import edu.tvz.isaric.entities.User;
import edu.tvz.isaric.facades.data.UserData;
import org.springframework.stereotype.Component;

@Component
public class UserConverter
{
    public UserData convert(User user)
    {
        UserData result = new UserData();
        convert(user, result);
        return result;
    }

    public void convert(User source, UserData target)
    {
        target.setUid(source.getUid());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setRole(source.getRole().toString());
    }
}
