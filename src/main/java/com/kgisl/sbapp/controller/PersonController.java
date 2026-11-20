package com.kgisl.sbapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.sbapp.entity.Person;
import com.kgisl.sbapp.service.PersonService;

@RestController
@RequestMapping("/person")
@CrossOrigin("*")
public class PersonController {

    public PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
        Person person = personService.getPersonById(id);
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        return new ResponseEntity<>(person, person != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(Person person) {
        Person createdPerson = personService.savePerson(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")

    public ResponseEntity<Person> updatePerson(@PathVariable int id, Person updatedPerson) {
        Person person = personService.updatePerson(id, updatedPerson);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deletePerson(@PathVariable("id") int id) {
        if (personService.getPersonById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
