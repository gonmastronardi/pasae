/**
 * 
 */
package ar.edu.unlp.pasae.pasaepracticabackend.service;

import java.util.Collection;
import java.util.List;

import ar.edu.unlp.pasae.pasaepracticabackend.dto.PersonDTO;
import ar.edu.unlp.pasae.pasaepracticabackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaepracticabackend.exception.PersonNotFoundException;

/**
 * @author gonmastronardi
 *
 */
public interface PersonService {
	
	PersonDTO create(PersonDTO person);
	void update(PersonDTO person);
	void delete(Long id);
	PersonDTO retrieve(Long id);
	List<PersonDTO> list();
	void thowException() throws BaseException;
	PersonDTO findByNameAndSurname(String name, String surname) throws PersonNotFoundException;
	Collection<PersonDTO> findByNameStartingWithOrderBySurnameDesc(String prefix) throws PersonNotFoundException;
	
}
