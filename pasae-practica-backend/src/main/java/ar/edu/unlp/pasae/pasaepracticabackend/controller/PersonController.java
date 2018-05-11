/**
 * 
 */
package ar.edu.unlp.pasae.pasaepracticabackend.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaepracticabackend.aspect.ExceptionHandlerAspect;
import ar.edu.unlp.pasae.pasaepracticabackend.dto.PersonDTO;
import ar.edu.unlp.pasae.pasaepracticabackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaepracticabackend.exception.PersonNotFoundException;
import ar.edu.unlp.pasae.pasaepracticabackend.service.PersonService;

/**
 * @author gonmastronardi
 *
 */

@RestController
@RequestMapping("/person")
public class PersonController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAspect.class);
	
	@Autowired
	PersonService personService;
	/**
	 * 
	 */
	public PersonController() {
		// TODO Auto-generated constructor stub
	}
	
	//Listado de personas
	@GetMapping(path = "/list")
	public List<PersonDTO> listPeople() {
		List<PersonDTO> lista = this.getPersonService().list();
		return lista;
		
	}
	
	//Create
	 @PutMapping(path = "/create", consumes = "application/json", produces = "application/json")
	  public PersonDTO create(@RequestBody @Valid PersonDTO person) {
	    return this.getPersonService().create(person);
	  }
	 
	 //Retrieve
	 @GetMapping(path = "/{id}", produces = "application/json")
	  public PersonDTO show(@PathVariable(value = "id") Long id) {
	    return this.getPersonService().retrieve(id);
	  }
	 
	 //Delete
	 @DeleteMapping(path = "/{id}")
	  public void delete(@PathVariable(value= "id") Long id) {
	    this.getPersonService().delete(id);
	  }
	 
	 
	//Update
	 @PatchMapping(path = "/", consumes = "application/json")
	  public void update(@RequestBody PersonDTO person) {
	    this.getPersonService().update(person);
	  }

	 private PersonService getPersonService() {
		    return this.personService;
		  }
	 
	 //Exception
	 @GetMapping(path = "/exception")
		public void exception() {
			try {
				getPersonService().thowException();
			} catch (final BaseException e) {
				logger.error("Excepción {}", e.getLocalizedMessage());
			}
		}

	 @GetMapping(path = "/findByNameAndSurname")
		public PersonDTO findByNameAndSurname(final String name, final String surname) throws PersonNotFoundException {
			return getPersonService().findByNameAndSurname(name, surname);
		}

		
		@GetMapping(path = "/findByNamePrefix")
		public Collection<PersonDTO> findByNamePrefix(final String prefix) throws PersonNotFoundException {
			return getPersonService().findByNameStartingWithOrderBySurnameDesc(prefix);
		}
		

		@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This person is not found in the system")
		@ExceptionHandler(PersonNotFoundException.class)
		public void personExceptionHandler() {
		}


	
}
