package com.wlj.tutorialspoint;

import com.wlj.DES.DesUtil;
import com.wlj.DES.Md5Util;
import com.wlj.domain.Student;
import com.wlj.domain.User;
import com.wlj.service.StudentService;
import com.wlj.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.security.provider.MD5;
import sun.security.util.Password;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.*;

/**
 * @author WuLei
 */
@Controller//负责注册一个bean 到spring 上下文中


public class HelloController {
    // private Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String printHello() {
        System.out.println("hello");
        return null;
    }


    @RequestMapping("/m")
    public String a() {
        System.out.println("进入方法了");
        return "m";
    }

    @RequestMapping("/m/m")
    public String ac() {
        System.out.println("进入方法了");
        return "m";
    }


    @RequestMapping("/t12")
    public String one(Model model) {
        Long date = System.currentTimeMillis();
        model.addAttribute("date", date);
        return "12";
    }

    @RequestMapping("/t13")
    public String two(Model model) {
        Long date = System.currentTimeMillis();
        model.addAttribute("date", date);
        return "13";
    }

    @Resource
    private StudentService studentService;
    @Resource
    private UserService userService;

    private Integer learning;
    private Integer working;
    private Integer java;
    private Integer web;
    private Integer mobile;

    @RequestMapping(value = "t10", method = RequestMethod.GET)
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

    @RequestMapping(value = "/u/t11", method = RequestMethod.GET)
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

        /*//获取cookie
        Cookie[] cookie = request.getCookies();
        System.out.println("cookie:" + cookie);
        System.out.println("时间：" + new Date());
        if (cookie != null) {
            for (int i = 0; i < cookie.length; i++) {
                //遍历每一个cookie，看看是否有一个cookie的name等于“Token”
                if (cookie[i].getName().equals("Token")) {
                    //把这个Token的值取出来
                    String token = cookie[i].getValue();
                    System.out.println("Token:" + token);
                    //解密这个Token的值
                    String tDecrypt = new DesUtil("wlj").decrypt(token);
                    System.out.println("tDecrypt:" + tDecrypt);
                    //解密后的值用，分开
                    String[] arrToken = tDecrypt.split(",");
                    for (String s : arrToken) {
                        System.out.println(s);
                    }
                }
            }
        }*/

        return "11";
    }

    /**
     * @Author Wuleijian
     * @Date 2018/3/2 13:02
     * @Description task5
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String Three() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String Four(User user, Model model) {

        Long date = System.currentTimeMillis();
        model.addAttribute("date", date);
        User username = userService.selectUserByName(user.getName());
        if (username != null)
            return "12";
        else {
            //利用UUID生成salt
            user.setSalt(UUID.randomUUID().toString().substring(0, 5));
            //MD5加密
            user.setPassword(Md5Util.getMd5(user.getPassword()));
            System.out.println("MD5加密后的密码：" + user.getPassword());
            // MD5加盐
            user.setPassword(Md5Util.getMd5(user.getPassword() + user.getSalt()));
            System.out.println("MD5加密后再加盐的密码 + 盐：" + "\n" + user.getPassword() + "\n" + user.getSalt());
            userService.insert(user);
            return "13";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Five() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Six(Model model, User user, HttpServletResponse response) {
        //获得登录时间，存到数据库里
        Long date = System.currentTimeMillis();
        model.addAttribute("date", date);
        user.setTime(date);
        userService.updateTime(user.getName(), user.getTime());
        //对用户名和登录时间加密，放到Token里
        String s = user.getName() + "," + date;
        System.out.println("s:" + s);
        String Token = null;
        String Token2;
        try {
            //测试一下两个加密方法的区别
            Token = new DesUtil("wlj").encrypt(s);
            Token2 = new DesUtil().encrypt(s);
            System.out.println("Token+Token2:" + "\n" + Token + "\n" + Token2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Token存入cookie
        Cookie cookie = new Cookie("Token", Token);
        //cookie有效时间（秒）
        cookie.setMaxAge(60 * 60);
        // 可在同一应用服务器内共享方法
        cookie.setPath("/");
        //添加cookie到服务器端
        response.addCookie(cookie);
        //登录信息加密后与数据库比较
        user.setPassword(Md5Util.getMd5(user.getPassword()));
        System.out.println("MD5加密后的密码：" + user.getPassword());

        User user2 = userService.selectUserByName(user.getName());
        user.setPassword(Md5Util.getMd5(user.getPassword() + user2.getSalt()));
        System.out.println("MD5加密后再加盐的密码 + 盐：" + "\n" + user.getPassword() + "\n" + user2.getSalt());
        Boolean loginResult = userService.compare(user.getName(), user.getPassword());
        //返回页面
        if (loginResult == true) {

            return "14";
        } else {
            return "redirect:login";
        }
        /*//从服务器获得基本信息
        System.out.println("getRequestURL: " + request.getRequestURL());
        System.out.println("getRequestURI: " + request.getRequestURI());
        System.out.println("getQueryString: " + request.getQueryString());
        System.out.println("getRemoteAddr: " + request.getRemoteAddr());
        System.out.println("getRemoteHost: " + request.getRemoteHost());
        System.out.println("getRemotePort: " + request.getRemotePort());
        System.out.println("getRemoteUser: " + request.getRemoteUser());
        System.out.println("getLocalAddr: " + request.getLocalAddr());
        System.out.println("getLocalName: " + request.getLocalName());
        System.out.println("getLocalPort: " + request.getLocalPort());
        System.out.println("getMethod: " + request.getMethod());
        //得到请求的参数Map，注意map的value是String数组类型
        System.out.println("-------request.getParameterMap()-------");
        Map map = request.getParameterMap();
        Set<String> keySet = map.keySet();
        System.out.println("keySet:" + keySet);
        for (String key : keySet) {
            String[] values = (String[]) map.get(key);
            for (String value : values) {
                System.out.println(key + "=" + value);
            }
        }
        //得到请求头的name集合
        System.out.println("--------request.getHeader()--------");
        Enumeration<String> em = request.getHeaderNames();
        System.out.println("em:" + em);
        while (em.hasMoreElements()) {
            String name = em.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + "=" + value);
        }*/


    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String Seven(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies != null) {
                if (cookies[i].getName().equals("Token")) {
                    cookies[i].setMaxAge(0);
                    cookies[i].setPath("/");
                    response.addCookie(cookies[i]);
                    /*String token = null;
                    cookies[i].setValue(token);
                    System.out.println(token);
                    System.out.println(cookies[i].getValue());*/
                }

            }
        }

        return "d";
    }
}
