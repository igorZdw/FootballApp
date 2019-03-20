package com.akademia.kodu.AplikacjaSpring.controllers;

import com.akademia.kodu.AplikacjaSpring.models.Footballer;
import com.akademia.kodu.AplikacjaSpring.models.Target;
import com.akademia.kodu.AplikacjaSpring.services.FootballerService;
import com.akademia.kodu.AplikacjaSpring.services.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TargetController {




    @Autowired
    FootballerService service;
    @Autowired
    TargetService targetService;

    @RequestMapping("/assignTarget")
    public String assignTarget(@RequestParam("footballerId") Integer id, Model model) {
        Footballer footballer = service.getFootballer(id);
        List<Target> notStartedTargets = targetService.getAllNotStartedTargets();
        model.addAttribute("footballer", footballer);
        model.addAttribute("notStartedTargets", notStartedTargets);
        return "assignTarget";
    }

    @RequestMapping(value = "/assignTarget", method = RequestMethod.POST)
    public String assignTarget(Footballer footballer, BindingResult result) {
        System.out.println(result);
        service.updateFootballer(footballer);
        return "redirect:/footballers";
    }

    @RequestMapping(value = "/checkTargets")
    public String checkTargets() {

        service.getMyBonus();
        return "redirect:/footballers";
    }

}


