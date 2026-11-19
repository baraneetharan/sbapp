package com.kgisl.sbapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kgisl.sbapp.entity.Person;
import com.kgisl.sbapp.repository.PersonRepository;

@Service 
public class PersonService {
    public PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public Person updatePerson(int id, Person person) {
        Person existingPerson = personRepository.findById(id).orElse(null);
        if (existingPerson != null) {
            existingPerson.setUname(person.getUname());
            existingPerson.setEmail(person.getEmail());
            return personRepository.save(existingPerson);
        }
        return null;
    }
}
