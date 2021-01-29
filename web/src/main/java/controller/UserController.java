package controller;

import domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserServiceImpl;
import utils.RandomStr;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    //find a user by id
    @RequestMapping("findById.do")
    ModelAndView findById(String id){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo= userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return  mv;
    }


    //add user
    @RequestMapping("/save.do")
    public  String save(UserInfo userInfo){
        String id= RandomStr.random(10);
        userInfo.setId(id);
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<UserInfo> us=userService.findAll();
        mv.addObject("userList",us);
        mv.setViewName("user-list");

        return mv;
    }

}
