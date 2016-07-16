
package com.papgergely.csvtojson.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 *
 * @author Pap Gergely
 */
public class JsonParser {
    
    private static Gson jsonConverter;
    
    public JsonParser(boolean isPrettyPrinted){
        jsonConverter = isPrettyPrinted ? new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create() :  new GsonBuilder().disableHtmlEscaping().create();
    }
    
    public String convertStructToJson(Object dataStruct){
        return jsonConverter.toJson(dataStruct);
    }
    
    public void convertToJsonFormat(Object dataStruct, String path){
        try {
            jsonConverter.toJson(dataStruct, new FileWriter(path.concat(".json")));
        } catch (IOException ex) {
            Logger.getLogger(JsonParser.class).error(ex);
        }
    }
}
