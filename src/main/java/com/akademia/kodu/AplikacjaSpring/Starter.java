package com.akademia.kodu.AplikacjaSpring;

import com.akademia.kodu.AplikacjaSpring.models.Bonus;
import com.akademia.kodu.AplikacjaSpring.models.Target;
import com.akademia.kodu.AplikacjaSpring.repositories.BonusRepository;
import com.akademia.kodu.AplikacjaSpring.repositories.IClubRepository;
import com.akademia.kodu.AplikacjaSpring.repositories.TargetRepository;
import com.akademia.kodu.AplikacjaSpring.services.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {
    @Autowired
    IClubRepository iClubRepository;
    @Autowired
    TargetRepository targetRepository;
    @Autowired
    TargetService targetService;
    @Autowired
    BonusRepository bonusRepository;
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
       targetRepository.createRandomTarget();
       targetRepository.createRandomTarget();
       bonusRepository.createBonus(new Bonus());
       iClubRepository.createFootballer("Mariusz","Stępiński","Attacker",80000,23,"Poland","Chievo Verona");
       targetService.assignRandomTarget("Mariusz");


    }
}