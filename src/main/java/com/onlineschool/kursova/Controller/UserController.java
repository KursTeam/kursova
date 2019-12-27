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
    List<AuthenticationUserInfo> user;
    @Autowired
    AuthenticationUserInfoRepository userInfoRepository;
    @Autowired
    @Resource
    userRepository userRepository;
    @Autowired
    roleRepository roleRepository;
    @Autowired
    @Resource
    userRepository employeeService;
    @Autowired
    @Resource
    roleRepository roleService;
    @Autowired
    @Resource
    RoleDaoImpl rolesService;
    @GetMapping(value = "/reg")
    public String registration(Model model){
        model.addAttribute("user",new User());
        return "reg";
    }
    @PostMapping(value="/reg")
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
        users=employeeService.findAll();
        user=(List<AuthenticationUserInfo>) userInfoRepository.findAll();
        for (AuthenticationUserInfo usr:user)
        {
         System.out.println(usr.toString());
        }
        List<User>selectedusers;
        model.addAttribute("users",user);

     //   model.addAttribute("roles",roles);
        return "Users";
    }
    @GetMapping("/admin/createUs")
    public String getcreateEmployee(Model model) {
        users=employeeService.findAll();
        roles=rolesService.findAll();
      AuthenticationUserInfo  usr=new AuthenticationUserInfo();
       model.addAttribute("usr",usr);

      return "createUs";
  }
    @PostMapping(value = "/admin/createUs")
    public String postcreateEmployee(Model model,@ModelAttribute AuthenticationUserInfo usr) {
        roles=roleService.findAll();
        /*
        if(user.size()!=0) {
            AuthenticationUserInfo user1 = user.stream()
                    .max(Comparator.comparingInt(AuthenticationUserInfo::getUser_id))
                    .get();
            usr.setUser_id(user1.getUser_id() + 1);
        }
        else usr.setUser_id(1);*/
            usr.setRole("STUDENT");
            User u=new User();
            u.setUser_id(usr.getUser_id());
            u.setAge(usr.getAge());
            u.setUser_name(usr.getName());
           // u.roles.name="STUDENT";
            u.setPassword(usr.getPassword());
        System.out.println(usr.getUser_id()+" "+usr.getName()+" "+usr.getPassword());
        user.add(usr);
        users.add(u);
        userInfoRepository.save(usr);
        employeeService.save(u);
        model.addAttribute("usr",usr);
        return "Users";
    }

    @GetMapping(value = "/admin/updateUs/{user_id}")
    public String editUser(@PathVariable int user_id, Model model) {
        Optional<AuthenticationUserInfo> user1 = user.stream().filter(x->x.getUser_id()==user_id).findFirst();
       // AuthenticationUserInfo user12=userInfoRepository.

          //  System.out.println(user1.get().getUser_id()+" "+user1.get().getName()+ " "+user1.get().getRole());

        // roles=rolesService.findAll();

        model.addAttribute("usr",user1);

        return "updateUs";
    }
    @GetMapping(value = "/admin/deleteUs/{user_id}")
    public String deleteUs(@PathVariable int user_id, Model model) {
        //<AuthenticationUserInfo> user1 = user.stream().filter(x->x.getUser_id()==user_id).findFirst();
        // AuthenticationUserInfo user12=userInfoRepository.
       userInfoRepository.deleteById(user_id);

        //  System.out.println(user1.get().getUser_id()+" "+user1.get().getName()+ " "+user1.get().getRole());

        // roles=rolesService.findAll();

       // model.addAttribute("usr",user1);

        return "Users";
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
