package com.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int numOperations = 100000;

        System.out.println("Testing ArrayList...");
        runTests(new ArrayList<>(), numOperations);

        System.out.println("\nTesting LinkedList...");
        runTests(new LinkedList<>(), numOperations);
    }

    public static void runTests(List<Integer> list, int numOps) {
        long addTime = testAdd(list, numOps);
        long getTime = testGet(list, numOps);
        long deleteTime = testDelete(list, numOps);

        System.out.printf("%-10s | %-15s | %-15s\n", "Method", "Operations", "Time (ms)");
        System.out.println("---------------------------------------------");
        System.out.printf("%-10s | %-15d | %-15d\n", "add", numOps, addTime);
        System.out.printf("%-10s | %-15d | %-15d\n", "get", numOps, getTime);
        System.out.printf("%-10s | %-15d | %-15d\n", "delete", numOps, deleteTime);
    }

    public static long testAdd(List<Integer> list, int numOps) {
        list.clear();
        long start = System.currentTimeMillis();
        for (int i = 0; i < numOps; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - start;
    }

    public static long testGet(List<Integer> list, int numOps) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < numOps; i++) {
            list.get(i);
        }
        return System.currentTimeMillis() - start;
    }

    public static long testDelete(List<Integer> list, int numOps) {
        long start = System.currentTimeMillis();
        for (int i = numOps - 1; i >= 0; i--) {
            list.remove(i);
        }
        return System.currentTimeMillis() - start;
    }
}