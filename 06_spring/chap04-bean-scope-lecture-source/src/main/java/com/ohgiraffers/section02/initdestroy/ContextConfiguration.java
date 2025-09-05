package com.ohgiraffers.section02.initdestroy;

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
    
    @Bean
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
    
    /* 설명. Bean 타입의 클래스에 정의된 메소드를 활용해서 bean 생성 및 소멸 시점에 호출할 수 있다. */
    @Bean(initMethod = "openShop", destroyMethod = "closeShop") // 로그 찍을 때 많이 사용
    public Owner owner() {
        return new Owner();
    }
}
