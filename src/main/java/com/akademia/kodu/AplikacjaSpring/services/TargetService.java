package com.akademia.kodu.AplikacjaSpring.services;

import com.akademia.kodu.AplikacjaSpring.models.Target;
import com.akademia.kodu.AplikacjaSpring.repositories.IClubRepository;
import com.akademia.kodu.AplikacjaSpring.repositories.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TargetService {
    @Autowired
    IClubRepository iClubRepository;

    TargetRepository targetRepository;

    final static Random random = new Random();

    public void assignRandomTarget(String footballerName){
        List<Target>allTargets = targetRepository.getAll();
        Target randomTarget = allTargets.get(random.nextInt(allTargets.size()));
        iClubRepository.getFootballer(footballerName).ifPresent(footballer -> footballer.setTarget(randomTarget));

    }
    @Autowired
    public void setTargetRepository(TargetRepository targetRepository){
        this.targetRepository = targetRepository;
    }

    public List<Target>getAllNotStartedTargets(){
        return targetRepository.getAll().stream().filter(target -> !target.isStarted()).collect(Collectors.toList());
    }

    public void update(Target target){
        targetRepository.update(target);
    }

    public boolean isTargetCompleted(Target target){
        return target.isEnded();
    }
}
