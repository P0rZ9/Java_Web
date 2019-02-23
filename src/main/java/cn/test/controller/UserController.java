package cn.test.controller;


import cn.test.entity.User;
import cn.test.service.UserService;
import cn.test.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    @Resource
    private UserService userService;



    @RequestMapping(value = "/findUser", method = RequestMethod.GET)
    public String findUser(ModelMap modelMap){

        int id = 1;
        User user = this.userService.findUserById(id);
        modelMap.addAttribute("user",user);
        return "index";
    }

    @RequestMapping(value = "/addUser")
    public String addUser(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        Date birthday = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e){
            e.printStackTrace();
        }
        user.setUser_id(user_id);
        user.setUsername(username);
        user.setAge(age);
        user.setSex(sex);
        user.setBirthday(birthday);

        userService.addUser(user);

        return "redirect:listUser";
    }

    @RequestMapping(value = "/listUser")
    public String listUser(HttpServletRequest request,HttpServletResponse response){
        // 获取分页参数
        int start = 0;
        int count = 10;

        try {
            start = Integer.parseInt(request.getParameter("page.start"));
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception e) {
        }
        Page page = new Page(start, count);

        List<User> users = userService.list(page.getStart(), page.getCount());
        int total = userService.getTotal();
        page.setTotal(total);
        request.setAttribute("users", users);
        request.setAttribute("page", page);

        return "listUser";
    }

    @RequestMapping(value = "delUser")
    public String delUser(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUserById(id);

        return "redirect:listUser";
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.GET)
    public String updateUser(int id,ModelMap modelMap){
        User user = userService.findUserById(id);
        modelMap.addAttribute("user",user);

        return "editUser";
    }

    @RequestMapping(value = "updateUserP", method = RequestMethod.POST)
    public String updateUserP(HttpServletRequest request,HttpServletResponse response){
        User user1 = new User();

        int id = Integer.parseInt(request.getParameter("id"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        Date birthday = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e){
            e.printStackTrace();
        }
        user1.setId(id);
        user1.setUser_id(user_id);
        user1.setUsername(username);
        user1.setAge(age);
        user1.setSex(sex);
        user1.setBirthday(birthday);


        userService.updateUser(user1);

        return "redirect:listUser";

    }








}
