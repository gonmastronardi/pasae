package ar.edu.unlp.pasae.pasaepracticabackend.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.edu.unlp.pasae.pasaepracticabackend.entity.Person;

public class PersonValidator implements Validator {

	public PersonValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

	}

}
