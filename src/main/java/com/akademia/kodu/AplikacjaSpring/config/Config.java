package com.akademia.kodu.AplikacjaSpring.config;

import com.akademia.kodu.AplikacjaSpring.repositories.ClubRepository;
import com.akademia.kodu.AplikacjaSpring.repositories.DatabaseClubRepository;
import com.akademia.kodu.AplikacjaSpring.repositories.IClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class Config {

    @Bean(name="ClubRepository")
    @Profile("dev")
    public IClubRepository createClubRepository(){
        IClubRepository repository = new ClubRepository();
        return  repository;
    }

    @Bean(name="DatabaseClubRepository")
    @Profile("prod")
    public IClubRepository createDatabaseClubRepository(){
        IClubRepository repository = new DatabaseClubRepository();
        return  repository;
    }

}
