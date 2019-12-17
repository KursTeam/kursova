package com.onlineschool.kursova.Service;

import com.onlineschool.kursova.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface UserDao {
    List<User> findAll();
    void insertUser(User user);
    void updateUser(User user);
    void executeUpdateUser(User user);
    public void deleteUser(User user);
}
