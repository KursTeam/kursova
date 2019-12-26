package com.onlineschool.kursova.Repository;

import com.onlineschool.kursova.Model.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
public interface roleRepository extends CrudRepository<Roles, Integer> {
    Roles findByName(String name);
    @Override
    List<Roles> findAll();
}
