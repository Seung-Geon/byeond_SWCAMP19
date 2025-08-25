package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. FileOutputStream을 이해할 수 있다. */
        /* 설명.
         *  FileOutputStream은 FileInputStream과 달리 해당 파일이 존재하지 않으면 파일을 생성해 줌
         *  생성자의 두 번째 전달 인자로 true를 전달하면 기존 데이터에 추가로 이어쓰기 가능
        * */
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(
//                    "src/main/java/com/ohgiraffers/section02/stream/testOutputStream.txt"); // 덮어쓰기용 생성자
                    "src/main/java/com/ohgiraffers/section02/stream/testOutputStream.txt", true); // 이어쓰기 생성자
            fos.write(97);
            fos.write(98);
            fos.write('c');
            fos.write('d');

            byte[] byteArr = new byte[] {'a', 'p', 'p', 'l', 'e'};
            fos.write(byteArr);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
