package com.ohgiraffers.section01.scope.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {
    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 1500);
    }

    /* 설명.
     *  bean 스코프를 수정하게 되면 bean의 life cycle을 다른 주기로 가져갈 수 있다.
    * */
    @Bean
//    @Scope("singleton")   // 싱글톤으로 사용 - 기본 세팅
    @Scope("prototype")     // 매번 새로운 bean 객체 할당 - 모든 사용자가 싱글톤으로 사용하면 병목이 발생할 수 있음
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
