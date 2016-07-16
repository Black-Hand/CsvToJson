
package com.papgergely.csvtojson.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Pap Gergely
 */
public class FileOperations {
    
    private String path;
    private StringBuilder writeableFileContent;
    private List<String> fileNameStore;
    
    Logger Logging = Logger.getLogger(FileOperations.class);

    public void setPath(String filePath) {
        this.path = filePath;
    }
    /**
     * This method read the given file content and wrap into a <code>StringBuilder</code>
     * 
     * @param path The file location.
     * @return A StringBuilder with the content of the file.
     */
    public StringBuilder readFile(String path){
        StringBuilder fileContent = new StringBuilder();
        try(BufferedReader bfr = new BufferedReader(new FileReader(new File(path)))){
            while (bfr.ready()) {
                fileContent.append(bfr.readLine().concat("\n"));
            }
        }catch(IOException io){
            Logging.error(io);
        }
        return fileContent;
    }
    /**
     * This method can read up the whole folder, but only the files.
     * 
     * @param folderPath The readed folder path.
     * @return List of the contained file of folder.
     */
    public List<String> readFolderContentFileNames(String folderPath){
        fileNameStore = new ArrayList<>();
        File[] fileNames = new File(folderPath).listFiles();
        for(File fl : fileNames){
            if(fl.isFile()){
                fileNameStore.add(fl.getName());
            }
        }
        return fileNameStore;
    }
    
}
