package com.akademia.kodu.AplikacjaSpring.repositories;

import com.akademia.kodu.AplikacjaSpring.models.Target;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;
@Repository
public class TargetRepository {
    @PersistenceContext
    private EntityManager entityManager;

    Random random = new Random();
@Transactional
    public void createTarget(String description){
        Target newTarget = new Target(description);
        entityManager.persist(newTarget);

    }


    public List<Target>getAll(){
        return entityManager.createQuery("from Target",Target.class).getResultList();
    }
@Transactional
    public void deleteTarget(Target target){
        entityManager.remove(target);
    }

    @Scheduled(fixedDelay = 50000)
    @Transactional
    public void createRandomTarget(){
        List<String>targets = new ArrayList<>();
        targets.add("Zdobądz  bramke");
        targets.add("Zanotuj asyste");
        targets.add("Strzel bramkę przewrotką");
        targets.add("Strzel bramkę z główki");
        targets.add("Strzel klasycznego hat tricka");
        targets.add("Wygraj mecz");

        String target = targets.get(random.nextInt(targets.size()));
        createTarget(target);
    }


@Transactional
    public void update(Target target){
        entityManager.merge(target);
    }
    public Target getTarget(Integer id){
       return entityManager.find(Target.class,id);
    }
}
