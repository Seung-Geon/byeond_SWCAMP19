package com.ohgiraffers.section04.dto;

public class Application {
    public static void main(String[] args) {
        UserDTO user1 = new UserDTO();
        System.out.println(user1);

        UserDTO user2 = new UserDTO("user01", "pass01", "홍길동", new java.util.Date());
        System.out.println("user2 = " + user2);
        
        /* 설명. JSP, Spring Framework, Mybatis, ... 등에서 사용할 예정 */
        user2.setName("유관순");               //이걸 남발하면 직접 접근과 다를 바가 없기 때문에 사용을 지양
        System.out.println("user2 = " + user2.getName());
    }
}
