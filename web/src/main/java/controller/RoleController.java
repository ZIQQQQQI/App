package controller;

import domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IRoleService;
import utils.RandomStr;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    IRoleService iRoleService;

    @RequestMapping("/save.do")
    String save(Role role){
        String id= RandomStr.random(10);
        role.setId(id);
        iRoleService.save(role);
        return  "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Role> rs=iRoleService.findAll();
        mv.addObject("roleList",rs);
        mv.setViewName("role-list");
        return  mv;
    }
}
