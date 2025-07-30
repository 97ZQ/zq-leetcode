package zq.leetcode.moveWindows;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.cn/problems/maximum-erasure-value/description/
public class Leetcode1695 {
//    1695. 删除子数组的最大得分
    public static void main(String[] args) {
        /*给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
        返回 只删除一个 子数组可获得的 最大得分 。
        如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
        示例 1：
        输入：nums = [4,2,4,5,6]
        输出：17
        解释：最优子数组是 [2,4,5,6]
        示例 2：
        输入：nums = [5,2,1,2,5,2,1,2,5]
        输出：8
        解释：最优子数组是 [5,2,1] 或 [1,2,5]*/
    }

    public int maximumUniqueSubarray(int[] nums) {
        int result = 0;
        int  left = 0;
        int temp = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right = 0; right < nums.length; right++){
            map.merge(nums[right],1,Integer::sum);
            temp += nums[right];
            while(map.get(nums[right]) > 1){
                map.merge(nums[left],-1,Integer::sum);
                temp -= nums[left];
                left++;
            }
            result = Math.max(result,temp);
        }

        return result;
    }

    public int maximumUniqueSubarray2(int[] nums) {
        int result = 0;
        int left = 0;
        int temp = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            while(set.contains(num)){
                set.remove(nums[left]);
                temp -= nums[left];
                left++;
            }
            set.add(num);
            temp+=num;
            result = Math.max(temp,result);
        }
        return result;
    }

    // 该数组比上述哈希表都快
    public int maximumUniqueSubarray3(int[] nums) {
        int result = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num,max);
        }
        boolean[] flags = new boolean[max + 1];
        int temp = 0;
        int left = 0;
        for (int num : nums) {
            while(flags[num] == true){
                temp -=nums[left];
                flags[nums[left]] = false;
                left++;
            }
            flags[num] = true;
            temp += num;
            result = Math.max(result,temp);
        }


        return result;
    }
}
