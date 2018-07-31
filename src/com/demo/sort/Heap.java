package com.demo.sort;

import com.demo.util.CommonUtil;

public class Heap {

    private void rebuildHeap(int [] list, int parent, int size) {

        //temp保存当前父节点
        int temp = list[parent];

        //获取左子树
        int child = 2 * parent + 1;

        while (child < size) {

            //如果有右子树结点，并且右子树结点的值大于左子树结点，则选取右子树结点
            if (child + 1 < size && list[child] < list[child + 1]) {
                child++;
            }

            //如果父结点的值已经大于子结点的值，则直接结束
            if (temp >= list[child]) {
                break;
            }

            //把子结点的值赋给父结点
            list[parent] = list[child];

            //选取子结点的左子树结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }

        list[parent] = temp;
    }

    private void heapSort(int [] list) {
        int size = list.length;

        //循环建立初始堆
        for (int i = size / 2; i >= 0; i--) {
            rebuildHeap(list, i, size);
        }

        //进行n-1次循环，完成排序
        for (int i = size - 1; i > 0; i--) {

            //最后一个元素和第一元素进行交换
            int temp = 0;
            temp = list[i];
            list[i] = list[0];
            list[0] = temp;

            //筛选 R[0] 结点，得到i-1个结点的堆
            rebuildHeap(list, 0, i);

            System.out.format("第%d趟:\t", size - i);
            CommonUtil.printPart(list, 0, size - 1);
        }
    }

    public static void main(String [] args) {
        int[] array = {9,1,2,5,7,4,8,6,3,0};

        Heap heap = new Heap();
        System.out.print("排序前:\t");
        CommonUtil.printPart(array, 0, array.length - 1);

        heap.heapSort(array);

        System.out.print("排序后:\t");
        CommonUtil.printPart(array, 0, array.length - 1);
    }
}
