package zq.leetcode;

//  https://leetcode.cn/problems/grumpy-bookstore-owner/
public class Leetcode1052 {
//        1052. 爱生气的书店老板
    public static void main(String[] args) {
        /*有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，
        其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
        在某些分钟内，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
        当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
        书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
        请你返回 这一天营业下来，最多有多少客户能够感到满意 。

        示例 1：
        输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
        输出：16
        解释：书店老板在最后 3 分钟保持冷静。
        感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.*/
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        System.out.println(new Leetcode1052().maxSatisfied(customers,grumpy,3));
    }


    // 滑动窗口破解该题
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        for(int i = 0; i < grumpy.length; i++){
            if(grumpy[i] == 0){
                total += customers[i];
            }
        }
        int result = 0;
        for(int i = 0; i < customers.length; i ++){
            if(grumpy[i] == 1){
                total += customers[i];
            }
            int left = i-minutes+1 ;
            if(left < 0){
                continue;
            }
            result = total > result ? total : result;
            if(grumpy[left] == 1){
                total -= customers[left];
            }
        }
        return result;
    }
}
