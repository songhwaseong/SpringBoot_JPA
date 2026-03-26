package com.study.develop.contorller;

import com.study.develop.entity.Country;
import com.study.develop.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@Controller
public class CountryController {    //localhost:8080/board/countryView

    @Autowired
    private CountryService countryService;

    @GetMapping("/board/countryView")
    public String actorView(Model model){

        log.info("======>>>>> countryView");
        List<Country> countryList = countryService.getCountryList();

        Map<String, Long> hmap =  countryList.stream().collect(Collectors.groupingBy(Country::getContinent, Collectors.counting()));

        log.info("==========> {}", hmap);

//        countryList = countryList.stream().filter(p-> p.getIndepYear() != null &&  p.getIndepYear() > 1500)
//                .filter(p-> p.getGNP() > 50000)
//                .sorted(Comparator.comparing(Country::getGNP)).collect(Collectors.toList());

        String region =  countryList.stream().map(Country::getRegion).collect(Collectors.joining(","));

        countryList = countryList.stream().sorted(Comparator.comparing(Country::getContinent)).collect(Collectors.toList());

        log.info("{}",region);


        model.addAttribute("countryList", countryList);
        return "countryView";
    }


}
