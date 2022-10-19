package com.qubitfaruk.socialmedia.Anotations.uniqueDataAnotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueDataValidator.class})

public @interface UniqueData {
    String message() default "Kullanıcı adı benzersiz olmalı";

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
