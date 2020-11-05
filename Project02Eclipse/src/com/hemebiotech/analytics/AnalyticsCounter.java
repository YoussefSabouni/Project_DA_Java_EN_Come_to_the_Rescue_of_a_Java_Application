package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {

    private static int headacheCount     = 0;    // initialize to 0
    private static int rashCount         = 0;        // initialize to 0
    private static int pupilDilatedCount = 0;        // initialize to 0

    public static void main(String[] args) throws Exception {

        // Exception handling and resource auto-closure with try-with-resources.
        try (FileWriter writer = new FileWriter("result.out")) {

            ReadSymptomDataFromFile symptomsFile = new ReadSymptomDataFromFile("symptoms.txt");

            // Extracts the list of all symptoms from the file.
            List<String> symptomsRecovered = symptomsFile.getSymptoms();

            // Deduplication of the list of recovered symptoms.
            Set<String> symptoms = new HashSet<>(symptomsRecovered);

            Map<String, Integer> map = new HashMap<>();

            symptoms.forEach(item -> map.put(item, 0));

            // Playback loop for each line of the file.
            symptomsRecovered.forEach(item -> map.put(item, map.get(item) + 1));

            // Insert count by symptom in the file result.out
            writer.write("headache: " + headacheCount + "\n");
            writer.write("rash: " + rashCount + "\n");
            writer.write("dilated pupils: " + pupilDilatedCount + "\n");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
