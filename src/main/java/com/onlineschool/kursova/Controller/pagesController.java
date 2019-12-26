package com.onlineschool.kursova.Controller;

import com.onlineschool.kursova.Model.Roles;
import com.onlineschool.kursova.Model.User;
//import com.onlineschool.kursova.Service.UserDaoImpl;
import com.onlineschool.kursova.Repository.roleRepository;
import com.onlineschool.kursova.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Stream;


@Controller
@RequestMapping("/")
public class pagesController {
    @Autowired
    @Resource
    userRepository userService;
    @Autowired
    roleRepository roleRepository;
    @GetMapping(value = "/")
    public String main() {
        return "index";
    }
    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
//        Roles role=roleRepository.findByName("STUDENT");
//        userService.save(new User("Bob","12345",28,role));
//        userService.save(new User("Stas Kozuko","54321",27,role));
//        userService.save(new User("Andre","123",23,role));
//        userService.save(new User("Irina","321",31,role));

        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }
    @GetMapping("/order")
    public String order() {
        return "UserSubjects";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
