package zq.leetcode;
// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class Leetcode34 {
    /*给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
    如果数组中不存在目标值 target，返回 [-1, -1]。
    你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

    示例 1：
    输入：nums = [5,7,7,8,8,10], target = 8
    输出：[3,4]
    示例 2：
    输入：nums = [5,7,7,8,8,10], target = 6
    输出：[-1,-1]
    示例 3：
    输入：nums = [], target = 0
    输出：[-1,-1]*/
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int start = getResult(nums,target);
        if(nums[start] != target){
            return result;
        }
        int end = getResult(nums,target+1)-1;

        result[0] = start;
        result[1] = end;
        return result;
    }
    public int getResult(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left +(right -left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
