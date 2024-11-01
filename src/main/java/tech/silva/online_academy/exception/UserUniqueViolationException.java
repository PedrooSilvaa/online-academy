package tech.silva.online_academy.exception;

public class UserUniqueViolationException extends RuntimeException{

    public UserUniqueViolationException(String message) {
        super(message);
    }
}
