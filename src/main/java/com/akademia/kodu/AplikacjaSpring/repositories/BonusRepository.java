package com.akademia.kodu.AplikacjaSpring.repositories;

import com.akademia.kodu.AplikacjaSpring.models.Bonus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class BonusRepository {
    @PersistenceContext
    EntityManager entityManager;

   @Transactional
    public void createBonus(Bonus bonus){
       entityManager.persist(bonus);
   }
   public Bonus getFirst(){
       return entityManager.createQuery("from Bonus" ,Bonus.class).getResultList().get(0);
   }
}
