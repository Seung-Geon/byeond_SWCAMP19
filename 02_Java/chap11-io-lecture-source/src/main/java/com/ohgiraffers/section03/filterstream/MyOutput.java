package com.ohgiraffers.section03.filterstream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* 설명. 헤더 추가만 안되는 ObjectOutputStream 생성 */
public class MyOutput extends ObjectOutputStream {
    public MyOutput(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {

        /* 설명. 객체를 파일로 출력 시 헤더의 개념이 추가되지 않도록 기능 제거 */
    } // 헤더를 안쓰게 한다. -> 파일에 헤더가 2개가 되면 AC 에러가 나므로
}
