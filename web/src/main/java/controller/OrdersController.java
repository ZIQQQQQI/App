package controller;

import com.github.pagehelper.PageInfo;
import domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.IOrderService;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrderService iOrderService;

    @RequestMapping("/findById.do")
    public ModelAndView findeById(@RequestParam(name="id",required = true) String id){
        ModelAndView mv=new ModelAndView();
         Orders orders=iOrderService.findById(id);
        return mv;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required = true) int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size){
        ModelAndView mv=new ModelAndView();

        List<Orders> or=iOrderService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(or);
        mv.addObject("pageinfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
}
