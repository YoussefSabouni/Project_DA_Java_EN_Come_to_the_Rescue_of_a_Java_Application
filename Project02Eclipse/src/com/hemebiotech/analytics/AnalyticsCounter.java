package com.hemebiotech.analytics;

import com.hemebiotech.analytics.interfaces.IFileWriter;
import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.tools.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.tools.SymptomsManagement;
import com.hemebiotech.analytics.tools.WriteSymptomDataToFile;

import javax.swing.*;
import java.io.File;
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
    public AnalyticsCounter(File inputFilePath, String outputFilePath) {

        this.SYMPTOMS_READER = new ReadSymptomDataFromFile(inputFilePath);
        this.OUTPUT_WRITER   = new WriteSymptomDataToFile(outputFilePath);
    }

    public static void main(String[] args) {

        File   inputFilePath = null;
        String outFilePath   = "result.out";

        JOptionPane.showMessageDialog(null, "Welcome to the Analytics Counter application.\n" + "\n" + "Please prepare a text file for the symptom count.");

        JFileChooser selectFile = new JFileChooser();
        selectFile.setMultiSelectionEnabled(false);
        selectFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
        selectFile.showDialog(null, "Analyze");
        inputFilePath = selectFile.getSelectedFile();

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(inputFilePath, outFilePath);
        analyticsCounter.run();

        JOptionPane.showMessageDialog(null, "The analysis is complete.");

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
