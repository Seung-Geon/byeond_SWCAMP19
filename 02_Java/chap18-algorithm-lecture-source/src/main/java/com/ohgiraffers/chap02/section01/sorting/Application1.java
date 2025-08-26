package com.ohgiraffers.chap02.section01.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
/* 수업목표. 버블 정렬을 이해할 수 있다. */
/* 설명.
 *  버블 정렬(Bubble Sort)
 *   두 인접한 데이터의 크기를 비교해 정렬하는 방법이다.
 *   버블의 모든 요소에 대해 반복하면서, 각 반복마다 가장 큰(작은)요소가 배열의 끝으로 "버블링(이동)" 된다.
 *   시간 복잡도는 O(n*2)이라 효율적이지는 않다.(feat. 데이터의 크기가 10000이면 위험)
* */
public class Application1 {
    /* 설명.
     *  문제 내용
     *   : N개의 정수가 주어졌을 때, 버블 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램을 작성하시오.
     *  입력
     *   - 첫 번째 줄에 자연수 N(1 <= N <= 100)이 주어진다.
     *   - 두 번째 줄에 N개의 정수가 공백으로 구분되어 입력된다. 각 정수는 -10^9 이상, 10^9 이하이다.
     *  출력
     *   - 오름차순으로 정렬된 수열을 공백으로 구분하여 출력한다.
     *
     *  설명.
     *   예시 입력 1
     *     - 7
     *       34 23 5 24 1 9 12
     *   예시 출력 1
     *     - 1 5 9 12 23 24 34
     *
     *  설명.
     *   예시 입력 2
     *     - 6
     *       40 47 38 8 33 35
     *   예시 출력 2
     *     - 8 33 35 38 40 47
     * */
    public static void main(String[] args) {
        int length;
        int[] arr;

        /* 설명. 입력 데이터 받기 */
//        Scanner sc = new Scanner(System.in);
//        length = sc.nextInt();
//        arr = new int[length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        System.out.println(length);
//        System.out.println(Arrays.toString(arr));

        /* 설명. BufferedReader를 활용하는 방법 */
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            length = Integer.parseInt(br.readLine());   // 가급적 한줄을 문자열로 읽어 숫자로 바꿀 때는 Integer.parseInt 사용

            /* 설명. 한줄 문자열 파싱하기 */
            /* 설명. 1. split 활용 (정규 표현식 해석으로 인해 StringTokenizer 보다 시간이 더 걸림) */
//            String[] strArr = br.readLine().split(" ");
//            arr = new int[length];
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = Integer.parseInt(strArr[i]);
//            }

            /* 설명. 2. StringTokenizer 활용 */
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[length];
            int index = 0;
            while (st.hasMoreTokens()) {
                arr[index] = Integer.parseInt(st.nextToken());
                index++;
            }

            /* 설명. 3. Stream 활용 (속도는 가장 느림, 스트림의 오버헤드 발생) */
//            IntStream intStream = Arrays.stream(br.readLine().split(" "))
//                            .mapToInt(x -> Integer.parseInt(x));
//            arr = intStream.toArray();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Arrays.toString(solution(length, arr)));
        System.out.println(Arrays.toString(arr));

    }

    public static int[] solution(int length, int[] arr) {
        for (int i = 0; i < length; i++) {
            System.out.println((i + 1) + "번째 순회: " + Arrays.toString(arr));
            /* 설명. 둘씩 쌍을 지어 하나의 버블을 끝까지 한번 보내는 작업 */
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {          // 오름차순을 위해 오른쪽이 작으면 swap을 위한 조건
//                if (arr[j] < arr[j + 1]) {          // 내림차순 위해 오른쪽이 크면 swap을 위한 조건
                    /* 설명. 두 요소(j, j+1)의 위치를 swap */
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
