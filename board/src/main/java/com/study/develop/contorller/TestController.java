package com.study.develop.contorller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class TestController {

    @GetMapping("/test/testView")
    public String testView(Model model){
        return "test";
    }

    @GetMapping("/test/test2View")
    public String test2View(Model model){
        return "test2";
    }
}
