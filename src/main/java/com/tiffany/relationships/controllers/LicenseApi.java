package com.tiffany.relationships.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiffany.relationships.models.License;
import com.tiffany.relationships.models.Person;
import com.tiffany.relationships.services.LicenseService;

@RestController
public class LicenseApi {
private final LicenseService licenseService;
	
    public LicenseApi(LicenseService licenseService){
        this.licenseService = licenseService;
    }
      
    @RequestMapping("/api/licenses")
    public List<License> showAllLicenses() {
        return licenseService.allLicenses();
    }
    
    
    @RequestMapping(value="/api/licenses", method=RequestMethod.POST)
    public License createLicense(@RequestParam(value="person") Person person, 
    				   @RequestParam(value="state") String state,  
    				   @RequestParam(value="expirationDate") Date expirationDate) {
    	License license = new License(person, state, expirationDate);
        return licenseService.createLicense(license);
    }
    
    @RequestMapping("/api/licenses/{id}")
    public License showLicense(@PathVariable("id") Long id) {
    	License license = licenseService.findLicense(id);
    	return license;
    }
}
