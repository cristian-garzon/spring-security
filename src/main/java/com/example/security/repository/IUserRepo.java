package com.example.security.repository;


import com.example.security.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<user, Integer> {

    public user findByName(String name);
}
