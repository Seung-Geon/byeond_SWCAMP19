package com.ohgiraffers.section03.overriding;

public class SuperClass {

    /* 수업목표. 오버라이딩에 대해 이해할 수 있다. */
    public void method(int num) {}
    public Object method2(int num) {
        return null;
    }

    private void privateMethod() {}
    public final void finalMethod() {}

    /* 설명. protected: 자식 클래스이거나 동일 패키지에서만 보임 */
    protected void protectedMethod() {}
    /* 설명. default: 동일 패키지에서만 보임 */
    void defaultMethod() {}
}
