package org.aleksib.Sort;

/**
 * 手撕归并排序
 */
public class MergeSort {
    public static void main(){
        int[] arr = {2, 3, 8, 1, 4, 9, 10, 7, 16, 14};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    public static void mergeSort(int[] nums, int left, int right) {
        if(left >= right)	return;
        int mid = (left + right) / 2;	// 左数组包含mid
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);  // 此时的nums有序
    }
    // 归并
    public static void merge(int[] nums, int left, int mid, int right) {
        // 1. 先获取左、右子数组(注意：此时的子数组一定是有序的！！！)
        int n1 = mid-left+1;
        int n2 = right-mid;
        int[] leftNums = new int[n1];
        int[] rightNums = new int[n2];
        for(int i = 0; i < n1; i++)	leftNums[i] = nums[left + i];
        for(int j = 0; j < n2; j++)	rightNums[j] = nums[mid + 1 + j];
        // 2. 将左、右子数组进行归并。交叉放入nums
        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2) {
            if(leftNums[i] <= rightNums[j]) {
                nums[k++] = leftNums[i++];
            } else {
                nums[k++] = rightNums[j++];
            }
        }
        // 3. 将剩余子数组的元素合并到Nums
        while(i < n1)	nums[k++] = leftNums[i++];
        while(j < n2)	nums[k++] = rightNums[j++];
    }
}
