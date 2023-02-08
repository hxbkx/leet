package hxbkx.leet7;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

    /**
     * 对x进行滚动截取末尾数字
     * -2^31 <= res * 10 + mod <=  2^31 -1
     * 由于不能使用64位存储，所以需要将res 和 mod 范围做个限定，检测溢出：
     * 设2^31 = res * 10 + mod，则 res = 2^31 / 10 + 8，令 INT_MAX = 2^31 -1,INT_MIN = -2^31
     * 所以不等式变为  INT_MIN <= res * 10 + mod <= INT_MAX
     * res * 10 + mod <= INT_MAX  && INT_MIN <= res * 10 + mod
     * 1、res * 10 + mod <= INT_MAX  推导得 ==>   res <= (INT_MAX - mod)➗10   ==>   res <= INT_MAX / 10    (➗ 表示浮点除法，/表示整形除法)
     * 2、res * 10 + mod >= INT_MIN  推导得 ==>   res + mod➗10 >= INT_MIN➗10  ==>   res >= INT_MIN / 10  (➗ 表示浮点除法，/表示整形除法)
     * <p>
     * 所以为了不溢出，只能将[res < INT_MAX / 10 && res >= INT_MIN / 10]
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = x % 10;
        x /= 10;
        int maxRes = Integer.MAX_VALUE / 10;
        int minRes = Integer.MIN_VALUE / 10;
        while (x != 0) {
            //res <= maxRes && res >= minRes
            int mod = x % 10;
            if (!(res <= maxRes && res >= minRes)) {
                //溢出返回0
                return 0;
            }
            res = res * 10 + mod;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] testCases = new int[]{1463847412};
        for (int testCase : testCases) {
            System.out.println(JSON.toJSONString((new Solution()).reverse(testCase)));
        }
    }
}
