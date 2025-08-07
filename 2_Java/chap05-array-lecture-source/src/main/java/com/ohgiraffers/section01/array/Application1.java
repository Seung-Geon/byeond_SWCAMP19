package com.ohgiraffers.section01.array;

import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {

        /* 설명. 배열에 대해 이해하고 배열의 사용 목적을 이해할 수 있다. */
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int num4 = 40;
        int num5 = 50;

        int sum = 0;
        sum += num1;
        sum += num2;
        sum += num3;
        sum += num4;
        sum += num5;

        System.out.println("sum = " + sum);

        int[] arr = new int[5];     // heap 영역에 {0, 0,`0, 0, 0}
        System.out.println("arr = " + arr[0]);
        System.out.println(arr);

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        for (int i = 0; i < 5; i++) {
            arr[i] = 10 * (i + 1);
        }

//        System.out.println(Arrays.toString(arr));     // 반복문 없이 1차원 배열 출력하기
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
