package com.fish.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author jiangbing
 * @date 2021/8/3 19:52
 * notes and tips:
 */
public class DynamicProgramming {

    /**
     * 硬币找零问题
     *
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * 你可以认为每种硬币的数量是无限的。
     *
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     *
     * 输入：coins = [2], amount = 3
     * 输出：-1
     *
     * 输入：coins = [1], amount = 0
     * 输出：0
     *
     * 输入：coins = [1], amount = 1
     * 输出：1
     *
     * 输入：coins = [1], amount = 2
     * 输出：2
     */
    public static void coinChange() {
        int[] coins = new int[]{1, 2, 5};
        int money = 11;
        coins = Arrays.stream(coins).sorted().toArray();


        if () {
        }





    }
}
