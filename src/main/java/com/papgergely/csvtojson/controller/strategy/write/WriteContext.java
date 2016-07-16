/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papgergely.csvtojson.controller.strategy.write;

import com.papgergely.csvtojson.interfaces.WriteFunction;

/**
 * This class contains the writer strategy.
 * @author Pap Gergely
 */
public class WriteContext {
    
    private WriteFunction<String> wrtiteStrategy;
    
    public WriteContext(WriteFunction wrtiteStrategy){
        this.wrtiteStrategy = wrtiteStrategy;
    }
    
    public void writeOut(String content){
        wrtiteStrategy.writeMethod(content);
    }
    
    public void setFilePath(String filePath){
        wrtiteStrategy.setFilePath(filePath);
    }
    
    public void setIsAppendable(boolean append){
        wrtiteStrategy.setAppandable(append);
    }
}
