package com.ohgiraffers.chap02.section01.sorting;

public class Application5 {

    /* 설명.
     *  병합 정렬(Merge Set)
    * */
    public static void solution(int low, int high, int[] arr) {
        if(high - low == 0) return; // 한 칸이면

        // 분할
        int median = low + (high - low) / 2;
        solution(low, median, arr);
        solution(median + 1, high, arr);


        int[] temp = arr.clone();

        /* 설명. 분할 정복 방식 시작 */
        int k = low;
        int index1 = low;
        int index2 = median + 1;

        while(index1 <= median && index2 <= high) {
            if(temp[index1] > temp[index2]) {   // 오름차순을 위한 조건
                arr[k] = temp[index1];
                k++;
                index1++;
            } else {
                arr[k] = temp[index2];
                k++;
                index2++;
            }
        }
        /* 설명. 좌측이 많이 남은 경우 */
        while(index1 <= median) {
            arr[k] = temp[index1];
            k++;
            index1++;
        }
        /* 설명. 우측이 많이 남은 경우 */
        while(index2 <= high) {
            arr[k] = temp[index2];
            k++;
            index2++;
        }


//        if(index1 > median) {
//            for(; index2 <= high; index2++) {
//                arr[k] = temp[index2];
//                k++;
//            }
//        } else {
//            for(; index1 <= median; index1++) {
//                arr[k] = temp[index1];
//                k++;
//            }
//        }

    }
}
