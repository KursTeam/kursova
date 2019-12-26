package com.onlineschool.kursova.config;

import com.onlineschool.kursova.Model.AuthenticationUserInfo;
import com.onlineschool.kursova.Repository.AuthenticationUserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthenticationUserInfoRepository authenticationUserInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AuthenticationUserInfo appUser = this.authenticationUserInfoRepository.findByName(userName);
//
        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
        System.out.println("Found User: " + appUser);

        Collection<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

                GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getRole());
        grantList.add(authority);
        authority = new SimpleGrantedAuthority("R");
        grantList.add(authority);

        UserDetails userDetails = new User( appUser.getName(),
                "{noop}"+appUser.getPassword(),true,true,true,true, grantList);

        return userDetails;
    }

}

