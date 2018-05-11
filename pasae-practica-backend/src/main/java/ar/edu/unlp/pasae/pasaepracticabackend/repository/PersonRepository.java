/**
 * 
 */
package ar.edu.unlp.pasae.pasaepracticabackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.pasae.pasaepracticabackend.dto.PersonDTO;
import ar.edu.unlp.pasae.pasaepracticabackend.entity.Person;

/**
 * @author gonmastronardi
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	//Query Methods
		
		Optional<Person> findByNameAndSurname(String name, String surname);
		List<Person> findByNameStartingWithOrderBySurnameDesc(String prefix);

	//Declared Query JPQL
	
		//@Query("from Person where name=:name and surname=:surname")
		//Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
	
		//@Query("from Person where name like :prefix% order by surname desc")
		//List<Person> findByNameStartingWithOrderBySurnameDesc(@Param("prefix") String prefix);

	//Declared Query Native Query
	
		//@Query(value = "SELECT * FROM Person WHERE name=:name AND surname=:surname", nativeQuery = true)
		//Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
		
		//@Query(value = "SELECT * FROM Person WHERE name like :prefix% ORDER BY surname DESC ", nativeQuery = true)
		//List<Person> findByNameStartingWithOrderBySurnameDesc(@Param("prefix") String prefix);
		
	//Declared Query Named Query
		
		//Optional<Person> findByNameAndSurname(String name, String surname);
		
		//List<Person> findByNameStartingWithOrderBySurnameDesc(String prefix);
		

}
