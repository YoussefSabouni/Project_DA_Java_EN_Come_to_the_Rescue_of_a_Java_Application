package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * AnalyticsCouter is the entry point of the program, it retrieves an input .txt file containing side effects (one side
 * effect per line).
 * <p>
 * It sorts these side effects, counts them, and sorts them in alphabetical order. The result is then written to an
 * output .out file.
 *
 * @version 1.1
 */
public class AnalyticsCounter {

    private final ISymptomReader SIMPTOMS_FILE;
    private final IFileWriter    OUTPUT_FILE;

    /**
     * @param inputFilePath
     *         Path of the input file.
     * @param outputFilePath
     *         Path of the output file.
     */
    public AnalyticsCounter(String inputFilePath, String outputFilePath) {

        this.SIMPTOMS_FILE = new ReadSymptomDataFromFile(inputFilePath);
        this.OUTPUT_FILE   = new WriteSymptomDataToFile(outputFilePath);
        run();
    }

    public static void main(String[] args) {

        //        String inputFilePath  = JOptionPane.showInputDialog(null, "Please enter the full path of the file .txt to be scanned./n Example: C:/desktop/symptomps.txt");
        //        String outputFilePath = String.format(JOptionPane.showInputDialog(null, "Enter the path where you want to save the output file.") + "/%s", "result.out");

        new AnalyticsCounter("symptoms.txt", "result.out");

    }

    /**
     * Retrieve each String from a list, add it to a Map as a key in alphabetical order and add the value 1 to it. If
     * the value of the key already exists then the value of this key is incremented by 1.
     *
     * @param symptoms
     *         A list of all symptoms to count and sort
     *
     * @return a treemap containing the symptoms with their number of occurrences.
     */
    private static Map<String, Integer> countAndSortSymptoms(List<String> symptoms) {

        Map<String, Integer> symptomsCounted = new TreeMap<>();

        // Creates a key in symptomsCounted and increments it by 1 at each occurrence..
        symptoms.forEach(symptom -> symptomsCounted.put(symptom, symptomsCounted.getOrDefault(symptom, 0) + 1));

        return symptomsCounted;
    }

    public void run() {
        // Extracts the list of all symptoms from the file.
        List<String> symptoms = this.SIMPTOMS_FILE.getSymptoms();

        Map<String, Integer> symptomsCounted = AnalyticsCounter.countAndSortSymptoms(symptoms);

        this.OUTPUT_FILE.writeMapToFile(symptomsCounted);
    }
}
