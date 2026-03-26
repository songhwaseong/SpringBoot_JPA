package com.study.develop.contorller;

import com.study.develop.entity.Payment;
import com.study.develop.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;


@Slf4j
@Controller
public class PaymentController {  //localhost:8080/board/paymentView

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/board/paymentView")
    public String actorView(Model model){

        log.info("======>>>>> paymentView");

        List<Payment> lst = paymentService.getPaymentList();
        lst = lst
                .stream()
                .filter(p-> p.getAmount() > 4)
                .filter(p-> p.getStaff_id() == 2)
                .sorted(Comparator.comparing(Payment::getAmount).reversed())
                .toList();
        model.addAttribute("paymentList", lst);
        return "paymentView";
    }


}
