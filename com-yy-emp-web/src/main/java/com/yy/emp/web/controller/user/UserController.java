package com.yy.emp.web.controller.user;

import com.yy.emp.model.User;
import com.yy.emp.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by tuz
 * on 2020/5/15.
 */
@Controller
public class UserController extends BaseController {
    //    用户管理系统主页菜单 get
    @GetMapping("/main")
    public String home(HttpSession session){
        session.setAttribute("currentUser",new User());
        return "main";
    }

    @GetMapping("/regist")
    public String regist(HttpSession session){
        return "regist";
    }
    //	  用户注册   post
    @PostMapping("/user/regist")
    public String regist(HttpServletRequest request,User user, Model model){
        userService.register(user);
        return get(user.getId(),model);
    }
//    用户信息查看 get
    @GetMapping("/user/get")
    public String get(Integer id,Model model){
        User user1 = userService.get(id);
        model.addAttribute("user",user1);
        return "user";
    }
//    用户信息修改 post
    @PostMapping("/user/update")
    public String update(User user,Model model){
        userService.update(user);
        return get(user.getId(),model);
    }
//    密码修改 post
    @PostMapping("/user/updatePwd")
    public String updatePwd(Integer id,String newPwd,Model model){
        userService.updatePwd(id,newPwd);
        return get(id,model);
    }
    //列表显示
//    @GetMapping("/list")
//    @ResponseBody
//    public Object userList(){
//        return userService.list();
//    }
}
