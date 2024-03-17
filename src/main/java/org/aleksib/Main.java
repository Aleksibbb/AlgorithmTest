package org.aleksib;

import org.aleksib.GetMaxNum.GetMaxNum1;
import org.aleksib.Sort.HeapSort;
import org.aleksib.Sort.MergeSort;
import org.aleksib.Sort.QuickSort;

public class Main {
    public static void main(String[] args) {
        // 3.13 小于 N 的最大数
//        GetMaxNum1.main();
        // 堆排序
        HeapSort.main();
        // 快排
        QuickSort.main();
        // 归并排序
        MergeSort.main();
    }
}