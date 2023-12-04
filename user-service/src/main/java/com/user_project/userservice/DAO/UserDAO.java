package com.user_project.userservice.DAO;

import com.user_project.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String> {

    /*@Procedure("my_services.getEmailOfUserByID")
    String getEmail(@Param("id") Integer id);*/

}

