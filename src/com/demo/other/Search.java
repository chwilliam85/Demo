package com.demo.other;

public class Search {

    private static int orderSearch(int [] list, int key) {

        for (int i : list) {
            if (i == key) {
                return i;
            }
        }

        return 0;
    }

    private static int binarySearch(int [] list, int key) {
        int low = 0, mid = 0, high = list.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (list[mid] == key) {
                return mid;
            } else if (list[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String [] args) {
        int [] array = {2,1,6,8,5};

        System.out.println(Search.orderSearch(array, 6));
        System.out.println(Search.binarySearch(array, 8));
    }
}
