package com.example;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testAddPerformance() {
        List<Integer> list = new ArrayList<>();
        long time = Main.testAdd(list, 1000);
        assertTrue(time >= 0);
    }

    @Test
    public void testGetPerformance() {
        List<Integer> list = new ArrayList<>();
        Main.testAdd(list, 1000);
        long time = Main.testGet(list, 1000);
        assertTrue(time >= 0);
    }

    @Test
    public void testDeletePerformance() {
        List<Integer> list = new ArrayList<>();
        Main.testAdd(list, 1000);
        long time = Main.testDelete(list, 1000);
        assertTrue(time >= 0);
    }
}