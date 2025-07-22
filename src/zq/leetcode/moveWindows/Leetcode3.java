package zq.leetcode.moveWindows;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
public class Leetcode3 {
    //    3. 无重复字符的最长子串
    public static void main(String[] args) {
        /*给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
        示例 1:
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:
        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:
        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/
//        String s=  "abcabcbb";
//        String s = "bbbbb";
        String s = "pwwkew";
        System.out.println(new Leetcode3().lengthOfLongestSubstring2(s));
    }
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int result = 0;
        Set<Character> hashSet = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < length){
            char c = s.charAt(right);
            while (hashSet.contains(c)){
                hashSet.remove(s.charAt(left));
                left ++;
            }
            hashSet.add(s.charAt(right));
            int size = hashSet.size();
            result = size > result ? size : result;
            right ++;
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s){
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        int[] set = new int[128];
        int result = 0;
        while(right < arr.length){
            char c = arr[right];
            set[c]++;
            while(set[c] > 1){
                set[arr[left]]--;
                left++;
            }
            result = result > right - left + 1 ? result : right - left + 1;
            right ++;
        }

        return result;
    }

}
