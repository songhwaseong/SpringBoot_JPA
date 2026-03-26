package com.study.develop.contorller;

import com.study.develop.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class FilmController {  //localhost:8080/board/filmView

    @Autowired
    private FilmService filmService;

    @GetMapping("/board/filmView")
    public String actorView(Model model){

        log.info("======>>>>> filmView");
        model.addAttribute("filmList", filmService.getFilmList());
        return "filmView";
    }


}
