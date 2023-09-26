package com.t1.services;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Anna Ermachenkova
 */
@Service
public class TaskService {
    public Map<Character, Integer> getFrequencyOfMeetingCharacters(String input) {
        Map<Character, Integer> outputMap = new HashMap<>();

        for (char character : input.toCharArray()) {
            outputMap.put(character, outputMap.getOrDefault(character, 0) + 1);
        }

        return outputMap
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
    }
}
