package be.nascom.commons.validators;

import be.nascom.commons.constraints.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.GenericValidator;

/**
 * User: jgeraerts
 * Date: May 20, 2009
 * Time: 9:30:05 AM
 */
public class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public void initialize(Email email) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return GenericValidator.isEmail(s);
    }
}
