/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.papgergely.csvtojson.model;

import com.papgergely.csvtojson.model.FileOperations;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Pap Gergely
 */
public class FileOperationsTest {
    
    private FileOperations fop;
    private final int PATHWAYS_SIZE = 279;
    
    @Before
    public void setUp() {
        fop = new FileOperations();
    }
    
    @Test
    public void testReadFileLines() {
        System.out.println("readFile");
        StringBuilder result = fop.readFile("src\\test\\resources/pathways.txt");
        List<String> splitStringToApart = Arrays.asList(String.valueOf(result).split("\n"));
        assertEquals(PATHWAYS_SIZE, splitStringToApart.size());
    }
    
    @Test
    public void testreadFolderContentFileNames(){
        List<String> fileNames = new ArrayList<>(
                Arrays.asList("agency.txt", "feed_info.txt", "pathways.txt", "routes.txt", "stops.txt")
        );
        List<String> readerFileNames = fop.readFolderContentFileNames("src\\test\\resources/dataSource/");
        assertEquals(fileNames, readerFileNames);
    }
}
