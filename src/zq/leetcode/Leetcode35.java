package zq.leetcode;

//https://leetcode.cn/problems/search-insert-position/
public class Leetcode35 {
//    35. 搜索插入位置
    public static void main(String[] args) {
        /*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        请必须使用时间复杂度为 O(log n) 的算法。

        示例 1:
        输入: nums = [1,3,5,6], target  = 5
        输出: 2
        示例 2:
        输入: nums = [1,3,5,6], target = 2
        输出: 1
        示例 3:
        输入: nums = [1,3,5,6], target = 7
        输出: 4    */
        int[] nums1 = new int[]{1,3,5,6};
        int target1 = 5;
        int target2 = 2;
        int target3 = 7;

        System.out.println(new Leetcode35().searchInsert(nums1,target3));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        if (target > nums[right-1]){
            return right;
        }
        while(left <= right){
            int mid = left + (right-left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return left;
    }
}
