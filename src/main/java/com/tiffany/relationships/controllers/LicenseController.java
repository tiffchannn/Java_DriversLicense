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

import com.tiffany.relationships.models.License;
import com.tiffany.relationships.models.Person;
import com.tiffany.relationships.services.LicenseService;
import com.tiffany.relationships.services.PersonService;

@Controller
public class LicenseController {
	private final LicenseService licenseService;
	private PersonService personService;
    
    
    public LicenseController(
    		LicenseService licenseService,
    		PersonService personService
    ) {
        this.licenseService = licenseService;
        this.personService = personService;
    }
    
    
//    This will take us to our new form from new.jsp
    @RequestMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License license, Model model) {
    	List<Person> personsList = personService.allPeople();
    	System.out.println(personsList.toString());
    	model.addAttribute("personsList", personsList);
        return "newLicense.jsp";
    }
    
    @RequestMapping(value="/licenses/new", method=RequestMethod.POST)
    public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	System.out.println("Error creating a license!");
            return "newLicense.jsp";
        } else {
        	licenseService.createLicense(license);
        	System.out.println("License was created!");
        	model.addAttribute("id", license.getPerson().getId());
        	System.out.println("/persons/" + license.getPerson().getId().toString());
            return "redirect:/persons/{id}";
        }
    }
    
    // Show specific person's info
    @RequestMapping(value="/licenses/{id}")
    public String showLicenseInfo(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("license", licenseService.findLicense(id));
    	return "show.jsp";
    }
    
}
