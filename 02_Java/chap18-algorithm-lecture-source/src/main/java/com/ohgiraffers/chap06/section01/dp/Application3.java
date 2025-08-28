package com.ohgiraffers.chap06.section01.dp;

public class Application3 {
    public static Integer solution(Integer n) {
        int[] dp = new int[n + 1];
        /* 설명. 탑다운 방식 */
        padovan(n, dp);


        return dp[n];
    }

    private static int padovan(Integer n, int[] dp) {
        if(n == 1) return 1;
        if(n == 2) return 1;
        if(n == 3) return 1;

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        /* 설명. 조건문을 통해 점화식을 적용하는 것은 필요할 때만 적용(가지치기, pruning) */
        /* 설명. promising: 가치가 있을 때만 내려가게 하기 위한 조건문 */
        if(dp[n] == 0) dp[n] = padovan(n-2, dp) + padovan(n-3, dp);

        return dp[n];
    }
}
