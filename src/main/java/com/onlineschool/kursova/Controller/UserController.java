package com.onlineschool.kursova.Controller;
import javax.annotation.Resource;

import com.onlineschool.kursova.Model.User;
import com.onlineschool.kursova.Service.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/admin")
public class UserController {
    public List<User> users;
    @Autowired
    @Resource
    UserDaoImpl employeeService;
    @RequestMapping(value = "/Users", method= RequestMethod.GET)
    public List<User> getEmployees(Model model) {

        users=employeeService.findAll();
        model.addAttribute("usersGet",users);

        return users;
    }
    @PostMapping(value = "/createUs")
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
    }
}
