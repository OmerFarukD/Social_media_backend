package com.qubitfaruk.socialmedia.user;

import com.qubitfaruk.socialmedia.core.error.ApiError;
import com.qubitfaruk.socialmedia.core.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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
    public ResponseEntity<?> createUser(@Valid @RequestBody User user){
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleException(MethodArgumentNotValidException exception){
        ApiError error=new ApiError(400,"validation error","/api/1.0/user");
        Map<String,String> validationErrors=new HashMap<String,String>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        error.setValidationErrors(validationErrors);
        return error;
    }

}
