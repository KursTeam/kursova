package com.onlineschool.kursova.Controller;
import javax.annotation.Resource;

import com.onlineschool.kursova.Model.Roles;
import com.onlineschool.kursova.Model.User;
import com.onlineschool.kursova.Repository.userRepository;
import com.onlineschool.kursova.Service.RoleDaoImpl;
//import com.onlineschool.kursova.Service.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Controller

public class UserController {
    public List<User> users;
    public List<Roles> roles;
    @Autowired
    @Resource
    userRepository employeeService;
   // @Autowired
   // @Resource
  //  RoleDaoImpl rolesService;
    @RequestMapping(value = "/Users", method= RequestMethod.GET)
    public String Users(Model model) {

        users=employeeService.findAll();
     //   roles=rolesService.findAll();
        for (User usr:users)
        {
         System.out.println(usr.getUser_id()+" "+usr.getUser_name()+" "+usr.getAge()+" "+usr.getRoles().Name);
        }
        List<User>selectedusers;


        model.addAttribute("users",users);

     //   model.addAttribute("roles",roles);
        return "Users";
    }

   /* @PostMapping(value = "/createUs")
    public void createEmployee(@RequestBody User emp) {
        employeeService.insertUser(emp);
    }
    @PutMapping(value = "/updateUs")
    public void updateEmployee(@RequestBody User emp) {
        employeeService.updateUser(emp);
    }
    @PutMapping(value = "/executeUpdateUs")
    public void executeUpdateEmployee(@RequestBody User emp) {
        employeeService.executeUpdateUser(emp);
    }
    @DeleteMapping(value = "/deleteUsById")
    public void deleteEmployee(@RequestBody User emp) {
        employeeService.deleteUser(emp);
    }*/
}
