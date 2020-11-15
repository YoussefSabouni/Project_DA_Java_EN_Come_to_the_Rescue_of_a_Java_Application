package com.hemebiotech.analytics;

import com.hemebiotech.analytics.interfaces.IFileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 *
 */
public class WriteSymptomDataToFile implements IFileWriter {

    private final String filePath;

    /**
     * @param filePath
     *         Location of the file to be created or modified
     */
    public WriteSymptomDataToFile(String filePath) {

        this.filePath = filePath;
    }


    /**
     * Create a output file in which a list of string is saved toString line by line. If the file already exists, it
     * will be overwritten.
     *
     * @param symptomsCounted
     *         The input map to be written to the file
     */
    @Override
    public void writeMapToFile(Map<String, Integer> symptomsCounted) {

        // Exception handling and resource auto-closure with try-with-resources.
        try (FileWriter writer = new FileWriter(this.filePath)) {

            // Insert count by symptom in the file result.out
            symptomsCounted.forEach((symptom, count) -> {
                // I do a try/catch again because it is not "shared" with the lambdas.
                try {
                    writer.write(symptom + ": " + count + "\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
