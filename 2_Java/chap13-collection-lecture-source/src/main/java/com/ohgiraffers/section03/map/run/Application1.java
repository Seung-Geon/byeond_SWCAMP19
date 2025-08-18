package com.ohgiraffers.section03.map.run;

import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.HashMap;
import java.util.Map;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Map의 자료구조에 대해 이해하고, HashMap을 이용할 수 있다. */
        /* 설명. 1. Key가 중복되는 경우 */
        Map<Object, Object> hMap = new HashMap<Object, Object>();
        hMap.put(new String("one"), new java.util.Date());
        hMap.put(12, "red apple");
        hMap.put(33, 123.0);

        /* 설명. Key로 쓰는 객체는 e,h를 통해 동등함이 판별되면 같은 key로 취급(feat. e, h 반드시 둘 다 오버라이딩 되어야 함) */
        System.out.println("키가\"one\"인 String으로 Value를 추출한다면: " + hMap.get(new String("one"))); // 동등하면 같은 키로

        System.out.println("hMap = " + hMap);

        /* 설명. Key값은 결국 동등 객체면 같은 Key값으로 보고 같은 Key를 가진 이후에 들어간 Entry(K +V)가 이전 것을 덮어씌움 */
        hMap.put(new BookDTO(1, "홍길동전", "허균", 50000), 10); // e, h가 오버라이딩이 안되어 있으면 두 객체는 동등비교가 안되기 때문에 두개의 객체를 다른 키로 봄
        hMap.put(new BookDTO(2, "홍길동전", "허균", 50000), 20); // 중복된 키를 덮어씌우니 주의!

        System.out.println("hMap = " + hMap);
        System.out.println("20 꺼내보기: " + hMap.get(new BookDTO(2, "홍길동전", "허균", 50000)));

        /* 설명. 2. Value가 중복되는 경우 */
        hMap.put(44, 123.0);
        hMap.put(40, 123.0);
        hMap.put(41, 123.0);
        System.out.println("Value가 중복되는 경우: " + hMap);


    }
}
