package org.aleksib.GetMaxNum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 给定数组`nums`、目标数`target`，求由数组里的数组成的小于目标数的最大值
 * 例如：`nums = [1, 3, 7]`，`target = 2255`，输出 `1777`
 */
public class GetMaxNum {
    static int res = 0;
    static List<Integer> path = new ArrayList<>();
    // main方法输入
    public static void main(){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组的长度");
        int size = in.nextInt();
        int[] nums = new int[size];
        for(int i = 0; i < size; i++){
            System.out.println("请输入第" + i + "个元素");
            nums[i] = in.nextInt();
        }
        System.out.println("请输入目标数");
        int target = in.nextInt();
        System.out.println(getMaxNum(nums, target));
    }
    // 获取最大数字
    public static int getMaxNum(int[] nums, int n){
        // 1. 将数组倒序排列
        nums = IntStream.of(nums)
                .boxed()
                .sorted((a, b) -> Math.abs(b) - Math.abs(a))
                .mapToInt(Integer::intValue)
                .toArray();
        // 2. 将 n 转换为字符串
        String str = String.valueOf(n);
        // 3. 判断是否找到了最小数
        boolean isFound = backTrack(nums, str, true);
        // 4. 没找到，则每位数字都是nums[0]，位数比目标数少1
        if(!isFound){
            for(int i = 0; i < str.length() - 1; i++){
                res = res * 10 + nums[i];
            }
        }
        return res;
    }
    // 回溯：str（目标数的字符串表示） isEqual：上一位数字是否相等
    public static boolean backTrack(int[] nums, String str, boolean isEqual){
        // 终止条件：当path集合的元素个数 == 目标数的数字位数
        if(path.size() == str.length()){
            long pathSum = 0;
            for(int num : path)	pathSum = pathSum * 10 + num;
            // 找到了小于目标数的最大数
            if(pathSum < Integer.parseInt(str)){
                res = (int) pathSum;
                return true;
            }
            return false;
        }

        for(int i = 0; i < nums.length; i++){
            // 上一位数相等 && 本位数大,直接剪枝
            if(nums[i] > (str.charAt(path.size()) - '0') && isEqual)	continue;
            path.add(nums[i]);
            if(backTrack(nums, str, (str.charAt(path.size() - 1) - '0') == nums[i]))	return true;
            path.remove(path.size() - 1);
        }
        return false;
    }
}
