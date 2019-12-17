package com.onlineschool.kursova.Service;

import com.onlineschool.kursova.Model.User;
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

@Repository
@Service
public class UserDaoImpl implements UserDao {


        public UserDaoImpl(NamedParameterJdbcTemplate template) {
            this.template = template;
        }
        NamedParameterJdbcTemplate template;
        @Override
        public List<User> findAll() {
            List<User> users=new ArrayList<User>();
            users=template.query("select * from users", new UserRowMapper());
            for (User i:users
                 ) {
                System.out.println(i.user_name);
            }
            return users;
        }
        @Override
        public void insertUser(User emp) {
            final String sql = "insert into users(user_id, user_name, role_id, age, password) values(:user_id,:user_name,:role_id,:age,:password)";
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("user_id", emp.getUser_id())
                    .addValue("user_name", emp.getUser_name())

                    .addValue("role_id", emp.getRole_id())
                    .addValue("Age", emp.getAge())
                    .addValue("password", emp.getPassword());
            template.update(sql,param, holder);
        }
        @Override
        public void updateUser(User emp) {
            final String sql = "update users set user_name=:user_name, role_id=:role_id, age=:age,password=:password where user_id=:user_id";
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("user_id", emp.getUser_id())
                    .addValue("user_name", emp.getUser_name())
                    .addValue("password", emp.getPassword())
                    .addValue("role_id", emp.getRole_id())
                    .addValue("Age", emp.getAge());
            template.update(sql,param, holder);
        }
        @Override
        public void executeUpdateUser(User emp) {
            final String sql = "update users set user_name=:user_name, role_id=:role_id, age=:age,password=:password where user_id=:user_id";
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("user_id", emp.getUser_id());
            map.put("user_name", emp.getUser_name());
            map.put("password", emp.getPassword());
            map.put("role_id", emp.getRole_id());

            map.put("Age", emp.getAge());
            template.execute(sql,map,new PreparedStatementCallback<Object>() {
                @Override
                public Object doInPreparedStatement(PreparedStatement ps)
                        throws SQLException, DataAccessException {
                    return ps.executeUpdate();
                }
            });
        }
        @Override
        public void deleteUser(User emp) {
            final String sql = "delete from public.users where user_id=:user_id";
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("user_id", emp.getUser_id());
            template.execute(sql,map,new PreparedStatementCallback<Object>() {
                @Override
                public Object doInPreparedStatement(PreparedStatement ps)
                        throws SQLException, DataAccessException {
                    return ps.executeUpdate();
                }
            });
        }
}
