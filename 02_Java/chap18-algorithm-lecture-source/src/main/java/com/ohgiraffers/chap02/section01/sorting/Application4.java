package com.ohgiraffers.chap02.section01.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/* 설명.
 *  퀵 정렬 (Quick Sort)
* */
public class Application4 {


    public static void main(String[] args) {
        int[] arr;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(br.readLine());
            IntStream intStream = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt);
            arr =  intStream.toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        solution(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void solution(int low, int high, int[] arr){
        if(low >= high) return; // 한 칸이거나 low 개념의 포인터가 high 개념의 포인터를 지나갔다면

        int pivot = process(low, high, arr);
        solution(low, pivot, arr);
        solution(pivot + 1, high, arr);
    }

    private static int process(int left, int right, int[] arr) {

        /* 설명. 커서는 do-while을 통해 증가 및 감소를 하고 판단하게 하는 코드로 인한 초기값 설정 */
        int low = left - 1;                         // 왼쪽 커서 위치(인덱스)
        int high = right + 1;                       // 오른쪽 커서 위치(인덱스)
        int pivot = arr[left + (right - left) / 2]; // pivot: 지금 process 구간의 중앙 값

        while(true) {
            do{
                low++;
            } while(arr[low] < pivot);

            do{
                high--;
            } while(arr[high] > pivot);

            if(low >= high) {
                return high;
            }
            swap(arr, low, high);
        }
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
