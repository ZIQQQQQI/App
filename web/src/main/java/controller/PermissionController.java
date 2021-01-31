package controller;

import domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IPermissionService;
import utils.RandomStr;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    IPermissionService iPermissionService;

    @RequestMapping("/save.do")
    String save(Permission permission){
        String id= RandomStr.random(10);
        permission.setId(id);
        iPermissionService.save(permission);

        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Permission> pl=iPermissionService.findAll();
        mv.addObject("permissionList",pl);
        mv.setViewName("permission-list");
        return mv;
    }
}
