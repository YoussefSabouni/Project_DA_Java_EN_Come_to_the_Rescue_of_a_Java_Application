package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {

    public static void main(String[] args) throws Exception {

        // Exception handling and resource auto-closure with try-with-resources.
        try (FileWriter writer = new FileWriter("result.out")) {

            ReadSymptomDataFromFile symptomsFile = new ReadSymptomDataFromFile("symptoms.txt");

            // Extracts the list of all symptoms from the file.
            List<String> symptomsRecovered = symptomsFile.getSymptoms();

            // Deduplication of the list of recovered symptoms.
            Set<String> symptoms = new HashSet<>(symptomsRecovered);

            Map<String, Integer> symptomsCounted = new HashMap<>();

            symptoms.forEach(item -> symptomsCounted.put(item, 0));

            // Playback loop for each line of the file.
            symptomsRecovered.forEach(item -> symptomsCounted.put(item, symptomsCounted.get(item) + 1));

            // Insert count by symptom in the file result.out
            for (Map.Entry<String, Integer> symptomCounted : symptomsCounted.entrySet()) {
                writer.write(symptomCounted.getKey() + ": " + symptomCounted.getValue() + "\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
