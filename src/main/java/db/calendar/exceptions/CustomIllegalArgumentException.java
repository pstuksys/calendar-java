package db.calendar.exceptions;

public class CustomIllegalArgumentException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE_TEMPLATE = " field was not provided.";

    public CustomIllegalArgumentException(String field) {
        super(String.format(field, DEFAULT_MESSAGE_TEMPLATE));
    }

    public CustomIllegalArgumentException(String field, String customMessage) {
        super(customMessage != null ? customMessage : String.format(field, DEFAULT_MESSAGE_TEMPLATE));
    }
}
