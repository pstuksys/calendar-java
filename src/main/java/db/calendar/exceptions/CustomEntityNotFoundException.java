package db.calendar.exceptions;
import jakarta.persistence.EntityNotFoundException;

public class CustomEntityNotFoundException extends EntityNotFoundException {
    private static final String DEFAULT_MESSAGE_TEMPLATE = "The requested entity '%s' was not found.";
    private static final String DEFAULT_MESSAGE_TEMPLATE_NO_ENTITY = "The requested entity was not found.";

    public CustomEntityNotFoundException(String entity) {
        super(String.format(DEFAULT_MESSAGE_TEMPLATE, entity));
    }

    public CustomEntityNotFoundException() {
        super(String.format(DEFAULT_MESSAGE_TEMPLATE_NO_ENTITY));
    }

    public CustomEntityNotFoundException(String entity, String customMessage) {
        super(customMessage != null ? customMessage : String.format(DEFAULT_MESSAGE_TEMPLATE, entity));
    }
}
