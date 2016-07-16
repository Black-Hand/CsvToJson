
package com.papgergely.csvtojson.controller.strategy.struct;

import com.papgergely.csvtojson.interfaces.CsvStruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * This class responsible for refinding the raw csv data to a json compatible struct.
 * 
 * @author Pap Gergely
 */
public class CsvRefinder implements CsvStruct<Map<String,String>>{
    
    private String[] header;
    private Map<String,String> row;
    
    @Override
    public void setHeader(String[] header){
        this.header = header;
    }
    
    @Override
    public Map<String, String> createStruct(List<String> splittedRawData) {
        Optional<String[]> headerArray = Optional.ofNullable(header);
        String[] colHeader = headerArray.orElseThrow(() -> new IllegalStateException("You forget set the header array!"));
        
        List<String> csvRow = splittedRawData;
        int idx = 0;
        row = new HashMap<>();
        for(String element : csvRow){
            try {
                row.put(colHeader[idx].intern(), element.intern());
            } catch (ArrayIndexOutOfBoundsException e) {}
            idx++;
        }
        return row;
    }
    
}
