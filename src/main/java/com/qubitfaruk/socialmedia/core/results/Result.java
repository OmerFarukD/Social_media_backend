package com.qubitfaruk.socialmedia.core.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Result {

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
       this(success);
        this.message = message;
    }

    private boolean success;
    private String message;

}
