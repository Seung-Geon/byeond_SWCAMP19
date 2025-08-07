package com.ohgiraffers.section1.array;

import java.util.Arrays;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 배열에 들어갈 초기 기본값 및 전달인자로써의 배열 자료형 */
        /* 설명.
         *  값의 형태별 기본값
         *  정수: 0
         *  실수: 0.0
         *  논리: false
         *  문자: \u0000, \0
         *  참조: null
        * */

        int[] iArr = new int[5];
        iArr = null;
        System.out.println(iArr);
        
        /* 설명. 크기 및 원하는  값이 채워진 상태의 배열 바로 만들어보기 */
        int[] iArr2 = {10, 11, 12, 13, 14};
        int[] iArr3 = new int[]{20, 21, 22, 23, 24};        // 정석, 앞부분이 생략 가능해 위의 형태가 가능
        
        System.out.println(Arrays.toString(iArr2));
        System.out.println(Arrays.toString(iArr3));

        /* 설명. 다만 new 연산자를 생략해서 안되는 경우가 있다. */
        test(new int[]{10, 11, 12, 13, 14});// 이렇게 배열을 사용하면 메소드가 종료되면 더 이상 사용되지 않으므로 heap 영역에서 삭제된다.
        //test({10, 11, 12, 13, 14});       // Error. 메소드에 바로 넘기는 경우 new int[] 생략 불가능
        
    }

    private static void test(int[] iArr2) {
        System.out.println("메소드에서 넘겨받은 배열 확인: " + Arrays.toString(iArr2));      // 배열을 준 것이 아니라 배열의 위치를 준 것
    }
}
