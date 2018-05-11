/**
 * 
 */
package ar.edu.unlp.pasae.pasaepracticabackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.NamedQuery;

import ar.edu.unlp.pasae.pasaepracticabackend.anotation.PhoneNumberConstraint;

/**
 * @author gonmastronardi
 *
 */

@SuppressWarnings("unused")
@Entity
//@NamedQuery(name = "Person.findByNameAndSurname",
//query = "SELECT p FROM Person p WHERE p.name = ?1 AND p.surname = ?2")


public class Person {

	/**
	 * 
	 */
	@Id   @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El nombre no puede ser nulo o vacío")
	private String name;
	@NotEmpty(message = "El apellido no puede ser nulo o vacío")
	private String surname;
	@PhoneNumberConstraint
	private String phoneNumber;

	
	private Person() {
		super();
		
	}
	
	public Person(Long id, String name, String surname) {
		super();
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
	}
	
	public Person(Long id, String name, String surname, String phoneNumber) {
		super();
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setPhoneNumber(phoneNumber);
	}

	public Person(String name, String surname) {
		super();
		this.setName(name);
		this.setSurname(surname);
	}
	
	public Person(String name, String surname, String phoneNumber) {
		super();
		this.setName(name);
		this.setSurname(surname);
		this.setPhoneNumber(phoneNumber);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	private void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param nombre the nombre to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the apellido
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param apellido the apellido to set
	 */
	private void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void editName( String name) {
		this.checkEmpty(name);
		this.setName(name);
	}
	
	public void editSurname( String surname) {
		this.checkEmpty(surname);
		this.setSurname(surname);
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

	protected void checkEmpty(String param){
		String campo = param.trim();
		if(campo.isEmpty())
			throw new IllegalArgumentException();
	}
}
