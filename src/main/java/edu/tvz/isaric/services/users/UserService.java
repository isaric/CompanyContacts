package edu.tvz.isaric.services.users;

import edu.tvz.isaric.entities.User;

public interface UserService
{
    User findByUid(String uid);

    void createDefaultAdmin();

    void updateProfile(User user);

    User getCurrentUser();
}
