/**
 * 
 */
package ar.edu.unlp.pasae.pasaepracticabackend.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaepracticabackend.dto.PersonDTO;
import ar.edu.unlp.pasae.pasaepracticabackend.entity.Person;

/**
 * @author gonmastronardi
 *
 */

@Component
public class PersonTransformer implements Transformer<Person, PersonDTO> {

	@Override
	public PersonDTO toDTO(Person p) {
		return new PersonDTO(p.getId(), p.getName(), p.getSurname(), p.getPhoneNumber());
	}

	@Override
	public Person toEntity(PersonDTO pDTO) {
		return new Person(pDTO.getId(), pDTO.getName(), pDTO.getSurname(),pDTO.getPhoneNumber());
	}

	@Override
	public List<PersonDTO> toListDTO(List<Person> listPerson) {
		List<PersonDTO> lista = new ArrayList<PersonDTO>();
		for (Person p : listPerson) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}
	
	@Override
	public Collection<PersonDTO> toCollectionDTO(List<Person> listPerson) {
		List<PersonDTO> lista = new ArrayList<PersonDTO>();
		for (Person p : listPerson) {
			lista.add(this.toDTO(p));
		}
		return lista;
	}


}
