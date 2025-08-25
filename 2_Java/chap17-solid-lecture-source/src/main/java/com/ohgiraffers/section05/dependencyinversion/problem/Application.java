package com.ohgiraffers.section05.dependencyinversion.problem;


/* 설명.
 *  의존성 역전 원칙(Dependency Inversion Principle)
 *  - 고수준 모듈은 저수준 모듈을 의존해서는 안된다.(둘 다 추상화에 의존해야 한다.)
 *  - 추상화는 세부 사항에 의존해서는 안된다. 세부 사항이 추상화에 의존해야 한다.
* */
public class Application {
    public static void main(String[] args) {
        BadNotificationService badService = new BadNotificationService();
        badService.sendNotification(1, "중요 공지사항입니다.");  //1은 email
        badService.sendNotification(2, "중요 공지사항입니다.");  //2는 SMS

    }
}

/*
 * MemberService와 MemberRepository
 * private final memberRepository = new MemberRepository(); -> 좋은 코드X
 * Service가 객체가 되려면 항상 Repository가 있어야 한다. -> 의존 관계(아주 강한 결합 상태)
 * 의존 대상이 다른 것으로 변경된다면? -> 코드 전체 수정이 필요
 * 필드가 다른 클래스를 필요로 하면 의존 관계라 함
 *  -> 이러한 의존 관계를 부시기 위해서 중간에 인터페이스를 사용
 *
 * Repository <<interface>> 를 만들어서 MemberRepository가 구현하게 만듬
 * MemberService의 필드는
 *  private final Repository repository = new MemberRepository(); 로 변경
 *   => 직접 의존이 아니라 Repository 타입이면 되므로 하위 구현체는 신경 안쓰게 만듬
 *
 * 의존 -> 의존 대상에 변경이 생기면 의존 관계인 모든 코드가 영향을 받음
 * 중간에 인터페이스를 넣음으로써 MemberRepository가 변경된다고 해서 Service가 영향을 받지 않음
 *
* */