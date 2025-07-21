package zq.leetcode;

//https://leetcode.cn/problems/binary-search/description/
public class Leetcode704 {
//    704. 二分查找
    public static void main(String[] args) {
        /*给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
        你必须编写一个具有 O(log n) 时间复杂度的算法。
        示例 1:
        输入: nums = [-1,0,3,5,9,12], target = 9
        输出: 4
        解释: 9 出现在 nums 中并且下标为 4
        示例 2:
        输入: nums = [-1,0,3,5,9,12], target = 2
        输出: -1
        解释: 2 不存在 nums 中因此返回 -1*/

//        int[] nums = new int[]{-1,0,3,5,9,12};
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
//        int target = 2;
        System.out.println(new Leetcode704().search(nums,target));
    }
    //  二分查找
    public int search(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;
        int result = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid + 1;
            }

        }
        return result;
    }
}
