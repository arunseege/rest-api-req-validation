package com.justcode.jsonvalidation.jsonvalidation;

import java.io.File;
import java.io.IOException;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;

/**
 * Hello world!
 *
 */
public class App 
{

public static void main( String[] args ) throws IOException, ProcessingException
{
    File schemaFile = new File("C:/udemy/arun/jaxb/jsonvalidation/src/main/java/com/justcode/jsonvalidation/jsonvalidation/jsonschema.json");
    File jsonFile = new File("C:/udemy/arun/jaxb/jsonvalidation/src/main/java/com/justcode/jsonvalidation/jsonvalidation/data.json");
    	
    if (ValidationUtils.isJsonValid(schemaFile, jsonFile)){
    	System.out.println("Valid!");
    }else{
    	System.out.println("NOT valid!");
    }
}
}
