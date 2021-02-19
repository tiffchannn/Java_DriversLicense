package com.tiffany.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tiffany.relationships.models.Person;
import com.tiffany.relationships.services.PersonService;


@Controller
public class PersonController {
private final PersonService personService;
    
    
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @RequestMapping("/persons")
    public String index(Model model) {
        List<Person> persons = personService.allPeople();
        model.addAttribute("persons", persons);
        return "index.jsp";
    }
    
//    This will take us to our new form from new.jsp
    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new.jsp";
    }
    
    @RequestMapping(value="/persons/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
        	System.out.println("Error creating a person!");
            return "new.jsp";
        } else {
        	personService.createPerson(person);
        	System.out.println("Person was created!");
            return "redirect:/persons";
        }
    }
    
    // Show specific person's info
    @RequestMapping(value="/persons/{id}")
    public String showPersonInfo(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("person", personService.findPerson(id));
    	return "show.jsp";
    }
    

    
  
}
