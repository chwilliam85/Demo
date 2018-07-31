package com.demo.sort;

import com.demo.util.CommonUtil;

/**
 * 冒泡排序
 */
public class Bubble {

    private static void bubbleSort1(int [] list) {

        //用来交换的临时数
        int temp = 0;
        int size = list.length;

        //排序顺序不一样，结果一样
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
            System.out.format("第%d次：\t", i);
            CommonUtil.printPart(list, 0, list.length - 1);
        }
    }

    private static void bubbleSort1_1(int [] list) {

        //用来交换的临时数
        int temp = 0;
        int size = list.length;

        //排序标识
        boolean changed = true;

        //排序顺序不一样，结果一样
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                    changed = false;
                }
            }

            //如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
            if (changed) {
                break;
            }

            System.out.format("第%d次：\t", i);
            CommonUtil.printPart(list, 0, size - 1);
        }
    }

    private static void bubbleSort1_2(int [] list) {

        //用来交换的临时数
        int temp = 0;
        int size = list.length;

        //排序标识
        boolean changed = true;
        int lastChangedIndex = 0;
        int sortBorder = list.length - 1;

        //排序顺序不一样，结果一样
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < sortBorder; j++) {
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                    changed = false;

                    lastChangedIndex = j;
                }
            }

            sortBorder = lastChangedIndex;

            //如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
            if (changed) {
                break;
            }

            System.out.format("第%d次：\t", i);
            CommonUtil.printPart(list, 0, size - 1);
        }
    }

    private static void bubbleSort2(int [] list) {

        //用来交换的临时数
        int temp = 0;
        int size = list.length - 1;

        //外循环控制遍历次数
        for (int i = 0; i < size; i++) {

            //从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = size; j > i; j --) {

                //比较相邻的元素，如果后面的数大于前面的数，则交换
                if (list[j] < list[j - 1]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }
            System.out.format("第%d次：\t", i);
            CommonUtil.printPart(list);
        }
    }

    /**
     * 冒泡排序优化版
     * @param list 数据集合
     */
    private static void bubbleSort2_1(int [] list) {
        int temp = 0;
        int size = list.length - 1;

        //排序标识
        boolean changed = false;

        for (int i = 0; i < size; i++) {
            for (int j = size; j > i; j--) {
                if (list[j] < list[j - 1]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    changed = true;
                }
            }

            //如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
            if (!changed) {
                break;
            }
            System.out.format("第%d次：\t", i);
            CommonUtil.printPart(list);
        }
    }

    public static void main(String [] args) {
        int array [] = {5,8,6,3,9,2,1,7};

        System.out.print("排序前：\t");
        CommonUtil.printPart(array);

        Bubble.bubbleSort1_2(array);
        System.out.print("排序后：\t");
        CommonUtil.printPart(array);

    }
}
