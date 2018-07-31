package com.demo.sort;

import com.demo.util.CommonUtil;

/**
 * 归并排序
 */
public class Merge {

    private void division(int [] list, int low, int mid, int high) {

        //第一段序列的下标
        int first = low;

        //第二段序列的下标
        int second = mid + 1;

        //临时存放合并序列的下标
        int temp = 0;

        //临时合并序列
        int [] array = new int[high - low + 1];

        //扫描第一段和第二段序列，直到有一个扫描结束
        while (first <= mid && second <= high) {

            //判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (list[first] <= list[second]) {
                array[temp] = list[first];
                first++;
                temp++;
            } else {
                array[temp] = list[second];
                second++;
                temp++;
            }
        }

        //若第一段序列还没扫描完，将其全部复制到合并序列
        while (first <= mid) {
            array[temp] = list[first];
            first++;
            temp++;
        }

        //若第二段序列还没扫描完，将其全部复制到合并序列
        while (second <= high) {
            array[temp] = list[second];
            second++;
            temp++;
        }

        //将合并序列复制到原始序列中
        for (temp = 0, first = low; first <= high; first++, temp++) {
            list[first] = array[temp];
        }
    }

    private void merge(int [] list, int gap, int length) {
        int i = 0;

        //归并 i 长度的两个相邻子表
        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
            division(list, i, i + gap - 1, i + 2 * gap - 1);
        }

        //余下两个子表，后者长度小于 i
        if (i + gap - 1 < length) {
            division(list, i, i + gap - 1, length -  1);
        }
    }

    private void mergeSort(int [] list) {
        int size = list.length;
        for (int i = 1; i < size; i = i * 2) {
            merge(list, i, size);
            System.out.format("第 %d 次遍历:\t", i);
            CommonUtil.printPart(list);
        }
    }

    public static void main(String [] args) {
        int array [] = {9,1,6,5,2,4,3,7,8,0};

        System.out.print("排序前：\t\t");
        CommonUtil.printPart(array);

        Merge merge = new Merge();
        merge.mergeSort(array);

        System.out.print("排序后：\t\t");
        CommonUtil.printPart(array);
    }
}
