package com.segi.algorithm4.before;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

/**
 * @author chenzx
 * @date 2018-10-17 下午 1:56
 */
public class RecursiveTest {

    /*
     * 递归四条法则：
     * 1、基准情形：必须总要有某些基准情形，它不用递归就能解出
     * 2、不断推进：对于那些需要递归求解的情形，每一次递归调用都朝基本情形推进
     * 3、设计法则：假设所有的递归调用都能正确运行。
     * 4、合成效益法则：在求解一个问题的同一实例时，切勿在不同的递归调用中做重复性的工作。
     * */
    @Test
    public void recursive1() {
        printOut(1999);
    }

    public void printOut(int n) {
        if (n >= 10) {
            printOut(n / 10);
        }
        //n%10 = n - (n/10)*10
        System.out.print(n % 10);
    }

    @Test
    public void goAgainstForthRule() {
        long start = Instant.now().toEpochMilli();
        badRecursive(100);
        long end = Instant.now().toEpochMilli();
        System.out.println("花费时间:" + (end - start));
    }

    private int badRecursive(int n) {
        if (n <= 1) {
            return 1;
        }
        return badRecursive(n - 1) + badRecursive(n - 2);
    }

    /**
     * 子序列最大和四种算法
     */
    @Test
    public void subSeq() {
        int[] a = {-1, 3, 5, -2, 6};
        System.out.println(maxSum1(a));
        System.out.println(maxSum2(a));
        System.out.println(maxSumRecursive(a, 0, a.length - 1));
        System.out.println(maxSum4(a));
    }

    public int maxSum1(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public int maxSum2(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public int maxSumRecursive(int[] a, int left, int right) {
        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }
        int center = (left + right) / 2;
        int leftSum = maxSumRecursive(a, left, center);
        int rightSum = maxSumRecursive(a, center + 1, right);
        int leftBorderSum = 0;
        int leftThisSum = 0;
        for (int i = left; i >= 0; i--) {
            leftThisSum += a[i];
            if (leftThisSum > leftBorderSum) {
                leftBorderSum = leftThisSum;
            }
        }
        int rightBorderSum = 0;
        int rightThisSum = 0;
        for (int i = center + 1; i < a.length; i++) {
            rightThisSum += a[i];
            if (rightThisSum > rightBorderSum) {
                rightBorderSum = rightThisSum;
            }
        }
        return max3(leftSum, rightSum, (leftBorderSum + rightBorderSum));
    }

    private int max3(int leftSum, int rightSum, int borderSum) {
        return Integer.max(leftSum, Integer.max(rightSum, borderSum));
    }

    public int maxSum4(int[] a) {
        int maxSum = 0;
        int thisSum = 0;
        for (int j = 0; j < a.length; j++) {
            thisSum += a[j];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * O(logN)的举例
     */
    @Test
    public void logTest() {
        Integer[] a = {1, 4, 6, 8, 11};
        System.out.println(binarySearch(a, 8));
        System.out.println(gcd(15, 5));
        System.out.println(pow(2, 5));
    }

    public Integer binarySearch(Integer[] a, Integer x) {
        Integer left = 0;
        Integer right = a.length - 1;
        while (left <= right) {
            Integer mid = left + (right - left) / 2;
            if (a[mid] < x) {
                left = mid + 1;
            } else if (a[mid] > x) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int gcd(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (n != 0) {
            int mod = m % n;
            m = n;
            n = mod;
        }
        return m;
    }

    public int pow(Integer x, Integer n) {
        if (n == 0) {
            return 1;
        }
        if (n / 2 == 0) {
            return pow(x * x, n / 2);
        } else {
            return pow(x * x, n / 2) * x;
        }
    }

}
