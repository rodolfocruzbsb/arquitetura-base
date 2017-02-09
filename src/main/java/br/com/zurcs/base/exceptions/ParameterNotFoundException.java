package br.com.zurcs.base.exceptions;

import java.io.Serializable;

public class ParameterNotFoundException extends InfraException implements Serializable{

    private static final long serialVersionUID = -1770053832048142044L;
    
    public ParameterNotFoundException() {
        this.severity = SeverityException.ERROR;
    }

    public ParameterNotFoundException(String messagekey, String message, Throwable causa) {
        super(messagekey, message, causa);
    }
    
    public ParameterNotFoundException(String messagekey, String message) {
        super(messagekey, message);
    }
    
    public ParameterNotFoundException(String messagekey, String message,
            SeverityException severity) {
        super(messagekey, message, severity);
    }
    
    public ParameterNotFoundException(Throwable causa) {
        super(causa);
    }

}
