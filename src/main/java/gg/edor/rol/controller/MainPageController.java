package gg.edor.rol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class MainPageController {

    @GetMapping(value = {"/", "/main"})
    public String frontPage() {
        return "메인페이지";
    }
}
