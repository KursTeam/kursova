package com.onlineschool.kursova.Controller;
import javax.annotation.Resource;

import com.onlineschool.kursova.Model.AuthenticationUserInfo;
import com.onlineschool.kursova.Model.Roles;
import com.onlineschool.kursova.Model.User;
import com.onlineschool.kursova.Repository.AuthenticationUserInfoRepository;
import com.onlineschool.kursova.Repository.roleRepository;
import com.onlineschool.kursova.Repository.userRepository;
import com.onlineschool.kursova.Service.RoleDaoImpl;
//import com.onlineschool.kursova.Service.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Controller

public class UserController {
    public List<User> users;
    public List<Roles> roles;
    @Autowired
    AuthenticationUserInfoRepository userInfoRepository;
    @Autowired
    userRepository userRepository;
    @Autowired
    roleRepository roleRepository;
    @Autowired
    @Resource
    userRepository employeeService;
    @Autowired
    @Resource
    roleRepository roleService;
   // @Autowired
   // @Resource
    RoleDaoImpl rolesService;
    @GetMapping("/reg")
    public String registration(Model model){
        model.addAttribute("user",new User());
        return "reg";
    }
    @PostMapping("/reg")
    public String saveNewUser(@ModelAttribute User newUser,  Model model){
        model.addAttribute("user",newUser);
        if(userInfoRepository.findByName(newUser.getUser_name())!=null)return "failed";
        Roles roles=roleRepository.findByName("STUDENT");
        newUser.setRoles(roles);
        AuthenticationUserInfo newUserInfo=new AuthenticationUserInfo();
        newUserInfo.setName(newUser.getUser_name());
        newUserInfo.setPassword(newUser.getPassword());
        newUserInfo.setRole(newUser.getRoles().getName());
        userRepository.save(newUser);
        userInfoRepository.save(newUserInfo);
        return "success";
    }

    @GetMapping(value = "/admin/Users")
    public String Users(Model model) {

        List<AuthenticationUserInfo> user=(List<AuthenticationUserInfo>) userInfoRepository.findAll();
        for (AuthenticationUserInfo usr:user)
        {
         System.out.println(usr.toString());
        }
        List<User>selectedusers;
        model.addAttribute("users",user);

     //   model.addAttribute("roles",roles);
        return "Users";
    }
    @GetMapping(value = "/admin/createUs")
    public String getcreateEmployee( User usr,Model model) {
        users=employeeService.findAll();
       // roles=rolesService.findAll();
        usr=new User();
       model.addAttribute("usr",usr);

      return "createUs";
  }
    @PostMapping(value = "/admin/createUs")
    public String postcreateEmployee(Model model,@ModelAttribute User usr) {
        roles=roleService.findAll();
        if(users.size()!=0) {
            User user1 = users.stream()
                    .max(Comparator.comparingInt(User::getUser_id))
                    .get();
            usr.setUser_id(user1.getUser_id() + 1);
        }
        else usr.setUser_id(1);
            for (Roles r:roles) {if(r.name=="USER")usr.setRole(r.name,r.role_id);usr.roles=r;}
        System.out.println(usr.getUser_id()+" "+usr.getUser_name()+" "+usr.getPassword());
        users.add(usr);

        employeeService.save(usr);

        model.addAttribute("usr",usr);
        return "Users";
    }

    @GetMapping(value = "/admin/updateUs")
    public String editUser(User usr, Model model) {
        Optional<User> user1 = users.stream().filter(x->x.getUser_id()==14).findFirst();


            System.out.println(user1.get().getUser_id()+" "+user1.get().getUser_name()+" "+user1.get().getAge()+" "+user1.get().getRoles().name);

        // roles=rolesService.findAll();

        model.addAttribute("usr",user1);

        return "updateUs";
    }
    /*
    @PutMapping(value = "/executeUpdateUs")
    public void executeUpdateEmployee(@RequestBody User emp) {
        employeeService.executeUpdateUser(emp);
    }
    @DeleteMapping(value = "/deleteUsById")
    public void deleteEmployee(@RequestBody User emp) {
        employeeService.deleteUser(emp);
    }*/
}
