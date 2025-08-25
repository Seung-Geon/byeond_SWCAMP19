package com.ohgiraffers.section3.copy;

import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 배열의 복사 개념 중 우선 얕은 복사에 대해 이해할 수 있다. */

        int[] originArr = {1, 2, 3};
        int[] copyArr = originArr;

        System.out.println(Arrays.toString(copyArr));

        copyArr[1] = 100;
        System.out.println(Arrays.toString(originArr));

        testMethod(originArr);  // 메소드 사용 시 매개변수로 얕은 복사가 일어남
        System.out.println(Arrays.toString(originArr));
    }

    private static void testMethod(int[] arr) {
        System.out.println("메소드 안에서 arr로 접근 시 모습: " + Arrays.toString(arr));
        arr[0] = 111;

    }
}
