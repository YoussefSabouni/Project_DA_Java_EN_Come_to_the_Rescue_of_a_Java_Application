package com.hemebiotech.analytics.interfaces;

import java.util.Map;

/**
 * This interface contains everything you need to write symptoms to a file, from input data, an output file will be
 * generated.
 */
public interface IFileWriter {

    /**
     * Create a output file in which a list of string is saved toString line by line. If the file already exists, it
     * will be overwritten.
     *
     * @param map The input map to be written to the file
     */
    void writeMapToFile(Map<String, Integer> map);
}
