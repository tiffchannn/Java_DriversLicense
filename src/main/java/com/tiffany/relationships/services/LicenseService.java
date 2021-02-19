package com.tiffany.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tiffany.relationships.models.License;
import com.tiffany.relationships.repos.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepo;
	
	public LicenseService(LicenseRepository licenseRepo) {
        this.licenseRepo = licenseRepo;
    }
    // returns all the books
    public List<License> allLicenses() {
        return licenseRepo.findAll();
    }
    // creates a book
    public License createLicense(License l) {
        return licenseRepo.save(l);
    }
    // retrieves a book
    public License findLicense(Long id) {
        Optional<License> license = licenseRepo.findById(id);
        if(license.isPresent()) {
            return license.get();
        } else {
            return null;
        }
    }
    
//    public License updateLicense(License l) {
//    	// TODO Auto-generated method stub
//    	return licenseRepo.save(l);
//    }
//    
//    public void deleteLicense(Long id) {
//    	licenseRepo.deleteById(id);
//    }

}
