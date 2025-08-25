package com.ohgiraffers.section07.initblock;

public class Product {
    private String name = "아이폰";
    private int price;
    private static String brand;

    // initBlock(초기화 블럭)이라함
    // 위치는 변수와 생성자 사이에 위치: 어떤 객체가 생성되던 그 전에 해야할 알고리즘을 위해서 생성자 전에 위치해야 함.
    /* 설명. 초기화 블럭은 생성자 이전에 실행되며 어떤 생성자로 생성하든
     *  공통적인 로직이 있다면 작성
    * */
    {
        System.out.println("초기화 블럭 실행...");
        name = "폴드";
        price = 100;
        brand = "삼성";
    }

    static {
        //price = 200; //static 초기화 블럭에서 인스턴스 변수에 접근이 불가능하다.
        brand = "현대";
    }
    // 어떤 초기화블럭을 가지고 있든 생성자에서 뒤집을 수 있어서 잘 사용 안한다.
    public Product() {
        System.out.println("Product 기본 생성자 호출됨...");
        brand = "퓨리오사AI";
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}
