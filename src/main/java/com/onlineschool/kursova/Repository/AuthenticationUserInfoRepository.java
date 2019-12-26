package com.onlineschool.kursova.Repository;

import com.onlineschool.kursova.Model.AuthenticationUserInfo;
import org.springframework.data.repository.CrudRepository;

public interface AuthenticationUserInfoRepository extends CrudRepository<AuthenticationUserInfo, Integer> {
    AuthenticationUserInfo findByName(String name);
}
