package com.akademia.kodu.AplikacjaSpring.services;


import com.akademia.kodu.AplikacjaSpring.models.Bonus;
import com.akademia.kodu.AplikacjaSpring.models.Footballer;
import com.akademia.kodu.AplikacjaSpring.repositories.BonusRepository;
import com.akademia.kodu.AplikacjaSpring.repositories.IClubRepository;
import com.akademia.kodu.AplikacjaSpring.repositories.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class FootballerService {

    @Autowired
    IClubRepository iClubRepository;
    @Autowired
    TargetRepository targetRepository;

    @Autowired
    BonusRepository bonusRepository;


    public List<Footballer> getAllFootballers() {
        return new ArrayList<>(iClubRepository.getAllPlayers());

    }

    public void saveFootballer(Footballer footballer) {
        iClubRepository.createFootballer(footballer);
    }

    public Footballer getFootballer(Integer id) {
        return iClubRepository.getFootballerById(id);
    }

    public void deleteFootballer(Integer id) {
        iClubRepository.deleteFootballer(id);
    }

    public void updateFootballer(Footballer footballer) {
        iClubRepository.updateFootballer(footballer.getId(), footballer);
    }

    public int collectRewards() {
        Predicate<Footballer> footballerPredicate = footballer -> {
            if (footballer.getTarget() != null) {
                return footballer.getTarget().isEnded();
            } else {
                return false;
            }
        };
        int sum = iClubRepository.getAllPlayers().stream().filter(footballerPredicate).mapToInt(footballer -> footballer.getTarget().getReward()).sum();
        iClubRepository.getAllPlayers().stream().filter(footballerPredicate).forEach(footballer -> {
            footballer.setTarget(null);
        });
        return sum;
    }
@Transactional
    public void getMyBonus() {
        List<Footballer> footballers = getAllFootballers();
        footballers.forEach(footballer -> {
                    if (footballer.getTarget() != null) {
                        boolean completed = footballer.getTarget().isEnded();

                        if (completed) {
                            targetRepository.update(footballer.getTarget());
                        }
                    }
                }
        );
    Bonus first = bonusRepository.getFirst();
        int currentBonus = first.getBonus();
        first.setBonus(currentBonus + collectRewards());

    }
}

