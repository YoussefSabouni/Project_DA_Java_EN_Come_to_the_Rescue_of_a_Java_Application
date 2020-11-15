package com.hemebiotech.analytics;

import com.hemebiotech.analytics.interfaces.IFileWriter;
import com.hemebiotech.analytics.interfaces.ISymptomReader;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private final ISymptomReader SYMPTOMS_READER;
    private final IFileWriter    OUTPUT_WRITER;

    /**
     * Builder to build the {@link AnalyticsCounter} class.
     *
     * @param inputFilePath
     *         Path of the input file.
     * @param outputFilePath
     *         Path of the output file.
     */
    public AnalyticsCounter(String inputFilePath, String outputFilePath) {

        this.SYMPTOMS_READER = new ReadSymptomDataFromFile(inputFilePath);
        this.OUTPUT_WRITER   = new WriteSymptomDataToFile(outputFilePath);
    }

    public static void main(String[] args) {

        String inputFilePath;
        String outFilePath;

        switch (args.length) {
            case 1:
                inputFilePath = args[0];
                outFilePath = "result.out";
                break;
            case 2:
                inputFilePath = args[0];
                outFilePath = args[1];
                break;
            default:
                inputFilePath = "symptoms.txt";
                outFilePath = "result.out";
        }

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(inputFilePath, outFilePath);
        analyticsCounter.run();
    }

    /**
     * Retrieve each {@link String} from a {@link List}, add it to a {@link Map} as a key in alphabetical order and add
     * the value 1 to it. If the value of the key already exists then the value of this key is incremented by 1.
     *
     * @param symptoms
     *         A list of all symptoms to count and sort
     *
     * @return a treemap containing the symptoms with their number of occurrences.
     */
    private static Map<String, Integer> countAndSortSymptoms(List<String> symptoms) {

        // keys in TreeMap are sorted using their natural order
        Map<String, Integer> symptomsCounted = new HashMap<>();

        // Creates a key in symptomsCounted and increments it by 1 at each occurrence..
        symptoms.forEach(symptom -> symptomsCounted.put(symptom, symptomsCounted.getOrDefault(symptom, 0) + 1));

        return symptomsCounted;
    }


    public List<String> listSorter(List<String> list) {

        Collections.sort(list);

        return list;
    }

    /**
     * Executes the count analysis process
     */
    public void run() {

        List<String> symptoms = this.SYMPTOMS_READER.getSymptoms();

        symptoms = listSorter(symptoms);

        Map<String, Integer> symptomsCounted = AnalyticsCounter.countAndSortSymptoms(symptoms);

        this.OUTPUT_WRITER.writeMapToFile(symptomsCounted);
    }


}
