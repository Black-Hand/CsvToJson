
package com.papgergely.csvtojson.utils;

/**
 * Here enumerate the delimiters for the convert process.
 * Each enum constant hold a delimiter, when call one of these value,
 * with the getDelimiter() method you can retrieve te string representation of the delimiter constant.
 * 
 * @author BlackHand
 */
public enum Delimiters {
    COMMA(","), 
    COLON(":"), 
    SEMI_COLON(";");
    
    private String delimiter;
    
    private Delimiters(String delimiter){
        this.delimiter = delimiter; 
    }

    public String getDelimiter(){
        return delimiter;
    }
}
