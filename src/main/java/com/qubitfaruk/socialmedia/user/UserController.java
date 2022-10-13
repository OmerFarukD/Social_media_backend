package com.qubitfaruk.socialmedia.user;

import com.qubitfaruk.socialmedia.core.results.DataResult;
import com.qubitfaruk.socialmedia.core.results.Result;
import com.qubitfaruk.socialmedia.core.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    // http://localhost:8080/api/1.0/user/createuser
    @PostMapping("/createuser")
    @ResponseStatus(HttpStatus.CREATED)
    public Result createUser(@RequestBody User user){
       return this.userService.save(user);
    }

    // http://localhost:8080/api/1.0/user/getByUsername
    @GetMapping("/getByUsername")
    @ResponseStatus(HttpStatus.ACCEPTED)
     public DataResult<User> getByUserName(@RequestParam String username){
         return this.userService.getByUserName(username);
}
}
