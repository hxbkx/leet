package hxbkx.leet11;

import com.alibaba.fastjson.JSON;

class Solution {
    /**
     * 双指针滑动窗口方法，每次把左右边界小的那个索引往中心靠拢，并记录上一次maxArea和本次计算的面积的较大者
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int a = 0;
        int b = height.length - 1;
        int maxArea = 0;
        while (a != b) {
            maxArea = Math.max(maxArea, Math.min(height[a], height[b]) * (b - a));
            if (height[a] <= height[b]) {
                a++;
            } else {
                b--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {

        int[][] testCases = new int[][]{
                new int[]{2, 3, 4, 5, 18, 17, 6}
        };
        for (int[] testCase : testCases) {
            System.out.println(JSON.toJSONString((new Solution()).maxArea(testCase)));
        }
    }
}
