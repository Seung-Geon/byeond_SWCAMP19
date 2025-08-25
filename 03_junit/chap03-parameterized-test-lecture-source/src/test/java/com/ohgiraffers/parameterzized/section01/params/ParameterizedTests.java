package com.ohgiraffers.parameterzized.section01.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Month;

public class ParameterizedTests {

    /* 설명. 1. @ValueSource를 이용한 parameter value 목록 지정 */
    @DisplayName("홀수 짝수 판별 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, -1, 15, 123})
    void testisOdd(int number) {

        // when
        boolean result = NumberValidator.isOdd(number);

        Assertions.assertTrue(result);
    }

    /* 설명. 2. @NullSource와 @EmptySource */
    @DisplayName("null값 확인")
    @ParameterizedTest
    @NullSource
    void testIsNull(String input) {
        boolean result = StringValidator.isNull(input);
        Assertions.assertTrue(result);
    }

    @DisplayName("Empty값 확인")
    @ParameterizedTest
    @EmptySource
    void testIsEmpty(String input) {
        boolean result = StringValidator.isEmpty(input);
        Assertions.assertTrue(result);
    }

    /* 설명. 3. 열거형을 이용한 @EnumSource 활용하기 */
    @DisplayName("Month enum에 정의된 1~12월 사이의 범위인지 테스트")
    @ParameterizedTest
    @EnumSource(Month.class)
    void testMonthValueIsCollect(Month month) {
        boolean result = DateValidator.isCollect(month);
        Assertions.assertTrue(result);
    }

    @DisplayName("2월, 4월, 6월, 9월, 11월을 제외한 달이 31일인지 확인")
    @ParameterizedTest
    @EnumSource(
            value = Month.class,
            names = {"FEBRUARY", "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"},
            mode = EnumSource.Mode.EXCLUDE
    )
    void testHasThirtyOneDayLong(Month month) {
        int varifyValue = 31;

        int actual = DateValidator.getlastDayOf(month);

        Assertions.assertEquals(varifyValue, actual);
    }
}
