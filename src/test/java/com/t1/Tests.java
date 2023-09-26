package com.t1;

import com.t1.controllers.TaskController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Anna Ermachenkova
 */
@SpringBootTest
class Tests {
    @Autowired
    private TaskController taskController;

    @Test
    void testGetFrequencyOfMeetingCharacters() {
        Map<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('f', 2);
        expectedMap.put('b', 2);
        expectedMap.put('c', 1);
        expectedMap.put('d', 5);

        ResponseEntity<?> actualResponse = taskController.getFrequencyOfMeetingCharacters("ffbbcddddd");

        assertEquals(expectedMap, actualResponse.getBody());
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
    }

    @Test
    void testGetEmptyString() {
        ResponseEntity<?> actualResponse = taskController.getFrequencyOfMeetingCharacters("");
        assertEquals(HttpStatus.BAD_REQUEST, actualResponse.getStatusCode());
    }
}