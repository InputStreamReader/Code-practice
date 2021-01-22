/*
*
* 集合 s 包含从 1 到 n 的整数。不幸的是，
* 因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
* 导致集合 丢失了一个数字 并且 有一个数字重复 。
* 给定一个数组 nums 代表了集合 S 发生错误后的结果。
* 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
* 示例 1：
* 输入：nums = [1,2,2,4]
* 输出：[2,3]
* 示例 2：
* 输入：nums = [1,1]
* 输出：[1,2]
* 提示：
* 2 <= nums.length <= 104
* 1 <= nums[i] <= 104
*
* 题解 */
//使用HashMap来进行统计每个字母的次数，
// 如果为2则是重复的数字，
// 如果遍历时寻找不到该数字，则为丢失数字

import java.util.HashMap;
import java.util.Map;

 public class Solution645 {
     public static int[] findErrorNums(int[] nums) {
         Map<Integer,Integer> map = new HashMap();
         int dup = 0;int missing = 0;

         for(int num : nums){
             map.put(num,map.getOrDefault(num,0) + 1);
         }
         // getOrDefault() 方法，如果不存在num就输出defaultValue，如果num存在就输出value

         for(int i = 1;i <= nums.length;i++){
             if(map.containsKey(i) && map.get(i) == 2){
                 dup = i;
             }

             if(!map.containsKey(i)){
                 missing = i;
             }

         }
         return new int[]{dup, missing};
     }

     public static void main(String[] args) {
        int [] num = {2,2};
        System.out.println(findErrorNums(num));
     }
 }