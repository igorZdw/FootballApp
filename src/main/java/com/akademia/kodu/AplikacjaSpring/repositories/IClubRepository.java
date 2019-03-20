package com.akademia.kodu.AplikacjaSpring.repositories;

import com.akademia.kodu.AplikacjaSpring.models.Footballer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public interface IClubRepository {
    void createFootballer(String name, String surname, String position, double salary, int age,String country,String club);
    Collection<Footballer>getAllPlayers();
    Optional<Footballer>getFootballer(String name);
    void deleteFootballer(Integer id);
    void createFootballer(Footballer footballer);
    Footballer getFootballerById(Integer id);
    void build();
    default void updateFootballer(int id, Footballer footballer){
        throw new NotImplementedException();
    }

}
