/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papgergely.csvtojson.libs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Pap Gergely
 */
public class GsonLibTest {
    
    private Gson testGson;
    
    @Before
    public void setUp() {
        testGson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    }
    
    @Test
    public void testGsonConvertStringToJson(){
        String jsonScript = testGson.toJson(new String[]{"name","id","age"});
        System.out.println(jsonScript);
    }
    
    @Test
    public void testGsonConvertCollectionToJson(){
        List<Map<String,String>> alt = new ArrayList<>();
        Map<String,String> subAlt = new HashMap<>();
        subAlt.put("id", String.valueOf(23));
        subAlt.put("name", "alt");
        String jsonScript = testGson.toJson(subAlt);
        System.out.println(jsonScript);
    }
    
}
