package gg.edor.rol.controller;

import gg.edor.rol.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private MainService mainService;

    @GetMapping(value = "/index")
    public ModelAndView indexPage() {
        return new ModelAndView("/index/index").addObject("result_info", mainService.getDao());
    }
}
