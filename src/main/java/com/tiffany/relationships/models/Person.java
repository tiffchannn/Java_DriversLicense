package com.tiffany.relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String firstName;
    
    private String lastName;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    // @OneToOne(mappedBy="person"): This will map the license attribute in the Person class to the person attribute in the License class. 
    	// It represents the field that owns the relationship. This element is only specified on the inverse (non-owning) side of the association.
    // @OneToOne(cascade=CascadeType.ALL): The operations that must be cascaded to the target of the association. This will make sure referential integrity is preserved in ALL actions.
    // @OneToOne(fetch=FetchType.LAZY): Whether the association should be lazily loaded or must be eagerly fetched.
    	// LAZY: The association is fetched when needed
    	// EAGER: The association is fetched immediately.
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private License license;
    
    public Person() {
        
    }
    public Person(String firstName, 
			  	  String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
    }

	public Person(String firstName, 
				  String lastName,  
				  License license) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.license = license;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}
}
