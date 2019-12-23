package com.onlineschool.kursova.Service;

import com.onlineschool.kursova.Model.Roles;
import com.onlineschool.kursova.Model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.List;

@Repository
@Service
public class RoleDaoImpl implements RoleDao {
    public RoleDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;
    @Override
    public List<Roles> findAll() {
        List<Roles> roles= new ArrayList<>();
       roles=template.query("select * from roles", new RoleRowMapper());
        return roles;
    }

    @Override
    public void insertRole(Roles role) {

    }

    @Override
    public void updateRole(Roles role) {

    }

    @Override
    public void executeUpdateRole(Roles role) {

    }

    @Override
    public void deleteRole(Roles role) {

    }
}
