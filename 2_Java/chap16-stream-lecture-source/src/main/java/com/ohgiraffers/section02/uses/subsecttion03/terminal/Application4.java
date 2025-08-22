package com.ohgiraffers.section02.uses.subsecttion03.terminal;


import java.util.Arrays;
import java.util.stream.IntStream;

/* 설명.
 *  Matching이란?
 *  - 스트림의 요소들이 특정 조건을 만족하는지 검사하는 최종 연산
 *  - Short Circuit 연산: 결과가 확정되면 즉시 순회중단
 *
 * 설명.
 *  - anyMatch(): 하나라도 만족하면 true (Short Circuit 연산)
 *  - allMatch(): 모든 요소가 만족하면 true
 *  - noneMatch(): 모든 요소가 조건을 만족하지 않으면 true
* */
public class Application4 {
    public static void main(String[] args) {

        /* 수업목표. Matching 관련 최종 연산자를 활용ㅇ할 수 있다. */
        int[] numbers = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10};
        System.out.println(Arrays.toString(numbers));

        /* 설명. anyMatch() */
        boolean hasEven = IntStream.of(numbers)
                .anyMatch(x -> x % 2 == 0);
        System.out.println("hasEven = " + hasEven);

        boolean hasLarger = IntStream.of(numbers)
                .anyMatch(x -> x > 20);
        System.out.println("hasLarger = " + hasLarger);

        /* 설명. allMatch() */
        boolean allPositive = IntStream.of(numbers)
                .allMatch(x -> x > 0);
        System.out.println("allPositive = " + allPositive);

        boolean allOdd = IntStream.of(numbers)
                .allMatch(n -> n % 2 == 1);
        System.out.println("allOdd = " + allOdd);

        /* 설명. noneMatch() */
        boolean noNegative = IntStream.of(numbers)
                .noneMatch(x -> x < 0);
        System.out.println("noNegative = " + noNegative);

        boolean noZero = IntStream.of(numbers)
                .noneMatch(x -> x == 0);
        System.out.println("noZero = " + noZero);

    }
}
