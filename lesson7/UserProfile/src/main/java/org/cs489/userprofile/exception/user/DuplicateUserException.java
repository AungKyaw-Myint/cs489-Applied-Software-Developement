package org.cs489.userprofile.exception.user;

public class DuplicateUserException extends RuntimeException{

    public DuplicateUserException(String message){
        super(message);
    }
}
