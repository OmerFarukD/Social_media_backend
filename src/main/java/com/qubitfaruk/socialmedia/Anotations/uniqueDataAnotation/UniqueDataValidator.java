package com.qubitfaruk.socialmedia.Anotations.uniqueDataAnotation;

import com.qubitfaruk.socialmedia.user.User;
import com.qubitfaruk.socialmedia.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueDataValidator implements ConstraintValidator<UniqueData,String> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean isValid(String data, ConstraintValidatorContext context) {
        User user= this.userRepository.getByUsername(data);

        return user!=null ?  false :true;
    }
}
