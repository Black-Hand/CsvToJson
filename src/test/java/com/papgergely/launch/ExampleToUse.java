
package com.papgergely.launch;

import com.papgergely.csvtojson.controller.CsvToJson;
import com.papgergely.csvtojson.controller.strategy.write.SimpleWrite;
import com.papgergely.csvtojson.utils.Delimiters;

/**
 * This example class show how to initialize and use the converter.
 * 
 * @author Pap Gergely
 */
public class ExampleToUse {
    public static void main(String[] args) {
        CsvToJson convert = new CsvToJson(new SimpleWrite());
        convert.setInputFilePath("src\\test\\resources/pathways.txt");
        convert.setOutputFilePath("src\\test\\resources/pathways");
        convert.setWritedUnitNumber(10);
        convert.setIsPrettyPrinted(true);
        convert.convertToJson(Delimiters.COMMA);
    }
}
