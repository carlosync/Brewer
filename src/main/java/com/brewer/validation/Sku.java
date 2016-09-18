package com.brewer.validation;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "([a-zA-Z]{2}\\d{4})?")
public @interface Sku {

    @OverridesAttribute(constraint = Pattern.class, name = "message")
    String message() default "Formato do SkU inválido, o padrão deve ser XX9999";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
