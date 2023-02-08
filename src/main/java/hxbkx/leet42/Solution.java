package hxbkx.leet42;

import com.alibaba.fastjson.JSON;

class Solution {
    /**
     * leftMax[i]\textit{leftMax}[i]leftMax[i] 表示下标 iii 及其左边的位置中，height\textit{height}height 的最大高度，rightMax[i]\textit{rightMax}[i]rightMax[i] 表示下标 iii 及其右边的位置中，height\textit{height}height 的最大高度。
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Integer.max(leftMax[i-1], height[i]);
        }
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Integer.max(rightMax[j+1], height[j]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res +=  Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] testCases = new int[][]{
                new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
                new int[]{4, 2, 0, 3, 2, 5},
        };
        int[] testCasesAns = new int[]{
                6, 9
        };
        for (int i = 0; i < testCases.length; i++) {
            int trap = (new Solution()).trap(testCases[i]);
            System.out.println(trap + " " + (trap == testCasesAns[i]));
        }
    }
}