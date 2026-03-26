package com.study.develop.contorller;

import com.study.develop.entity.Customer;
import com.study.develop.service.CusomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@Controller
public class CustomerController {  //localhost:8080/board/customerView

    @Autowired
    private CusomerService cusomerService;

    @GetMapping("/board/customerView")
    public String actorView(Model model){

        log.info("======>>>>> customerView");
        List<Customer> cst = cusomerService.getCustomerList();
        Map<Integer, Long> hmap =  cst.stream().collect(Collectors.groupingBy(Customer::getStore_id,Collectors.counting()));
        log.info("==============> 테스트 {}", hmap);
        //cst = cst.stream().filter(p-> p.getAddress_id() % 2 == 0).collect(Collectors.toList());

        model.addAttribute("customerList", cst);
        return "customerView";
    }


}
