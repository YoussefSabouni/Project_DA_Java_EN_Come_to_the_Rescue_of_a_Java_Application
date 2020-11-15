package com.hemebiotech.analytics.tools;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Takes care of all aspects of symptom management such as ordering and counting.
 */
public class SymptomsManagement {

    /**
     * Retrieve each {@link String} from a {@link List}, add it to a {@link Map} as a key and add as the value 1. If the
     * value of the key already exists, then the value of this key is incremented by 1.
     *
     * @param symptoms
     *         A list of all symptoms to count.
     *
     * @return a hashMap containing the symptoms with their number of occurrences.
     */
    public static Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> symptomsCounted = new HashMap<>();

        // Creates a key in symptomsCounted and increments it by 1 at each occurrence..
        symptoms.forEach(symptom -> symptomsCounted.put(symptom, symptomsCounted.getOrDefault(symptom, 0) + 1));

        return symptomsCounted;
    }

    /**
     * Take a {@link Map} as a parameter and arrange its keys in alphabetical order.
     *
     * @param symptoms
     *         A hashmap of symptoms to be sorted in alphabetical order
     *
     * @return a linkedHashMap with the keys arranged in alphabetical order.
     */
    public static Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

        symptoms = symptoms.entrySet()
                           .stream()
                           .sorted(Map.Entry.comparingByKey())
                           .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return symptoms;
    }
}
