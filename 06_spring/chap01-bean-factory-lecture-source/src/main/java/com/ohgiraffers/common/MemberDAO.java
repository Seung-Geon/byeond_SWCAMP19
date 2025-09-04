package com.ohgiraffers.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/* 설명. @Respotiroy도 @Component 계열이라 bean이 된다. */
@Repository     // @Component를 품고 있어 bean이 된다., 그 외의 추가적인 기능: DB를 오가며 DB에 에러가 발생하면 자바의 예외타입으로 변경해주는 부가기능이 있음
//@Component  // 해당 클래스는 bean이 될 것이다. -> 근데 이러면 스프링이 기본생성자를 호출 -> 기본 생성자가 만들어지는지 확인
public class MemberDAO {
    public MemberDAO() {
        System.out.println("콩 될때 이거 쓰나?");
    }
}
