package com.wlj.tutorialspoint;

import com.wlj.domain.Student;
import com.wlj.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WuLei
 */
@Controller//负责注册一个bean 到spring 上下文中


public class HelloController {
    @RequestMapping("/hello")
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return null;
    }

    @RequestMapping("/test")
    public String one(Model model) {
        Long date = System.currentTimeMillis();
        model.addAttribute("date", date);
        return "index";
    }

    @RequestMapping("/test2")
    public String two(Model model) {
        Long date = System.currentTimeMillis();
        model.addAttribute("date", date);
        return "t11";
    }

    @Resource
    private StudentService studentService;

    private Integer learning;
    private Integer working;
    private Integer java;
    private Integer web;
    private Integer mobile;

    @RequestMapping(value = "/t10", method = RequestMethod.GET)
    public String One(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        learning = studentService.getLearning();
        model.addAttribute("learnings", learning);
        working = studentService.getWorking();
        model.addAttribute("workings", working);
        Long date = System.currentTimeMillis();
        model.addAttribute("date", date);
        return "10";
    }

    @RequestMapping(value = "/t11", method = RequestMethod.GET)
    public String Two(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        java = studentService.getJava();
        model.addAttribute("javas", java);
        web = studentService.getWeb();
        model.addAttribute("webs", web);
        mobile = studentService.getMobile();
        model.addAttribute("mobiles", mobile);
        Long date = System.currentTimeMillis();
        model.addAttribute("date", date);
        return "11";
    }
}