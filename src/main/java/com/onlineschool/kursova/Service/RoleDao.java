package com.onlineschool.kursova.Service;

import com.onlineschool.kursova.Model.Roles;
import com.onlineschool.kursova.Model.User;

import java.util.List;

public interface RoleDao {
    List<Roles> findAll();
    void insertRole(Roles role);
    void updateRole(Roles role);
    void executeUpdateRole(Roles role);
    public void deleteRole(Roles role);
}
