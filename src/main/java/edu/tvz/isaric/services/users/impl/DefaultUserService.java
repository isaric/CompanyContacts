package edu.tvz.isaric.services.users.impl;

import edu.tvz.isaric.entities.*;
import edu.tvz.isaric.repositories.CompanyRepository;
import edu.tvz.isaric.repositories.UserRepository;
import edu.tvz.isaric.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultUserService implements UserService
{
    private UserRepository userRepository;

    private CompanyRepository companyRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository, CompanyRepository companyRepository)
    {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
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
        admin.setFirstName("admin");
        userRepository.save(admin);
    }

    @Override
    public void updateProfile(User user)
    {
        userRepository.save(user);
    }

    @Override
    public User getCurrentUser()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return findByUid(auth.getName());
    }


}
