package com.hemebiotech.analytics;

import com.hemebiotech.analytics.interfaces.IFileWriter;
import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.tools.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.tools.SymptomsManagement;
import com.hemebiotech.analytics.tools.WriteSymptomDataToFile;

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
     * Executes the count analysis process
     */
    public void run() {

        List<String> symptoms = this.SYMPTOMS_READER.getSymptoms();

        Map<String, Integer> symptomsCounted = SymptomsManagement.countSymptoms(symptoms);

        symptomsCounted = SymptomsManagement.sortSymptoms(symptomsCounted);

        this.OUTPUT_WRITER.writeMapToFile(symptomsCounted);
    }


}
