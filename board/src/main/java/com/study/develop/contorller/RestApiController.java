package com.study.develop.contorller;

import com.study.develop.entity.Dessert;
import com.study.develop.entity.Qualifications;
import com.study.develop.service.DessertsService;
import com.study.develop.service.QualificationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
public class RestApiController {
    @Autowired
    private QualificationsService qualificationsService;

    @Autowired
    private DessertsService dessertsRepository;

    @GetMapping("/api/testApi")
    public List<Qualifications> cityView(Model model) throws Exception {

        log.info("======>>>>> qualificationsView");

        return qualificationsService.getQualificationsList();
    }

    @GetMapping("/api/getDessert")
    public Dessert getDessert(Integer id) throws Exception {

        log.info("======>>>>> getDessert");
        log.info("id ::: " + id);

        return dessertsRepository.getDessert(id);
    }
    @GetMapping("/api/getDessertList")
    public List<Dessert> getFlower(Model model) throws Exception {

        log.info("======>>>>> ggetDessertList");

        return dessertsRepository.getDessertList();
    }
}
