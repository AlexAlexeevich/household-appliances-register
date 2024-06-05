package ru.info_system_and_services.household_appliances_register.exception;

public class SuchModelAlreadyExistException extends RuntimeException {

    public static final String SUCH_MODEL_ALREADY_EXIST = "Such a model already exists";

    public SuchModelAlreadyExistException() {
        super(SUCH_MODEL_ALREADY_EXIST);
    }
}
