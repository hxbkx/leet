package hxbkx.leet15.s1;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  双指针夹逼降维法，将O(n) = n^3  降为 O(n) = n^2
 */
public class Solution {


    /**
     * 双指针夹逼降维法，将O(n) = n^3  降为 O(n) = n^2
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int a = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                //跳过重复的数
                if (a + nums[j] + nums[k] < 0 || (j > i + 1 && nums[j] == nums[j - 1])) {
                    j++;
                } else if (a + nums[j] + nums[k] > 0 || (k < nums.length - 1 && nums[k] == nums[k + 1])) {//跳过重复的数
                    k--;
                } else if (a + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(a, nums[j], nums[k]));
                    j++;
                    k--;

                }
            }
        }
        return res;
    }

    public static void main(String[] args) {


    }
}
