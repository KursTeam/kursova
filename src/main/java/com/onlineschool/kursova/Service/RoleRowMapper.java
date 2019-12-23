package com.onlineschool.kursova.Service;

import com.onlineschool.kursova.Model.Roles;
import org.springframework.jdbc.core.RowMapper;

import javax.management.relation.Role;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Roles> {
@Override
public Roles mapRow(ResultSet rs, int arg1) throws SQLException {
        Roles emp = new Roles();
        emp.setRole_id(rs.getInt("role_id"));
       emp.setName(rs.getString("role_name"));

        return emp;
        }

        }


