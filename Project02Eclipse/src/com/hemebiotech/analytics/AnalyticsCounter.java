package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {

    private static int headacheCount     = 0;    // initialize to 0
    private static int rashCount         = 0;        // initialize to 0
    private static int pupilDilatedCount = 0;        // initialize to 0

    public static void main(String[] args) throws Exception {

        // Exception handling and resource auto-closure with try-with-resources.
        try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt")) ; FileWriter writer = new FileWriter("result.out")) {

            String line = reader.readLine();

            // Playback loop for each line of the file.
            while (line != null) {
                System.out.println("symptom from file: " + line);
                if (line.equals("headache")) {
                    headacheCount++;
                    System.out.println("number of headaches: " + headacheCount);
                } else if (line.equals("rash")) {
                    rashCount++;
                } else if (line.contains("pupils")) {
                    pupilDilatedCount++;
                }

                line = reader.readLine();    // get another symptom
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
