package com.ohgiraffers.section01.list.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 컬렉션 프레임워크에 대해 이해할 수 있다.(list 계열부터) */
        /* 설명.
         *  배열보다 ArrayList가 좋은 점
         *  1. 미리 크기를 할당할 필요가 없다.
         *  2. 들어있는 값(데이터)의 갯수를 잘 파악할 수 있다.(size())
         *  3. 경우에 따라(제네릭 타입을 생략하면) 다양한 값을 한번에 저장할 수 있다.(Object[]과는 별로 큰 차이X)
         *  4. 중간에 값을 추가 및 삭제가 편리하다.(feat. 속도가 다소 느릴 수 있음)
        * */
        ArrayList list = new ArrayList();
        list.add("apple");
        list.add(123);
        list.add(45.67);
        list.add(new java.util.Date());

        /* 설명. 넣은 데이터의 순서에 맞게 인덱스로 추출 */
        System.out.println("list = " + list);
        System.out.println("처음 넣은 값: " + list.get(0));
        System.out.println("두 번째 넣은 값: " + list.get(1));
        System.out.println("세 번째 넣은 값: " + list.get(2));

        /* 설명. 넣은 데이터의 양(size) */
        System.out.println(list.size());

        list.add(1, 19);    // 원하는 index에 원하는 값을 넣을 수 있음
        System.out.println("list = " + list);

        list.set(1, "banana");          // 원하는 index의 값을 수정 가능
        System.out.println("list = " + list);

        list.remove(1);         // 원하는 인덱스를 없앰
        System.out.println("list = " + list);

        /* 설명. ArrayList를 활용한 정렬 */
        /* 설명. 1. 문자열 데이터 정렬(feat. 오름차순) */
//        ArrayList<String> stringList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();        // 필수는 아니지만 관례상 컬렉션은 다형성을 주로 적용
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("banana");
        stringList.add("mango");
        stringList.add("grape");

        System.out.println("문자열 데이터: " + stringList);

        /* 설명. 실제로는 ArrayList 안에 있는 데이터인 String에 정의된 기준(오름차순)대로 정렬 됨 */
        Collections.sort(stringList);   // 정렬, 오름차순/내림차순은 데이터의 compareTo 메소드가 -1,0,1인지에 따라 swap
        System.out.println("정렬된 문자열 데이터: " + stringList);

        /* 설명. 내림차순 하는 방법 */
        List<String> stringList1 = new LinkedList<>();
        stringList1.add("apple");
        stringList1.add("orange");
        stringList1.add("banana");
        stringList1.add("mango");
        stringList1.add("grape");
        Collections.sort(stringList);
        Iterator<String> iter = ((LinkedList<String>) stringList1).descendingIterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");    // 제네릭을 적용하면 iter.next() 반환형이 명확해짐(타입 안정성)
        }
    }
}