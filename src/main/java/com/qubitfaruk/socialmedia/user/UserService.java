package com.qubitfaruk.socialmedia.user;

import com.qubitfaruk.socialmedia.core.results.*;
import com.qubitfaruk.socialmedia.core.rules.BusinessRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private  PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

public DataResult<User> getByUserName(String name){
      User user= this.userRepository.getByUsername(name);
      return new SuccessDataResult<User>(user);
    }

    public Result save(User user){

   /*     var rule= BusinessRules.run(getByUserNameController(user.getUsername()));
        if (rule!=null) return rule;*/
        String encodedPassword=this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        this.userRepository.save(user);
        return new SuccessResult(Messages.userSavedMessage);
    }


    // Business Rules.
    private Result getByUserNameController(String username){
        User data=this.userRepository.getByUsername(username);
        if (data!=null) return new ErrorResult(Messages.userAlreadyExists);

        return new  SuccessResult();
    }
}
