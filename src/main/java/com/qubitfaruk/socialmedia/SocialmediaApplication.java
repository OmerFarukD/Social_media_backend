package com.qubitfaruk.socialmedia;

import com.qubitfaruk.socialmedia.user.User;
import com.qubitfaruk.socialmedia.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)
public class SocialmediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialmediaApplication.class, args);

    }

 /*   @Bean
    CommandLineRunner createInitialUsers(UserService userService){
        return  (args)-> {
                User user=new User();
                user.setUsername("omer");
                user.setDisplayName("dogan");
                user.setPassword("p4ssword");
                userService.save(user);
        };
    }*/
}
