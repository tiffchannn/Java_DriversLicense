package com.tiffany.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.tiffany.relationships.models.Person;
import com.tiffany.relationships.repos.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepo;
    
    public PersonService(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }
    // returns all the books
    public List<Person> allPeople() {
        return personRepo.findAll();
    }
    // creates a book
    public Person createPerson(Person p) {
        return personRepo.save(p);
    }
    // retrieves a book
    public Person findPerson(Long id) {
        Optional<Person> person = personRepo.findById(id);
        if(person.isPresent()) {
            return person.get();
        } else {
            return null;
        }
    }
    
//    public Person updatePerson(Person p) {
//    	// TODO Auto-generated method stub
//    	return personRepo.save(p);
//    }
    
//    public void deletePerson(Long id) {
//    	personRepo.deleteById(id);
//    }
}
