package com.onlineschool.kursova.Repository;

import com.onlineschool.kursova.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userRepository extends CrudRepository<User, Integer>{
    @Override
    List<User> findAll();

    }
