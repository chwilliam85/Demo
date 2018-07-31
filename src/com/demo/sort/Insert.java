package com.demo.sort;

import com.demo.util.CommonUtil;

import java.util.Random;

public class Insert {

    private static void insertSort(int [] list) {
        int size = list.length;

        System.out.format("i=%d:\t", 0);
        CommonUtil.printPart(list, 0, 0);

        //从第2个数开始遍历，依次插入有序序列
        for (int i = 1; i < size; i++) {
            int j = 0;

            //取出第i个数，和前i-1个数比较后，插入合适位置
            int temp = list[i];

            //因为前i-1个数都是从小到大的有序序列，所以只要当前比较的数(list[j])比temp大，就把这个数后移一位
            for (j = i - 1; j >= 0 && temp < list[j]; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = temp;

            System.out.format("i=%d:\t", i);
            CommonUtil.printPart(list, 0, i);
        }
    }

    public static void main(String [] args) {
        final int MAX_SIZE = 10;
        int [] array = new int[MAX_SIZE];

        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i ++) {
            array[i] = random.nextInt(MAX_SIZE);
        }

//        int array [] = {9,1,6,5,2,4,3,7,8,0};

        System.out.print("排序前：\t");
        CommonUtil.printPart(array, 0, array.length - 1);

        Insert.insertSort(array);

        System.out.print("排序后：\t");
        CommonUtil.printPart(array, 0, array.length - 1);
    }
}
