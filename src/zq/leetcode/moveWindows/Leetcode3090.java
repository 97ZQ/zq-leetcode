package zq.leetcode.moveWindows;
//https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/
public class Leetcode3090 {
    //    3090. 每个字符最多出现两次的最长子字符串
    public static void main(String[] args) {
        /*给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。
        示例 1：
        输入： s = "bcbbbcba"
        输出： 4
        解释：
        以下子字符串长度为 4，并且每个字符最多出现两次："bcbbbcba"。
        示例 2：
        输入： s = "aaaa"
        输出： 2
        解释：
        以下子字符串长度为 2，并且每个字符最多出现两次："aaaa"。*/
//        String s = "bcbbbcba";
        String s = "aaaa";
        System.out.println(new Leetcode3090().maximumLengthSubstring(s));
    }
    public int maximumLengthSubstring(String s) {
        int result = 0;
        char[] arr = s.toCharArray();
        int[] cnt = new int[128];
        int left = 0;
        int right = 0;
        while(right < arr.length){
            char c = arr[right];
            cnt[c] ++;
            while(cnt[c] > 2 ){
                cnt[arr[left]]--;
                left ++;
            }
            result = Math.max(result,right-left+1);
            right ++;
        }
        return result;

    }
}

