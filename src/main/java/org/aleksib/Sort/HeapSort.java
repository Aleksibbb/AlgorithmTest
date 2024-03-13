package org.aleksib.Sort;

/**
 * 手撕堆排序
 */
public class HeapSort {
    public static void main(){
        int[] arr = {2, 3, 8, 1, 4, 9, 10, 7, 16, 14};
        heapSort(arr, 10);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 维护堆的性质
     * @param arr 存储堆元素的数组
     * @param n   数组长度
     * @param i   待维护节点的下标
     */
    public static void heapify(int[] arr, int n, int i){
        int largest = i;
        int leftSon = 2*i + 1;
        int rightSon = 2*i + 2;
        if(leftSon < n && arr[largest] < arr[leftSon]) largest = leftSon;
        if(rightSon < n && arr[largest] < arr[rightSon]) largest = rightSon;
        if(largest != i){
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    /**
     * 堆排序
     * @param arr 存储堆元素的数组
     * @param n   数组长度
     */
    public static void heapSort(int[] arr, int n){
        //1. 建堆
        for(int i = n/2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }
        //2. 堆排序
        for(int i = n - 1; i > 0; i--){
            swap(arr, i, 0);
            heapify(arr, i, 0);        // 这里传入的数组元素长度必须为i，因为在排序过程中，需要维护的数组长度是变小的
        }
    }

    public static void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
