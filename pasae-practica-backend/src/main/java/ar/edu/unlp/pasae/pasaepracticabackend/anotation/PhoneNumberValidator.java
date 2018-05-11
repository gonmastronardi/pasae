package ar.edu.unlp.pasae.pasaepracticabackend.anotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String>
{

@Override
public boolean isValid(final String phoneNumber, final ConstraintValidatorContext cxt) {
// Lo consideramos un campo obligatorio
if (phoneNumber == null)
	   return true;
return phoneNumber.matches("[0-9]+") && phoneNumber.length() > 7 && phoneNumber.length() < 14;

}

}