package com.akademia.kodu.AplikacjaSpring.controllers;

import com.akademia.kodu.AplikacjaSpring.models.Bonus;
import com.akademia.kodu.AplikacjaSpring.models.Footballer;
import com.akademia.kodu.AplikacjaSpring.repositories.BonusRepository;
import com.akademia.kodu.AplikacjaSpring.services.FootballerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FootballerController {

    @Autowired
    BonusRepository bonusRepository;
    @Autowired
    FootballerService service;

    @RequestMapping("/footballers")
    public String getFootballers(Model model) {
        List<Footballer> allFootballers = service.getAllFootballers();
        Bonus bonus = bonusRepository.getFirst();
        model.addAttribute("footballers", allFootballers);
        model.addAttribute("bonus", bonus);
        return "footballers";
    }

    @RequestMapping("/footballer")
    public String getFootballer(@RequestParam("id") Integer id, Model model) {
        Footballer footballer = service.getFootballer(id);
        Bonus bonus = bonusRepository.getFirst();
        model.addAttribute("footballer", footballer);
        model.addAttribute("bonus", bonus);
        return "footballer";
    }

    @RequestMapping("/newFootballer")
    public String createFootballer(Model model) {
        model.addAttribute("footballer", new Footballer());
        Bonus bonus = bonusRepository.getFirst();
        model.addAttribute("bonus", bonus);
        return "footballerform";
    }

    @RequestMapping(value = "/footballers", method = RequestMethod.POST)
    public String saveFootballer(@Valid Footballer footballer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "footballerform";
        } else {
            service.saveFootballer(footballer);
            return "redirect:/footballers";
        }

    }

    @RequestMapping(value = "/footballer/delete/{id}")
    public String deleteFootballer(@PathVariable("id") Integer id) {
        service.deleteFootballer(id);
        return "redirect:/footballers";
    }
}

