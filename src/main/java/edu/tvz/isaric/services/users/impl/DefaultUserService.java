package edu.tvz.isaric.services.users.impl;

import edu.tvz.isaric.entities.Admin;
import edu.tvz.isaric.entities.User;
import edu.tvz.isaric.repositories.UserRepository;
import edu.tvz.isaric.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService
{
    private UserRepository userRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUid(String uid)
    {
        return userRepository.findByUid(uid);
    }

    @Override
    public void createDefaultAdmin()
    {
        Admin admin = new Admin();
        admin.setUid("admin");
        admin.setPasswordHash(new BCryptPasswordEncoder().encode("admin"));
        userRepository.save(admin);
    }
}
