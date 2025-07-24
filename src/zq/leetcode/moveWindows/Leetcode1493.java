package zq.leetcode.moveWindows;

//https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/
public class Leetcode1493 {
    //1493. 删掉一个元素以后全为 1 的最长子数组
    public static void main(String[] args) {
        /*给你一个二进制数组 nums ，你需要从中删掉一个元素。
        请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
        如果不存在这样的子数组，请返回 0
        提示 1：
        输入：nums = [1,1,0,1]
        输出：3
        解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
        示例 2：
        输入：nums = [0,1,1,1,0,1,1,0,1]
        输出：5
        解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
        示例 3：
        输入：nums = [1,1,1]
        输出：2
        解释：你必须要删除一个元素。*/

//        int[] nums = new int[]{1,1,0,1};
//        int[] nums = new int[]{0,1,1,1,0,1,1,0,1};
        int[] nums = new int[]{1,1,1};
        System.out.println(new Leetcode1493().longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int result = 0;
        int zeroCount = 0;
        int left = 0;
        int right = 0;
        int oneCount = 0;
        while(right < nums.length){

            if(nums[right] == 0){
                zeroCount++;
            }
            if(nums[right] == 1){
                oneCount++;
            }
            while(zeroCount >= 2){
                if(nums[left] == 0){
                    zeroCount--;
                }
                if(nums[left] == 1){
                    oneCount--;
                }
                left ++;
            }
            result = result > oneCount ? result : oneCount;
            right++;
        }

        return zeroCount == 0 ? result - 1 : result;

    }


}
