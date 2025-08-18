package com.ohgiraffers.section02.set.run;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. LinkedHashSet에 대해 이해하고 이해할 수 있다. */
        Set<String> lSet = new LinkedHashSet<String>();
        lSet.add("ramen");
        lSet.add("pork");
        lSet.add("kimchi");
        lSet.add("firedEgg");
        lSet.add("firedEgg");
        lSet.add("soup");
        System.out.println("lSet: " + lSet);    // 순서 유지O, ArrayList가 아닌 이거를 사용하는 이유는 중복 제거

        /* 설명. 저장한 순서를 기억하는 LinkedHashSet 확인 */
        Iterator<String> iter = lSet.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
