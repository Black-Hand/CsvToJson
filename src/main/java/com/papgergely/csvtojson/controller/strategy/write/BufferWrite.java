
package com.papgergely.csvtojson.controller.strategy.write;

import com.papgergely.csvtojson.interfaces.WriteFunction;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 * his class implements a Buffered version of write process.
 * 
 * @author Pap Gergely
 */
public class BufferWrite implements WriteFunction<String>{
    
    private String filePath;
    private boolean isAppendable = false;
    private Logger Logging = Logger.getLogger(BufferWrite.class);
    
    public BufferWrite(){
        Logging.info("Buffered Write strategy selected");
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
        try(BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(filePath.concat(".json")),isAppendable))){
            bfw.write(content);
            
        } catch (IOException e) {
            Logging.error(e);
        }
    }

    
}
