package com.person.Exception;

public class DateFnParseException extends PersonException {

	/**
     * Default serial version ID
     */
    private static final long serialVersionUID = 1L;

    private static final String DATE_PARSE_EXCEPTION_EXCEPTION_CODE = "220500"; //$NON-NLS-1$

    public DateFnParseException() {
        super(DATE_PARSE_EXCEPTION_EXCEPTION_CODE, "Format de la date invalide"); //$NON-NLS-1$
    }
    public DateFnParseException(final String dateStr) {
        super(DATE_PARSE_EXCEPTION_EXCEPTION_CODE, String.format("Format de la date invalide(date : %s)", dateStr));
    }
}
