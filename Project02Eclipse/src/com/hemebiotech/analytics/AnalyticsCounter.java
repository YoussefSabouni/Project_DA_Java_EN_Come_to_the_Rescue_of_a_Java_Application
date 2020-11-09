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

    public static void main(String[] args) {

        ISymptomReader symptomsFile = new ReadSymptomDataFromFile("symptoms.txt");

        // Extracts the list of all symptoms from the file.
        List<String> symptoms = symptomsFile.getSymptoms();

        AnalyticsCounter counter = new AnalyticsCounter();

        Map<String, Integer> symptomsCounted = counter.countAndSortSymptoms(symptoms);

        IFileWriter outputFile = new WriteSymptomDataToFile("result.out");

        outputFile.writeMapToFile(symptomsCounted);

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
    private Map<String, Integer> countAndSortSymptoms(List<String> symptoms) {

        Map<String, Integer> symptomsCounted = new TreeMap<>();

        // Creates a key in symptomsCounted and increments it by 1 at each occurrence..
        symptoms.forEach(symptom -> symptomsCounted.put(symptom, symptomsCounted.getOrDefault(symptom, 0) + 1));

        return symptomsCounted;
    }
}
