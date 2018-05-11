/**
 * 
 */
package ar.edu.unlp.pasae.pasaepracticabackend.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaepracticabackend.dto.PersonDTO;
import ar.edu.unlp.pasae.pasaepracticabackend.entity.Person;
import ar.edu.unlp.pasae.pasaepracticabackend.exception.BaseException;
import ar.edu.unlp.pasae.pasaepracticabackend.exception.PersonNotFoundException;
import ar.edu.unlp.pasae.pasaepracticabackend.repository.PersonRepository;
import ar.edu.unlp.pasae.pasaepracticabackend.transformer.Transformer;

/**
 * @author gonmastronardi
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	/**
	 * 
	 */
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Transformer<Person, PersonDTO> transformer;
	@Autowired
	private Validator validator;

	private Transformer<Person, PersonDTO> getTransformer() {
		return transformer;
	}

	@SuppressWarnings("unused")
	private void setTransformer(Transformer<Person, PersonDTO> transformer) {
		this.transformer = transformer;
	}
	
	
	private PersonRepository getPersonRepository() {
		return personRepository;
	}

	@SuppressWarnings("unused")
	private void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	
	@Override
	public PersonDTO create(PersonDTO person) {
		Person p = new Person(person.getName(), person.getSurname(),person.getPhoneNumber());
		Set<ConstraintViolation<Person>> validations = validator.validate(p);//si esta vacio no hubieron errores de validacion
		if (validations.isEmpty()) {
			this.getPersonRepository().save(p);
			return person;
		}return null;
	}

	
	@Override
	public void update(PersonDTO person) {
		Optional<Person> op = this.getPersonRepository().findById(person.getId());
		Person p = op.get();
		p.editSurname(person.getSurname());
		p.editName(person.getName());
		this.getPersonRepository().save(p);
		
	}

	
	@Override
	public void delete(Long id) {
		this.getPersonRepository().deleteById(id);

	}

	
	@Override
	public PersonDTO retrieve(Long id) {
		Person p = this.getPersonRepository().findById(id).get();
		return this.getTransformer().toDTO(p);
	}

	
	@Override
	public List<PersonDTO> list() {
		List<Person> listPerson = this.getPersonRepository().findAll();
		return this.getTransformer().toListDTO(listPerson);
	}

	
	@Override
	public void thowException() throws BaseException {
		throw new RuntimeException("Excepción runtime");
	}

	@Override
	public PersonDTO findByNameAndSurname(final String name, final String surname) throws PersonNotFoundException {
			final Optional<Person> aOptionalPerson = getPersonRepository().findByNameAndSurname(name, surname);
			final Person aPerson = aOptionalPerson.orElseThrow(() -> new PersonNotFoundException());
			return this.getTransformer().toDTO(aPerson);
		}

	@Override
	public Collection<PersonDTO> findByNameStartingWithOrderBySurnameDesc(String prefix) throws PersonNotFoundException{
		final List<Person> peopleList = getPersonRepository().findByNameStartingWithOrderBySurnameDesc(prefix);
		return this.getTransformer().toCollectionDTO(peopleList);
	}

	
}
