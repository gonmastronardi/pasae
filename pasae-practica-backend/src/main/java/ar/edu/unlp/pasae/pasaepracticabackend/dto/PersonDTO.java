/**
 * 
 */
package ar.edu.unlp.pasae.pasaepracticabackend.dto;

import javax.validation.constraints.NotEmpty;

import ar.edu.unlp.pasae.pasaepracticabackend.anotation.PhoneNumberConstraint;

/**
 * @author gonmastronardi
 *
 */
public class PersonDTO {

	/**
	 * 
	 */
	private Long id;
	
	@NotEmpty(message = "El nombre no puede ser nulo o vacío")
	private String name;
	@NotEmpty(message = "El apellido no puede ser nulo o vacío")
	private String surname;
	@PhoneNumberConstraint
	private String phoneNumber;

	
	
	
	
	public PersonDTO() {
		super();
	}

	public PersonDTO(Long id, String name, String surname) {
		super();
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
	}

	public PersonDTO(Long id, String name, String surname, String phoneNumber) {
		super();
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setPhoneNumber(phoneNumber);
	}
	
	public PersonDTO(String name, String surname) {
		super();
		this.setName(name);
		this.setSurname(surname);
	} 
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @return the nombre
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the apellido
	 */
	public String getSurname() {
		return surname;
	}



	/**
	 * @param id the id to set
	 */
	private void setId(Long id) {
		this.id = id;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @param apellido the apellido to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
