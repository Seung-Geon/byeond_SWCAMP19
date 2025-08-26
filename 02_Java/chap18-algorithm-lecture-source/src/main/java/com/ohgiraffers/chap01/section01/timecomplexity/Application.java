package com.ohgiraffers.chap01.section01.timecomplexity;

import java.util.Arrays;

public class Application {
    /* 수업목표. 시간 복잡도를 이해할 수 있다. */
    /* 설명. 알고리즘 실행 시 입력 값이 증가함에 따라 연산이 걸리는 시간의 증가도를 나타낸다. */

    public static void main(String[] args) {
        int[] arr =new int[]{3, 1,2, 15, 4, 9, 10, 7};
//        System.out.println(getFirst(arr));

//        Arrays.sort(arr);   // 기본 자료형: 퀵 자료형, 참조 자료형: 병합 정렬
//                                                      // NlogN
//        System.out.println(binarySearch(arr, 9));     // logN -> NlogN + logN =>  O(NlogN)

//        System.out.println(Arrays.toString(reverse(arr)));

        System.out.println(fibonacci(10));

    }

    /* 설명. 상수 시간(O(1))
     *  입력값 크기와 상관 없이 항상 일정한 시간이 걸리는 알고리즘
    * */

    /* 설명. 크기가 1이상인 배열이 던져지면 첫번째 요소를 반환하는 메소드 */
    private static int getFirst(int[] arr) {
        return arr[0];
    }

    /* 설명. 로그 시간(O(logN))
     *  입력값이 증가함에 따라 처리 시간이 로그만큼 증가하는 알고리즘
    * */
    /* 설명. 정렬된 배열과 찾고자 하는 타겟 값을 넣으면 타겟이 있는 위치를 반환하는 메소드 */
    private static int binarySearch(int[] arr, int target) {
        // 정렬이 되어 있어야 가능한 알고리즘
        int left = 0, right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;    // (left + right)/2 로 안하는 이유는 혹시 모를 오버플로를 잡기 위함
                                                    // left = 20억, right = 20억 -> left + right = 40억 -> 오버플로
                                                    // 따라서 left + (right - left) / 2 를 이용해 혹시 모를 오버플로를 방지
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /* 설명. 선형 시간 (O(n)) */
    /* 설명.
     *  입력값이 증가함에 따라 처리 시간이 선형적으로 증가하는 알고리즘이다.
    * */
    private static int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];   // 같은 크기으 ㅣ배열 생성
                                                    // 1
        for(int i = 0; i < arr.length; i++) {       // N + 1
            reversed[i] = arr[arr.length - i - 1];  // N
        }
        return reversed;                            // 1
                                                    // -> 1 + N + 1 + N + 1 = 2N + 3 => O(N)
    }

    /* 설명. 지수 시간 (O(2^n))*/
    /* 설명.
     *  입력값이 증가함에 따라 시간이 기하급수적으로 증가하는 알고리즘
    * */
    private static int fibonacci(int n) {
        if(n <= 1) return n ;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}