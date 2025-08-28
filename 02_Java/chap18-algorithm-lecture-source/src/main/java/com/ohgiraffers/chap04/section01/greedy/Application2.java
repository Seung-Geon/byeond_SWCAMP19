package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application2 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 동전의 종류
        int K = Integer.parseInt(st.nextToken());   // 목표 가격

        int[] coinArr = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            coinArr[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(coinArr));

        int count = 0;
//        int index = coinArr.length - 1;

        /* 설명. 큰 금액의 동전부터 지불하며 반복 */
        for (int i = N - 1; i >= 0 ; i--) {
            if(coinArr[i] <= K) {
                count += K / coinArr[i];
                K %= coinArr[i];
            }
        }


//        while(K > 0) {
//            count += (K / coinArr[index]);
//            K %= coinArr[index];
//            index--;
//        }

        return count;
    }

}
