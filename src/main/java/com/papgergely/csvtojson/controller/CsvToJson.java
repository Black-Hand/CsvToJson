
package com.papgergely.csvtojson.controller;

import com.papgergely.csvtojson.controller.strategy.struct.CsvRefinder;
import com.papgergely.csvtojson.controller.strategy.struct.CsvRefinderContext;
import com.papgergely.csvtojson.controller.strategy.write.WriteContext;
import com.papgergely.csvtojson.interfaces.WriteFunction;
import com.papgergely.csvtojson.model.FileOperations;
import com.papgergely.csvtojson.model.JsonParser;
import com.papgergely.csvtojson.utils.Delimiters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.log4j.Logger;

/**
 * This class responsible the convert process.
 * 
 * @author Pap Gergely
 */
public class CsvToJson {
    
    private FileOperations fop;
    private WriteContext writeContext;
    private CsvRefinderContext refinder;
    private JsonParser parseCsvToJson;
    private List<Map<String,String>> jsonStruct = new ArrayList<>();
    private final static String COMMA = ",".intern();
    private static String stringyfyJsonStruct = "";
    
    private String[] header;
    private String inputFilePath;
    private String outputFilePath = "./defaultNoName";
    private int writedUnitNumber = 10;
    private boolean isPrettyPrinted = false;
    private boolean isAppended = true;
    
    private Logger Logging = Logger.getLogger(CsvToJson.class);
    
    public CsvToJson(WriteFunction function){
        fop = new FileOperations();
        writeContext = new WriteContext(function);
        refinder = new CsvRefinderContext(new CsvRefinder());
    }
    /**
     * This method convert the given csv format file to json format file.
     * 
     * @param delimiter
     */
    public void convertToJson(Delimiters delimiter){
        Logging.info("Convert from: "+inputFilePath);
        List<String> csvContent = getRawCsvContent(inputFilePath);
        Logging.info("Size of file: "+csvContent.size());
        
        initWriteContext();
        
        header = new String[]{csvContent.remove(0)};
        refinder.setHeader(header[0].split(delimiter.getDelimiter()));
        
        List<String> splitCsvToCols;
        Map<String, String> jsonRow;
        parseCsvToJson = new JsonParser(isPrettyPrinted);
        writeContext.writeOut("[");
        int idx = 0;
        for(String rows : csvContent){
            splitCsvToCols = Arrays.asList(rows.split(delimiter.getDelimiter()));
            jsonRow = refinder.getRefindedStruct(splitCsvToCols);
            stringyfyJsonStruct += parseCsvToJson.convertStructToJson(jsonRow).concat(COMMA);
            if(idx == writedUnitNumber){
                writeContext.writeOut(stringyfyJsonStruct);
                idx = 0;
                stringyfyJsonStruct="";
            }
            idx++;
        }
        writeContext.writeOut(stringyfyJsonStruct);
        writeContext.writeOut("{}]"); //TODO
        
        Logging.info("Converting done.");
    }
    
    private void initWriteContext(){
        writeContext.setFilePath(outputFilePath);
        writeContext.setIsAppendable(isAppended);
    }
    
    private List<String> getRawCsvContent(String filePath){
        String csvFileContent = fop.readFile(filePath).toString();
        return new ArrayList<>(Arrays.asList(csvFileContent.split("\n")));
    }
    /**
     * The input file location and name.
     * 
     * @param inputFilePath 
     */
    public void setInputFilePath(String inputFilePath) {
        Optional<String> inputPath = Optional.ofNullable(inputFilePath);
        this.inputFilePath = inputPath.orElseThrow(() -> new IllegalStateException("You were forget setting up the past."));
    }
    /**
     * The output file location and name.
     * 
     * @param outputFilePath 
     */
    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }
    /**
     * This paramter set the collected unit / write.
     * 
     * default 10.
     * @param writedUnitNumber Number of unit compress before write.
     */
    public void setWritedUnitNumber(int writedUnitNumber) {
        this.writedUnitNumber = writedUnitNumber;
    }
    /**
     * This paramter adjust the output Json file layout.
     * <p><b>true:</b> the output will be done in indented and formatted shape.</p>
     * <p><b>false:</b> the output will be done in minimal formatting.</p>
     * 
     * <p>default false.</p>
     * @param isPrettyPrinted 
     */
    public void setIsPrettyPrinted(boolean isPrettyPrinted) {
        this.isPrettyPrinted = isPrettyPrinted;
    }
    /**
     * This paramter sets, is the file append new content or starts a new file.
     * 
     * @param isAppended 
     */
    public void setIsAppended(boolean isAppended) {
        this.isAppended = isAppended;
    }
}
