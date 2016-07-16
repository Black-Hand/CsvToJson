
package com.papgergely.csvtojson.interfaces;

/**
 * This interface contains the write strategy abstraction.
 * 
 * @author Pap Gergely
 */
public interface WriteFunction<T> {
    
    public void setFilePath(String filePath);
    public void setAppandable(boolean append);
    
    public <E extends T> void writeMethod(E content);
    
}
