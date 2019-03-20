package com.akademia.kodu.AplikacjaSpring.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Size(min =3, max = 50,message = "Imie piłkarza musi być pomiędzy 3, a 50 znaków")
    private String name;
    @NotNull
    @Size(min =3, max = 50,message = "Nazwisko piłkarza musi być pomiędzy 3, a 50 znaków")
    private String surname;
    @NotNull
    @Size(min =3, max = 50,message = "Pozycja piłkarza musi być pomiędzy 3, a 50 znaków")
    private String position;
    @NotNull
    @Range(min=1,max=500000000,message = "Zarobki piłkarza muszą być pomiędzy 1, a 500000000 zł")
    private double salary;
    @NotNull
    @Range(min=12,max = 50,message = "Wiek piłkarza musi być pomiędzy 12, a 50 lat")
    private int age;
    @NotNull
    @Size(min =3, max = 100,message = "Kraj pochodzenia piłkarza musi być pomiędzy 3, a 100 znaków")
    private String country;
    @NotNull
    @Size(min =3, max = 100,message = "Aktualny klub piłkarza musi być pomiędzy 3, a 100 znaków")
    private String club;
    @OneToOne
    private Target target;


    public Footballer(String name, String surname, String position, double salary, int age,String country,String club) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
        this.age = age;
        this.country = country;
        this.club = club;
    }
    public Footballer(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        if(target!=null){
            target.setStarted(true);
        }
        this.target = target;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }


}
