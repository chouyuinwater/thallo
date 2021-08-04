package com.fish.algorithm.leetcode;

import com.fish.tool.JsonUtil;

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
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
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
    public static int coinChange() {
        int[] coins = new int[]{1, 2, 5};
        int money = 22;
        coins = Arrays.stream(coins).sorted().toArray();


        if (money < coins[0]) {
            return -1;
        }

        int[] timesArray = new int[money + 1];
        Arrays.fill(timesArray, money + 1);
        timesArray[0] = 0;
        int[] roadArray = new int[money + 1];
        roadArray[0] = 0;
        for (int i = 1; i <= money; i++) {
            int tempTime = timesArray[i];
            for (int coin : coins) {
                if (i >= coin) {
                    timesArray[i] = Math.min(timesArray[i], timesArray[i - coin] + 1);
                    if (tempTime > timesArray[i]) {
                        roadArray[i] = coin;
                        tempTime = timesArray[i];
                    }
                }
            }
        }

        System.out.println(JsonUtil.toJson(timesArray));
        System.out.println(JsonUtil.toJson(roadArray));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(roadArray[money]);
        while (money - roadArray[money] > 0) {
            money = money - roadArray[money];
            stringBuilder.append(",");
            stringBuilder.append(roadArray[money]);
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
        return timesArray[money];
    }

    public static void main(String[] args) {
        coinChange();
    }
}
