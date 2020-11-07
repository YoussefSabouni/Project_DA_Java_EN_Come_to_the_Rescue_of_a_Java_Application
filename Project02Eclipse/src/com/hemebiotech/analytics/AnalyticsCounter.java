package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    public static void main(String[] args) throws Exception {

        // Exception handling and resource auto-closure with try-with-resources.
        try (FileWriter writer = new FileWriter("result.out")) {

            ISymptomReader symptomsFile = new ReadSymptomDataFromFile("symptoms.txt");

            // Extracts the list of all symptoms from the file.
            List<String> symptoms = symptomsFile.getSymptoms();

            Map<String, Integer> symptomsCounted = countAndSortSymptoms(symptoms);

            IFileWriter outputFile = new WriteSymptomDataToFile("result.out");

            outputFile.writeMapToFile(symptomsCounted);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @param symptoms
     * @return
     */
    private static Map<String, Integer> countAndSortSymptoms(List<String> symptoms) {

        Map<String, Integer> symptomsCounted = new TreeMap<>();

        // Loop for each symptom of the list.
        symptoms.forEach(symptom -> symptomsCounted.put(symptom, symptomsCounted.getOrDefault(symptom, 0) + 1));

        return symptomsCounted;
    }
}
