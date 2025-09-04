package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/* 설명. . 기본적으로는 설정파일이 있는 패키지 및 하위만 Scan 하지만 basePackage를 바꾸면 다른 범위도 가능하다. */
//@ComponentScan(basePackages = "com.ohgiraffers")
//@ComponentScan(basePackages = {"com.ohgiraffers.common", "com.ohgiraffers.section01"})  // 이렇게 개별 패키지로 설정을 할 수 있음
/* 설명. 2. 범위 및 필터를 적용해서 제외하고 bean을 등록하는 경우(excludeFilters) */
//@ComponentScan(basePackages = "com.ohgiraffers",
//                excludeFilters = {
//                    @ComponentScan.Filter(
//                /* 설명. 2-1. 타입으로 설정 */
////                       type = FilterType.ASSIGNABLE_TYPE,
////                       classes = {MemberDAO.class}
//                /* 설명. 2-2. 어노테이션 종류로 설정 */
//                            type = FilterType.ANNOTATION,
//                            classes = {org.springframework.stereotype.Repository.class}
//                    )
//                })

/* 설명. 3. 범위 및 필터를 적용해서 포함(등록)하고자 하는 bean을 등록하는 경우(includeFilters) */
@ComponentScan(basePackages = "com.ohgiraffers",
                useDefaultFilters = false,      // 현재 범위의 bean들은 일단 모두 off
                includeFilters = {
                    @ComponentScan.Filter(
                        type=FilterType.ASSIGNABLE_TYPE,
                        classes = {MemberDAO.class}     // MemberDAO 타입만 등록
                    )
                })
public class ContextConfiguration {
}
