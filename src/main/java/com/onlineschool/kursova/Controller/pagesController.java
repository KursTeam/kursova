package com.onlineschool.kursova.Controller;

import com.onlineschool.kursova.Model.Roles;
import com.onlineschool.kursova.Model.Subject;
import com.onlineschool.kursova.Model.User;
//import com.onlineschool.kursova.Service.UserDaoImpl;
import com.onlineschool.kursova.Repository.SubjectRepository;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
@RequestMapping("/")
public class pagesController {
    @Autowired
    @Resource
    userRepository userService;
    @Autowired
    @Resource
    roleRepository roleRepository;
    @Autowired
    @Resource
    SubjectRepository subjectRepository;
    @GetMapping(value = "/")
    public String main(Model model) {
        List<Subject> allSub=(List<Subject>) subjectRepository.findAll();
        allSub=allSub.stream().filter(distinctByKey(Subject::getName)).collect(Collectors.toList());
        model.addAttribute("sub",allSub);
        model.addAttribute("show",allSub);
        return "index";
    }
    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    /*@GetMapping(value = "/admin")
    public String admin() {
//        Roles role=roleRepository.findByName("STUDENT");
//        userService.save(new User("Bob","12345",28,role));
//        userService.save(new User("Stas Kozuko","54321",27,role));
//        userService.save(new User("Andre","123",23,role));
//        userService.save(new User("Irina","321",31,role));

        return "admin";
    }
*/
    @GetMapping(value = "/user")
    public String user() {
        return "user";
    }
    @GetMapping(value = "/userSubjects")
    public String order() {
        return "UserSubjects";
    }
    @GetMapping(value = "/about")
    public String about() {
        return "about";
    }

    @GetMapping("/add")
    public String add(){
//        subjectRepository.save(new Subject("Java",new Date()));
//        subjectRepository.save(new Subject("History",new Date()));
//        subjectRepository.save(new Subject("Fishes",new Date()));

        return "add";
    }
    @GetMapping("/admin")
    public String adminindex(){
//        subjectRepository.save(new Subject("Java",new Date()));
//        subjectRepository.save(new Subject("History",new Date()));
//        subjectRepository.save(new Subject("Fishes",new Date()));

        return "adminindex";
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
