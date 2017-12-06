package edu.tvz.isaric.repositories;

import edu.tvz.isaric.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>
{
    User findByUid(String uid);
}
