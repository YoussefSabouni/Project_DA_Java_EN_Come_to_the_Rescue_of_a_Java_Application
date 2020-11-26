package com.hemebiotech.analytics.interfaces;

import java.util.List;
import java.util.Map;

/**
 * This interface contains everything you need to write symptoms to a file, from input data, an output file will be
 * generated.
 */
public interface IFileWriter {

    /**
     * Create a output file in which a {@link List} of string is saved to String line by line. If the file already
     * exists, it will be overwritten.
     *
     * @param map
     *         The input {@link Map} to be written to the file
     */
    void writeMapToFile(Map<String, Integer> map);
}
