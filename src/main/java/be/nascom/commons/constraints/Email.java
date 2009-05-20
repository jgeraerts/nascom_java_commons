package be.nascom.commons.constraints;

import be.nascom.commons.validators.EmailValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Created by IntelliJ IDEA.
 * User: jgeraerts
 * Date: May 20, 2009
 * Time: 9:27:22 AM
 * To change this template use File | Settings | File Templates.
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface Email {

    String message() default "{validator.email}";

    Class<?>[] groups() default {};
}
