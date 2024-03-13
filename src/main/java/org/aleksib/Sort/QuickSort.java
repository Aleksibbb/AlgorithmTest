package org.aleksib.Sort;

/**
 * 手撕快排
 */
public class QuickSort {
    public static void main(){
        int[] arr = {2, 3, 8, 1, 4, 9, 10, 7, 16, 14};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 快速排序
     * @param arr：待排序数组
     * @param start：起始下标
     * @param end：终点下标
     */
    public static void quickSort(int[] arr, int start, int end){	//start = 0, end = arr.length - 1
        //1. 递归的终止条件
        if(start >= end)	return;
        //2. 选定中心轴
        int left = start, right = end;
        int pivot = arr[left];
        while(left < right){
            //2.1 右指针 >= pivot
            while(left < right && arr[right] >= pivot)	right--;
            if(left < right){	// 证明此时 arr[right] < pivot
                arr[left] = arr[right];
                left++;
            }
            //2.2 左指针 <= pivot
            while(left < right && arr[left] <= pivot)	left++;
            if(left < right){	// 证明此时 arr[left] > pivot
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = pivot;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

}
