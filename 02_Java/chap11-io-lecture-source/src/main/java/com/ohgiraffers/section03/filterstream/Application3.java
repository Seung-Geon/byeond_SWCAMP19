package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 데이터 타입 입출력 보조 스트림을 이해하고 활용할 수 있다. */
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testData.txt")
            );
            // 깨진 것 처럼 보임
            dos.writeUTF("홍길동");
            dos.writeInt(20);
            dos.writeChar('A');

            dos.writeUTF("유관순");
            dos.writeInt(16);
            dos.writeChar('B');

            dos.writeUTF("강감찬");
            dos.writeInt(38);
            dos.writeChar('O');


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        DataInputStream dis = null;
        try {
            dis = new DataInputStream(
                    new FileInputStream("src/main/java/com/ohgiraffers/section03/filterstream/testData.txt")
            );

            while(true) {
                System.out.println(dis.readUTF());  // 넣은 순서대로 읽어야 안깨지고 읽을 수 있음
                System.out.println(dis.readInt());  // 파일의 끝을 만나면 EOFException 발생 -> 예외가 발생하면 다 읽은 것
                System.out.println(dis.readChar());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch(EOFException e) {
            System.out.println("파일 읽기 완료!");
        }catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(dis != null) dis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
