package com.ohgiraffers.section06.statickeyword;

public class StaticTest {
    private int nonStaticCount;

    //객체와 관련없는 변수
    private static int staticCount;

    public StaticTest() {
    }

    public int getNonStaticCount() {
        return nonStaticCount;
    }

    public int increaseNonStaticCount() {
        return this.nonStaticCount++;
    }

    public static int getStaticCount() {
        return StaticTest.staticCount;
    }

    public static int increaseStaticCount() {
        return staticCount++;
    }
}
