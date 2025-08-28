package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Application3_1 {
    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        int max_count = 0;
        BufferedReader br = toBufferedReader(input);

        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> timeList = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st =  new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            timeList.add(new Time(start, end));
        }
        System.out.println(timeList.toString());
        timeList.sort(Time::compareTo);

        max_count = 1;      // 첫 회의는 무조건 들어오니까
        int endTime = timeList.get(0).end;
        for(int i = 1; i < N; i++){
            /* 설명.
             *  5 5  ---- 1
             *  3 5  ---- 2
             *  이런식 데이터가 있으면
             *  1과 중 먼저 오는 것에 따라서 결과가 달라진다.
             *  '5 5' 이후에 endTime이 5가 되어버리면 '3 5' 는 못오지만
             *  '3 5' 이후에 endTime이 5가 되어도 '5 5'는 가능하기 때문에 
             *  이에 대한 처리르 위해서 아래의 조건문을 추가 or 정렬 시 end가 동일한 경우 start로 정렬하게 변화를 주어야 함
            * */
            if(timeList.get(i).end == timeList.get(i).start){
                max_count++;
                continue;
            }
            if(timeList.get(i).start >= endTime) {
                max_count++;
                endTime = timeList.get(i).end;
            }
        }
        System.out.println(timeList.toString());
        return max_count;
    }

    static class Time implements Comparable<Time> {

        public int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
//            if(this.end == o.end) return this.start - o.start;
            return this.end - o.end;        // end 시간을 기준으로 오름차순
        }

        @Override
        public String toString() {
            return "Time{" +
                    "start=" + start +
                    ", end=" + end +
                    '}' + '\n';
        }
    }

}
