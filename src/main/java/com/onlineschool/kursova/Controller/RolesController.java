package com.onlineschool.kursova.Controller;

import com.onlineschool.kursova.Model.Roles;
import com.onlineschool.kursova.Model.User;
import com.onlineschool.kursova.Service.RoleDaoImpl;
//import com.onlineschool.kursova.Service.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller

public class RolesController {
    public List<User> users;
    public List<Roles> roles;
    @Autowired
    @Resource
   // UserDaoImpl employeeService;
    RoleDaoImpl rolesService;
    @RequestMapping(value = "/roles", method= RequestMethod.GET)
    public String roles(Model model) {

        roles=rolesService.findAll();
        // roles=rolesService.findAll();
        List<User>selectedusers;


        model.addAttribute("roles",roles);
        // model.addAttribute("roles",roles);
        return "roles";
    }

    @PostMapping(value = "/admin/createrole")
    public void createrole(@RequestBody Roles emp) {
        rolesService.insertRole(emp);
    }
    @PutMapping(value = "/admin/updaterole")
    public void updaterole(@RequestBody Roles emp) {
        rolesService.updateRole(emp);
    }
    @PutMapping(value = "/admin/executeuprole")
    public void executeuprole(@RequestBody Roles emp) { rolesService.executeUpdateRole(emp);
    }
    @DeleteMapping(value = "/admin/deleterole")
    public void deleterole(@RequestBody Roles emp) {
        rolesService.deleteRole(emp);
    }
}
