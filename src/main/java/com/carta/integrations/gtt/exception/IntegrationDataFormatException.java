package com.carta.integrations.gtt.exception;

public class IntegrationDataFormatException extends Exception{

    public IntegrationDataFormatException( Exception exception){
        super("File you are using is not in correct format!!",exception);
    }
}
