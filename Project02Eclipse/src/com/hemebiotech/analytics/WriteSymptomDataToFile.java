package com.hemebiotech.analytics;

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
     */
    public WriteSymptomDataToFile(String filePath) {

        this.filePath = filePath;
    }

    /**
     * @param symptomsCounted
     */
    @Override
    public void writeMapToFile(Map<String, Integer> symptomsCounted) {

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
