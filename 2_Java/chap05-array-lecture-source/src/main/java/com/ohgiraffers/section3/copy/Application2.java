package com.ohgiraffers.section3.copy;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 깊은 복사에 대해 이해할 수 있다. */
        /* 설명.
         *  1. for문을 이용한 수동적인 복사
         *  2. Object의 clone()을 이용한 복사(사용 빈도 높음)
         *  3. System의 arraycopy()를 이용한 복사      : 완전히 동일하게아닌 커스터 마이징을 하는 경우
         *  4. Arrays의 copyOf()를 이용한 복사         : 완전히 동일하게아닌 커스터 마이징을 하는 경우
        * */
        int[] originalArr =new int[]{1, 2, 3, 4};
        print(originalArr, "원본");

        /* 설명. 1. */
        int[] copyArr = new int[originalArr.length];
        for (int i = 0; i < copyArr.length; i++) {
            copyArr[i] = originalArr[i];
        }
        print(copyArr, "for문을 이용한 사본");

        /* 설명. 2. */
        int[] copyArr2 = originalArr.clone();
        print(copyArr2, "clone()을 이용한 사본");

        /* 설명. 3. */
        int[] copyArr3 = new int[originalArr.length + 3];
        System.arraycopy(originalArr, 0, copyArr3, 3, originalArr.length);  // 원본의 srcPos위치부터 length만큼을 사본의 destPos위치 부터 붙여라
        print(copyArr3, "arraycopy()를 활용한 사본");

        /* 설명. 4. */
        int[] copyArr4 = Arrays.copyOf(originalArr, 3); // 원본의 0번 인덱스부터 length 만큼을 복사해서 해당 크기만 가진 배열을 만든다.
        print(copyArr4, "copyOf()를 활용한 사본");

    }

    private static void print(int[] arr, String desc) {
        System.out.println("=======" + desc + "=======");
        System.out.println("넘어온 배열의 hashCode: " + arr.hashCode());
        System.out.println(Arrays.toString(arr));
    }
}
