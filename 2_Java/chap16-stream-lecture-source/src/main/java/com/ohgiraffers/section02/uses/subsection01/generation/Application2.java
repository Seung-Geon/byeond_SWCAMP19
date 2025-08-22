package com.ohgiraffers.section02.uses.subsection01.generation;

/* 설명.
 *  기본 타입 스트림(Primitive Stream) 생성
 *  - IntStream: int 타입 전용
 *  - LongStream: long 타입 전용
 *  - DoubleStream: double 타입 전용
 *
 * 설명.
 *  사용 목적
 *  - 박싱/언박싱
 *  - 숫자 관련 연산 메소드 제공
* */

import java.util.List;
import java.util.stream.*;

public class Application2 {
    public static void main(String[] args) {

        /* 설명. 1. IntStream */
        IntStream.range(5,10)       // 끝부분 포함X
                .forEach(num -> System.out.println(num + " "));
        System.out.println();
        IntStream.rangeClosed(5,10) // 끝부분 포함
                .forEach(num -> System.out.println(num + " "));

        /* 설명. 2. LongStream */
        System.out.println("1부터 10만까지의 짝수의 합");
        long sum =LongStream.range(1, 100000)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.print("함계: " + sum);


        /* 설명. 3. DoubleStream */
        /* 설명. 0에서 1.0전가지 5개의 난수 생성 */
        DoubleStream.generate(Math::random)     // 무한 스트림 생성
                .limit(5)               // 5개로 제한(필수!!!)
                .forEach(num -> System.out.printf("%.3f", num));

        /* 설명. 4. 박싱(Boxing): 기본 타입을 래퍼 클래스로 변환 */
        Stream<Integer> boxedStream = IntStream.range(1,6)
                                            .boxed();
        /* 설명. 추후 배열 내용(최종 연산)이지만 컬렉션으 변활할 때 boxing 해 보자 */
        List<Integer> list = IntStream.range(1,6)
                                .boxed()
                                .collect(Collectors.toList());
        System.out.println("\nlist = " + list);



    }
}
