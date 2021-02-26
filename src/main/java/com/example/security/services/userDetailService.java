package com.example.security.services;

import com.example.security.model.user;
import com.example.security.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userDetailService implements UserDetailsService {

    @Autowired
    private IUserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        user user = repo.findByName(s);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails details = new User(user.getName(), user.getPassword(), roles);
        return  details;
    }
}
