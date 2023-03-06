package org.example.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super();
    }

    public UserNotFoundException(String msg){
        super(msg + " this is a customized exception");
    }
}
