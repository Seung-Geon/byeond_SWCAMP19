package com.ohgiraffers.section01.object.run;

import com.ohgiraffers.section01.object.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        BookDTO bookDTO = new BookDTO();
        System.out.println(bookDTO);

        BookDTO book1 = new BookDTO(1, "홍길동전", "허균", 50000);
        BookDTO book2 = new BookDTO(2, "홍길동전", "허균", 50000);

        System.out.println("두 인스턴스를 == 연산자로 비교: " + (book1 == book2));
        System.out.println("두 인스턴스를 equals() 메소드로 비교: " + book1.equals(book2));

        /* 설명. 동등비교를 위한 equals()로 재정의 하고 싶다. */
        /* 설명.
         *  동등 비교는 객체들이 가진 필드에서 우리가 서낵한 기준의 필드 값이 같으면 true가 나오도록
         *   equals() 메소드를 오버라이딩 해서 비교하는 것을 말한다.
         *  기본적으로 equals()만 써도 되지만 이후 String 또는 Collection을 배우면 자바에서
         *  내부적으로 equals()와 hashCode()를 동작시키게 되므로 왠만해선 같이 오버라딩 해야 한다.
         *  (hashCode()로 같은 int값이 나오면 equals()가 true이면 동등한 것으로 판단.)
        * */

    }
}
