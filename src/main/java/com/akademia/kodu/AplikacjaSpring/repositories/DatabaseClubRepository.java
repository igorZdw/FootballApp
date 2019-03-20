package com.akademia.kodu.AplikacjaSpring.repositories;

import com.akademia.kodu.AplikacjaSpring.models.Footballer;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

public class DatabaseClubRepository implements IClubRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createFootballer(String name, String surname, String position, double salary, int age,String country,String club) {
Footballer footballer = new Footballer(name,surname,position,salary,age,country,club);
entityManager.persist(footballer);
    }

    @Override
    public Collection<Footballer> getAllPlayers() {
        return entityManager.createQuery("from Footballer", Footballer.class).getResultList();
    }

    @Override
        public Optional<Footballer> getFootballer(String name) {

            Footballer footballerByName = entityManager.createQuery("from Footballer f where f.name =:name", Footballer.class).setParameter("name", name).getSingleResult();
            return Optional.ofNullable(footballerByName);
    }

    @Override
    @Transactional
    public void deleteFootballer(Integer id) {
        entityManager.remove(id);

    }

    @Override
    @Transactional
    public void createFootballer(Footballer footballer) {
entityManager.persist(footballer);
    }

    @Override
    public Footballer getFootballerById(Integer id) {
        return entityManager.find(Footballer.class,id);
    }

    @Override
    public void build() {

    }
    @Override
    @Transactional
    public void updateFootballer(int id, Footballer footballer) {

        entityManager.merge(footballer);
    }



}
