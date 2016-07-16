
package com.papgergely.csvtojson.controller.strategy.write;

import com.papgergely.csvtojson.interfaces.WriteFunction;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 * This class implements a simple <code>FileWriter</code> based write process.
 * 
 * @author Pap Gergely
 */
public class SimpleWrite implements WriteFunction<String>{
    
    private String filePath;
    private boolean isAppendable = false;
    private Logger Logging = Logger.getLogger(BufferWrite.class);
    
    public SimpleWrite(){
        Logging.info("Simple Write strategy selected");
    }
    
    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    @Override
    public void setAppandable(boolean append) {
        this.isAppendable = append;
    }
    
    @Override
    public <E extends String> void writeMethod(E content) {
        try(FileWriter fw = new FileWriter(filePath.concat(".json"), isAppendable)){
            fw.write(content);
        }catch(IOException ie){
            Logging.error(ie);
        }
    }
}
