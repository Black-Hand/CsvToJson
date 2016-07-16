
package com.papgergely.csvtojson.interfaces;

import java.util.List;

/**
 * This interface define the csv refider method abstraction.
 * 
 * @author Pap Gergely
 */
public interface CsvStruct<T> {
    public void setHeader(String[] header);
    public T createStruct(List<String> splittedRawData);
}
