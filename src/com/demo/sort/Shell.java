package com.demo.sort;

import com.demo.util.CommonUtil;

/**
 * Shell排序
 */
public class Shell {

    private static void shellSort(int[] list) {
        int size = list.length;
        int gap = size / 2;

        while (1 <= gap) {

            //把距离为 gap 的元素编为一个组，扫描所有组
            for (int i = gap; i < size; i++) {
                int j = 0;
                int temp = list[i];

                //对距离为 gap 的元素组进行排序
                for (j = i - gap; j >= 0 && temp < list[j]; j = j - gap) {
                    list[j + gap] = list[j];
                }
                list[j + gap] = temp;
            }
            System.out.format("gap=%d:\t", gap);
            CommonUtil.printPart(list);

            //减小增量
            gap = gap / 2;

        }
    }

    public static void main(String[] args) {
        int[] array = {9,1,2,5,7,4,8,6,3,5};

        System.out.print("排序前：\t");
        CommonUtil.printPart(array);

        Shell.shellSort(array);
        System.out.print("排序后：\t");
        CommonUtil.printPart(array);
    }
}
