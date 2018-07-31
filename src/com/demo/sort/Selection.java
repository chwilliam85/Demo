package com.demo.sort;

import com.demo.util.CommonUtil;

/**
 * 选择排序
 */
public class Selection {

    private static void selectionSort(int [] list) {
        int size = list.length;

        //需要遍历获得最小值的次数（要注意一点，当要排序 N 个数，已经经过 N-1 次遍历后，已经是有序数列）
        for (int i = 0; i < size - 1; i++) {
            int temp = 0, index = i;    //用来保存最小值的索引

            //寻找第i个小的数值
            for (int j = i + 1; j < list.length; j++) {
                if (list[index] > list[j]) {
                    index = j;
                }
            }

            //将找到的第i个小的数值放在第i个位置上
            temp = list[index];
            list[index] = list[i];
            list[i] = temp;

            System.out.format("第 %d 趟:\t", i + 1);
            CommonUtil.printPart(list);
        }
    }

    public static void main(String [] args) {
        int[] array = {9,1,2,5,7,4,8,6,3,5};

        System.out.print("排序前：\t");
        CommonUtil.printPart(array);

        Selection.selectionSort(array);
        System.out.print("排序后：\t");
        CommonUtil.printPart(array);
    }

}
