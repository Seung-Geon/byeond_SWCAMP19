package com.ohgiraffers.section03.uses;

import java.io.*;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. try-with-resource 구문을 이해하고 활용할 수 있다.(feat. finallly 안씀) */
        try(BufferedReader br = new BufferedReader(new FileReader(new File("test.dat")))) { // try(...) 를 통해서 br을 만들면 자동으로 br.close를 진행해 준다. 단 필요한 catch 절은 추가해줘야 한다.

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
