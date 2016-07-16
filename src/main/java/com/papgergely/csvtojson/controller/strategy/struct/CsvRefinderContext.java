/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papgergely.csvtojson.controller.strategy.struct;

import com.papgergely.csvtojson.interfaces.CsvStruct;
import com.papgergely.csvtojson.interfaces.WriteFunction;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pap Gergely
 */
public class CsvRefinderContext {
    private CsvStruct<Map<String,String>> refinderStrategy;
    
    public CsvRefinderContext(CsvStruct refinderStrategy){
        this.refinderStrategy = refinderStrategy;
    }
    
    public void setHeader(String[] header){
        refinderStrategy.setHeader(header);
    }
    
    public Map<String,String> getRefindedStruct(List<String> splittedRawData){
        return refinderStrategy.createStruct(splittedRawData);
    }
    
}
