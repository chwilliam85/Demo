package com.demo.util;

import java.util.HashSet;

public class CommonUtil {

    public static void printPart(int [] list) {
        for (int v : list) {
            System.out.print(v + "\t");
        }
        System.out.println();
    }

    public static void printPart(int [] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();

        HashSet set = new HashSet();
    }
}
