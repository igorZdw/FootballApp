package com.akademia.kodu.AplikacjaSpring.services;

import com.akademia.kodu.AplikacjaSpring.models.Target;
import com.akademia.kodu.AplikacjaSpring.repositories.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
    public class TargetFormatter implements Formatter<Target> {

        @Autowired
        TargetRepository repository;

        @Override
        public Target parse(String idAsStr, Locale locale) throws ParseException {
            Integer id = Integer.parseInt(idAsStr);
            return repository.getTarget(id);
        }

        @Override
        public String print(Target object, Locale locale) {
            return object.toString();
        }
    }


