package com.ohgiraffers.section05.calendar;

import java.text.SimpleDateFormat;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. java.util.Date 클래스 사용법을 이해할 수 있다. */
        java.util.Date today = new java.util.Date();
        System.out.println("today = " + today);

        System.out.println("long 타입 시간: " + today.getTime()); // 1970년 1월 1일 0시(그리니치 천문대)| 9시(한국)를 기준으로 지난 시간 반환
        System.out.println("long 타입 시간을활용한 Date: " +  new java.util.Date(0));
        System.out.println("long 타입 시간을활용한 Date: " +  new java.util.Date(today.getTime()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String todayFormat = sdf.format(today);
        System.out.println("todayFormat = " + todayFormat);

        /* 설명. java.util.Date <-> java.sql.Date */ // java.sql.Date: DB와 연동되는 Date
        java.util.Date today2 = new java.util.Date();
        java.sql.Date sqlDate = new  java.sql.Date(today2.getTime());

        java.util.Date date = sqlDate;  // 다형성 적용   sql.Date는 util.Date를 상속 받음
    }
}
