/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papgergely.csvtojson.convert;

import com.papgergely.csvtojson.controller.strategy.struct.CsvRefinder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pap Gergely
 */
public class CsvRefinderTest {
    
    private CsvRefinder testRefi;
    private String[] header = {"id","name","age"};
    private static Map<String, String> expResult = new HashMap<>();
    static{
        expResult.put("id", "12");
        expResult.put("name", "Andi");
        expResult.put("age", "24");
    }
    
    @Before
    public void setUp() {
        testRefi = new CsvRefinder();
        testRefi.setHeader(header);
    }

    /**
     * Test of createStruct method, of class CsvRefinder.
     */
    @Test
    public void testCreateStruct() {
        System.out.println("createStruct");
        List<String> splittedRawData = new ArrayList<>(
                Arrays.asList("12","Andi","24")
        );
        Map<String, String> result = testRefi.createStruct(splittedRawData);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    @Test(expected=IllegalStateException.class)
    public void testCreateStructMissingHeader() {
        testRefi.setHeader(null);
        List<String> splittedRawData = new ArrayList<>(
                Arrays.asList("12","Andi","24")
        );
        Map<String, String> result = testRefi.createStruct(splittedRawData);
    }
    
}
