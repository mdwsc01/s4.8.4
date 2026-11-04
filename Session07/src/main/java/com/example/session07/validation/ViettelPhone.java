package com.example.session07.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ViettelPhoneValidator.class)
public @interface ViettelPhone {
    String message() default "Số điện thoại này không phải số của Viettel";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
