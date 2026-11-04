package com.example.session07.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ViettelPhoneValidator implements ConstraintValidator<ViettelPhone, String> {
    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext context){
        if(value == null||value.isBlank()){
            return true;
        }

        String regex = "^(03[2-9]|086|09[6-8])\\d{7}$";
        return value.matches(regex);
    }
}
