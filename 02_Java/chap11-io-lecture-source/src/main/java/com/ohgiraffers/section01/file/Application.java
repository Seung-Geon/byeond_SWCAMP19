package com.ohgiraffers.section01.file;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 입출력 스트림에 대해 이해하고 파일을 대상으로 하는 FileInputStream을 이해하기 위한 File 객체 활용해보기 */
        File file = new File("src/main/java/com/ohgiraffers/section01/file/test.txt"); // 파일인지 시키기

        try {
            boolean isSuccess = file.createNewFile(); // 인지한 파일이 없다면 만들기 ( 만들면 true, 이미 있어서 못만들면 fasle)
            System.out.println("파일 생성 여부: " + isSuccess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("파일의 크기: " + file.length() + "byte");
        System.out.println("파일의 경로: " + file.getPath());
        System.out.println("현재 파일의 상위 경로: " + file.getParent());
        System.out.println("파일의 절대 경로: " + file.getAbsolutePath());

        boolean isDeleted = file.delete();
        System.out.println("파일 삭제 여부: " + isDeleted);

    }
}
