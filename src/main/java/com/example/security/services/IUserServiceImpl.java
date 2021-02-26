package com.example.security.services;

import com.example.security.model.user;
import com.example.security.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService{

    @Autowired
    private IUserRepo userRepo;


    @Override
    public List<user> list() {
        return userRepo.findAll();
    }

    @Override
    public boolean addUser(user user) {
        if(!userRepo.existsById(user.getIdUser())){
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(user user){
        if(userRepo.existsById(user.getIdUser())){
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
