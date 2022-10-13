package com.qubitfaruk.socialmedia.core.rules;

import com.qubitfaruk.socialmedia.core.results.Result;

public class BusinessRules {
    public static Result run(Result ...logigs){
        for (Result logic:logigs){
            if (!logic.isSuccess()) return logic;
        }
        return null;
    }
}
