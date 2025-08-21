package com.ohgiraffers.section01.section02.uses.subsection02.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


/* 설명.
 *  filter()란?
 *   - 스트림의 요소 중에 조건을 만족하는 요소들만 걸러내는 중간 연산
 *   - 중간 연산들은 최종 연산 전에는 실행되지 않음
* */
public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. filter() 중계 연산자를 활용할 수 있다. */
        IntStream.range(0,10)
                .peek(num -> System.out.print(num + " ")) // 중간에 순회하는 것을 볼 수 있음
                .filter(num -> num > 5)
                .peek(num -> System.out.print("필터링 이후: " + num + " ")) // 중간에 순회하는 것을 볼 수 있음
                .forEach(System.out::println);
        System.out.println();


        /* 설명.
         *  Arrays.stream()은 배열(int[])만 인자로 받으며, 배열의 각 요소로 스트림을 만듬
         *  반면, IntStream.of()는 IntStream.of(1,2,3)처럼 숫자를 직접 나열할 수 있다.
         *  (배열인 경우 Arrays.stream을 선호 하는 반면, 배열이 아닌 경우에는 of를 선호)
        * */
        int[] scores = {45, 78, 92, 67, 88, 59, 95, 73, 84, 52};
        IntStream sStream = Arrays.stream(scores);
        sStream.filter(score -> score >= 70)
                .forEach(score -> System.out.println(score + "점"));
        System.out.println();

        IntStream.of(scores)
                .filter(score -> score >= 70)
                .forEach(score -> System.out.println(score + "점"));

        IntStream.of(45, 78, 92, 67, 88, 59, 95, 73, 84, 52) // of는 이렇게 배열로 안만들어도 됨
                .filter(score -> score >= 70)
                .forEach(score -> System.out.println(score + "점"));

        /* 설명. 문자열 스트림 관련 */
        List<String> pLanguage = Arrays.asList(
                "Java", "Python", "JavaScript", "C++", "Go", "Rust", "Kotlin"
        );

        pLanguage.stream()
                .filter(lang -> lang.startsWith("J"))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("4글자 이하인 단어만 출력");
        pLanguage.stream()
                .filter(lang -> lang.length() < 5)
                .forEach(System.out::println);
        System.out.println();

        /* 설명. 복합 조건 필터링 */
        IntStream.rangeClosed(1, 50)
                .filter(num -> num % 3 == 0)
                .filter(num -> num > 10)        // 어떤 필터를 먼저 커치는 것이 효율적인가? -> 갯수를 더 줄이는 조건은 무엇인가?, 어떤 로직이 더 간단한가? -> 결국은 시간 측정을 통해서
                .forEach(num -> System.out.print(num + " "));

    }
}
