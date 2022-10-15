package com.qubitfaruk.socialmedia.user;

import com.qubitfaruk.socialmedia.core.error.ApiError;
import com.qubitfaruk.socialmedia.core.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/1.0/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    // http://localhost:8080/api/1.0/user/createuser
    @PostMapping("/createuser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@RequestBody User user){

        ApiError apiError=new ApiError(400,"validation error","/api/1.0/user/createuser");
        Map<String,String> errors=new HashMap<String,String>();
        String username= user.getUsername();
        String displayName=user.getDisplayName();


        if (username==null || username.isEmpty()){
            errors.put("username",Messages.usernameNotEmptyAndNullMessage);
        }
        if (displayName==null){
            errors.put("displayName",Messages.displayNameNotEmptyAndNullMessage);
        }
        if (errors.size()>0){
            apiError.setValidationErrors(errors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
        }
        var data= this.userService.save(user);
        if (!data.isSuccess()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(data.getMessage());
       return ResponseEntity.ok(data);
    }

    // http://localhost:8080/api/1.0/user/getByUsername
    @GetMapping("/getByUsername")
    @ResponseStatus(HttpStatus.ACCEPTED)
     public DataResult<User> getByUserName(@RequestParam String username){
         return this.userService.getByUserName(username);
}
}
