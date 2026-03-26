package com.study.develop.contorller;

import com.study.develop.entity.Actor;
import com.study.develop.service.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
public class ActorController {  //localhost:8080/board/actorView

    @Autowired
    private ActorService actorService;

    @GetMapping("/board/actorView")
    public String actorView(Model model){

        log.info("======>>>>> actorView");

        Actor act = Actor.builder()
                .first_name("SONG")
                .last_name(("HHWASEONG"))
                .build()
                ;
        //actorService.insertActor(act);
        List<Actor> actList = actorService.getActorList();
        actList = actList
                    .stream()
                    //.filter(p -> p.getLast_name().startsWith("J"))
                    .filter(p -> p.getLast_name().equals("HHWASEONG"))
                    .sorted(Comparator.comparing(Actor::getActor_id))
                    .collect(Collectors.toList());
        log.info("============> {}",actList);
        model.addAttribute("actorList", actList);
        return "actorView";
    }


}
