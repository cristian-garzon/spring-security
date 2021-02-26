package com.example.security.services;


import com.example.security.model.user;

import java.util.List;

public interface IUserService {

    public List<user> list();
    public boolean addUser(user user);
    public boolean updateUser(user user);
    public boolean delete(int id);

}
