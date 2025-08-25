package com.ohgiraffers.section02.set.run;

import java.util.*;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. TreeSet에 대해 이해하고 활용할 수 있다. */
        Set<String> tSet = new TreeSet<String>();
        tSet.add("ramen");
        tSet.add("pork");
        tSet.add("kimchi");
        tSet.add("firedEgg");
        tSet.add("firedEgg");
        tSet.add("soup");
        System.out.println("lSet: " + tSet);    // 오름차순 정렬된 상태

        Iterator<String> iter = tSet.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        /* 설명.
         *  로또 번호 발생기(feat. 보너스 추출 제외)
         *  (1~45 중복되지 않고 오름차순 정렬된 6개의 번호 발생하기)
        * */
        Set<Integer> lotto = new TreeSet<>();
        while(lotto.size() < 6) {
            lotto.add((int)(Math.random() * 45) + 1);
        }
        System.out.println("lotto: " + lotto);

        /* 설명. 배열을 활용해서 같은 로또 번호 발생기를 만들어 보자(feat. 정렬 제외) */
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            int temp = (int)(Math.random() * 45) + 1;
            if(duplicationCheck(arr, temp)) {
                i--;
            } else {
                arr[i] = temp;
            }
        }
        System.out.println("arr: " + Arrays.toString(arr));

        int[] arr2 = new int[6];
        int random = 0;
        for(int i = 0; i < 6; i++) {
            random = (int)(Math.random() * 45) + 1;
            arr2[i] = random;
            for (int j = 0; j < i; j++) {
                if(random == arr[j]) {
                    i--;
                    break;
                }
            }
        }
        System.out.println("arr2: " + Arrays.toString(arr2));
    }
    public static boolean duplicationCheck(int[] arr, int a) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == a) { return true;}
        }
        return false;
    }

}
