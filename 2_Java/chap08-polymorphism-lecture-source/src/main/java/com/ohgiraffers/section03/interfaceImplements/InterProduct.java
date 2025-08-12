package com.ohgiraffers.section03.interfaceImplements;

public interface InterProduct extends ParentInterProduct, AnotherInterProduct {

    /* 설명. 상수 필드 */
    public static final int MAX_NUM = 100;
    int MIN_NUM = 1;        // 기본으로 하면 'public static final' 이 생략된것

    /* 설명. 인터페이스는 생성자를 가지지 않는다. */

    /* 설명. 추상 메소드(feat. public abstract) */
    public abstract void nonStaticMethod(int num);
    void nonStaticMethod2();        // 동일하게 public abstract가 생략된 것

    /* 설명. JDK 1.8부터 추가된 body가 있는 메소드들 */
    /* 설명. static 메소드 */
    public static void staticMethod(){}

    /* 설명. non-static 메소드 */
    default void defaultMethod() {}

    /* 설명. private 접근 제어자 메소드 */
    private void privateMethod() {} // private는 위의 default나 static에서 쓰라고 있는 것. 쓰는 것을 권장X

}
