package com.akademia.kodu.AplikacjaSpring.repositories;


import com.akademia.kodu.AplikacjaSpring.models.Footballer;
import com.akademia.kodu.AplikacjaSpring.utils.Ids;


import javax.annotation.PostConstruct;
import java.util.*;


public class ClubRepository implements IClubRepository {

    Map<Integer, Footballer>footballers = new HashMap<>();

public ClubRepository(){}

    @Override
    public void createFootballer(String name, String surname, String position, double salary, int age,String country, String club) {
        Footballer newFootballer = new Footballer(name,surname,position,salary,age,country,club);
        newFootballer.setId(Ids.generateNewId(footballers.keySet()));
        footballers.put(newFootballer.getId(),newFootballer);
    }

    @Override
    public Collection<Footballer> getAllPlayers() {
        return footballers.values();
    }

    @Override
    public Optional<Footballer> getFootballer(String name) {
        Optional<Footballer>footballerByName = footballers.values().stream().filter(footballer -> footballer.getName().equals(name)).findAny();
        return footballerByName;
    }

    @Override
    public void deleteFootballer(Integer id) {
        footballers.remove(id);

    }

    @Override
    public void createFootballer(Footballer footballer) {
        footballer.setId(Ids.generateNewId(footballers.keySet()));
        footballers.put(footballer.getId(),footballer);
    }

    @Override
    public Footballer getFootballerById(Integer id) {
        return footballers.get(id);
    }

    @Override
    @PostConstruct
    public void build() {
     createFootballer("Cristiano","Ronaldo","Attacker",200000,34,"Portugal","Juventus Turyn");
     createFootballer("Karim","Benzema","Attacker",190000,31,"France","Real Madryt");

    }
    public void updateFootballer(int id, Footballer footballer){
        footballers.put(id,footballer);
    }



    @Override
    public String toString() {
        return "ClubRepository{" +
                "footballers=" + footballers +
                '}';
    }
}
