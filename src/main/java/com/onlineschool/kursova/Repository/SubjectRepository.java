package com.onlineschool.kursova.Repository;


import com.onlineschool.kursova.Model.Subject;
import com.onlineschool.kursova.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    List<Subject> findAllByName(String name);
        List<Subject>findAllByUser(User user);
    List<Subject> findAllByUserIsNotContaining(User user);
}
