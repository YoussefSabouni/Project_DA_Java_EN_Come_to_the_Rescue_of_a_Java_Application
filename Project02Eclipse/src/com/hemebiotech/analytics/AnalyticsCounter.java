package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnalyticsCounter {

    private static int headacheCount     = 0;    // initialize to 0
    private static int rashCount         = 0;        // initialize to 0
    private static int pupilDilatedCount = 0;        // initialize to 0

    public static void main(String[] args) throws Exception {

        // Exception handling and resource auto-closure with try-with-resources.
        try (FileWriter writer = new FileWriter("result.out")) {

            ReadSymptomDataFromFile symptomsFile = new ReadSymptomDataFromFile("symptoms.txt");

            List<String> symptomsRecovered = symptomsFile.GetSymptoms();

            Set<String> symptoms = new HashSet<>(symptomsRecovered);

            // Playback loop for each line of the file.
            for (String symptom : symptomsRecovered) {
                System.out.println("symptom from file: " + symptom);
                if (symptom.equals("headache")) {
                    headacheCount++;
                    System.out.println("number of headaches: " + headacheCount);
                } else if (symptom.equals("rash")) {
                    rashCount++;
                } else if (symptom.contains("pupils")) {
                    pupilDilatedCount++;
                }
            }

            // Insert lines in the file result.out
            writer.write("headache: " + headacheCount + "\n");
            writer.write("rash: " + rashCount + "\n");
            writer.write("dilated pupils: " + pupilDilatedCount + "\n");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
