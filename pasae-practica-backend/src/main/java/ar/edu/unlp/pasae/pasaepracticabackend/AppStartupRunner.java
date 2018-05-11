package ar.edu.unlp.pasae.pasaepracticabackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ar.edu.unlp.pasae.pasaepracticabackend.entity.Person;
import ar.edu.unlp.pasae.pasaepracticabackend.repository.PersonRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {

	@Autowired
	private PersonRepository personRepository;

	
	@Override
	public void run(final ApplicationArguments args) throws Exception {
		getPersonRepository().save(new Person("Matías", "Beccaria"));
		getPersonRepository().save(new Person("Matías", "Butti"));

	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}


}
