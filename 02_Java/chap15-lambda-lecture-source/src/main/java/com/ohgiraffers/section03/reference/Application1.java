package com.ohgiraffers.section03.reference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Application1 {
    public static void main(String[] args) {
        
        /* 수업목표. 기존에 존재하는 메소드를 참조해 람다식을 적용할 수 있다.(feat. 람다식으로 또 굳이 작성할 필요X) */
        BiFunction<String, String, Boolean> biFunction;

        String str1 = "METHOD";
        String str2 = "METHOD";

        boolean result = false;

        biFunction = String::equals;    // 항상 동일한 객체의 equals를 부르는게 아니므로 non-static임에도 클래스명이 붙음
//        biFunction = (x, y) -> x.equals(y); // 위와 동일한 코드
        result = biFunction.apply(str1, str2);
        System.out.println("result = " + result);

        /* 설명. non-static 메소드를 참조하는 경우 클래스명이 아닌 참조 변수명을 활용할 수 있는 경우 */
        String prefix = "Hello ";
        List<String> names = Arrays.asList("Alice", "Bob");

        names.stream()
                .map(prefix::concat)
                .forEach(System.out::println);
        names.stream()          // 위와 동일한 기능
                .map((name) -> prefix.concat(name)) // 각 요소마다 람다식에 전달되며 람다식이 실행됨(그 결과를 Stream으로 만듬)
                .forEach(name -> System.out.println(name));

        /* 설명. 메소드 참조 시에는 참조한 메소드를 호출하는 객체가 정해진 경우(참조변수)와
            정해지지 않은 경우(클래스명)를 구분할 수 있어야 한다. */
    }
}
