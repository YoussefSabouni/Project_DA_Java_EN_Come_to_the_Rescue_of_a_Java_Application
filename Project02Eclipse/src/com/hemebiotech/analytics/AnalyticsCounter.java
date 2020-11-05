package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

    public static void main(String[] args) throws Exception {

        // Exception handling and resource auto-closure with try-with-resources.
        try (FileWriter writer = new FileWriter("result.out")) {

            ReadSymptomDataFromFile symptomsFile = new ReadSymptomDataFromFile("symptoms.txt");

            // Extracts the list of all symptoms from the file.
            List<String> symptoms = symptomsFile.getSymptoms();

            Map<String, Integer> symptomsCounted = new HashMap<>();

            // Loop for each symptom of the list.
            symptoms.forEach(symptom -> symptomsCounted.put(symptom, symptomsCounted.getOrDefault(symptom, 0) + 1));

            // Insert count by symptom in the file result.out
            symptomsCounted.forEach((symptom, count) -> {
                // I do a try/catch again because it is not "shared" with the lambdas.
                try {
                    writer.write(symptom + ": " + count + "\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
