package com.example.sdjpa1.repository;

import com.example.sdjpa1.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByCity(String cityOfLiving);

    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
