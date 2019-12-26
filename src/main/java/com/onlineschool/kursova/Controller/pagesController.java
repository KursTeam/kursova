package com.onlineschool.kursova.Controller;

import com.onlineschool.kursova.Model.User;
//import com.onlineschool.kursova.Service.UserDaoImpl;
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

    @GetMapping("/login")
    public String login() {
         return "login";
    }
    @GetMapping("/adminindex")
    public String adminindex() {
        return "adminindex";
    }
    @PostMapping("/login")
    public String login(Model model) {
        return "index";
    }
 /*   @PostMapping("/login")
            public  String login(@ModelAttribute User user,Model model)
    {
        user.user_id=0;
        List<User> users=userService.findAll();
        for (User us:users
             ) {
            if(us.user_name==user.user_name)   return "index";
        }
         {
            return "login";
        }
    }*/
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
