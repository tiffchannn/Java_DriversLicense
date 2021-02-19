package com.tiffany.relationships.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiffany.relationships.models.License;
import com.tiffany.relationships.models.Person;
import com.tiffany.relationships.services.PersonService;

@RestController
public class PersonApi {
	private final PersonService personService;
	
    public PersonApi(PersonService personService){
        this.personService = personService;
    }
      
    @RequestMapping("/api/persons")
    public List<Person> showAllPeople() {
        return personService.allPeople();
    }
    
   
    
    @RequestMapping(value="/api/persons", method=RequestMethod.POST)
    public Person createPerson(@RequestParam(value="firstName") String firstName, 
    				   @RequestParam(value="lastName") String lastName) {
    	Person person = new Person(firstName, lastName);
        return personService.createPerson(person);
    }
    
    @RequestMapping("/api/persons/{id}")
    public Person showPerson(@PathVariable("id") Long id) {
    	Person person = personService.findPerson(id);
    	return person;
    }
    
//    @RequestMapping(value="/api/persons/{id}", method=RequestMethod.PUT)
//    public Person updatePerson(@PathVariable("id") Long id, 
//    					@RequestParam(value="title") String title, 
//    					@RequestParam(value="description") String desc,
//    					@RequestParam(value="language") String lang, 
//    					@RequestParam(value="pages") Integer numOfPages) {
//    	Person person = personService.updatePerson(id, title, desc, lang, numOfPages);
//        return person;
//    }
    
//    @RequestMapping(value="/api/persons/{id}", method=RequestMethod.DELETE)
//    public void destroy(@PathVariable("id") Long id) {
//    	personService.deletePerson(id);
//    }
}
