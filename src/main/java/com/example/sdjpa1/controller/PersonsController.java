package com.example.sdjpa1.controller;

import com.example.sdjpa1.model.Person;
import com.example.sdjpa1.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonsController {

    @Autowired
    IPersonRepository personRepository;

    //example: http://localhost:8080/persons/by-city?city=Moscow
    @GetMapping("/persons/by-city")
    public List getPersonsByCity(@RequestParam String city) {
        return personRepository.findByCity(city);
    }

    //example: http://localhost:8080/persons/by-age?age=3
    @GetMapping("/persons/by-age")
    public List getPersonsByAge(@RequestParam int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    //example: http://localhost:8080/persons/by-name-and-surname?name=Phillipps&surname=Nicholson
    @GetMapping("/persons/by-name-and-surname")
    public Optional<Person> advancedSearch(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}
