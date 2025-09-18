package com.ohgiraffers.section01.manytoone;

import jakarta.persistence.*;

@Entity(name = "menu_and_category")
@Table(name = "tbl_menu")
public class MenuAndCategory { // 카테고리와 조인이 가능한 Menu 엔티티
    @Id
    @Column(name = "menu_code")
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;


    /* 설명.
     *  FetchType.LAZY(지연 로딩)와 FetchType.EAGER(즉시 로딩)
     *  1. FetchType.EAGER는 연관관계를 미리 고려해서 해당 엔티티와 조인하는 쿼리가 작성됨
     *     (통산 조인)
     *  2. FetchType.LAZY는 연관관계를 나중에 필요한 시점에 고려하여 따로 select을 날려서
     *     추가하는 개념(나중에 해당 필드를 접근하면 쿼리가 따로 발생)
     *     (toString()에서 접근하는 것도 해당되므로 고려할 것) ->  N+1 문제: 무언가를 조회하면 부가적으로 가져온다.
     *
     *
    * */
    @ManyToOne(fetch = FetchType.LAZY)  // 메뉴 -> 카테고리의 전체 카디널리티
                                        // FetchType.LAZY: 나중에 필요한 시점에 가져와서 join 한다는 것
                                        //   -> menu만 select 하고, category가 필요한 시점에 category를 select 해오는 것
                                        //   여기서는 toString에 category가 있으면 toString이 호출된 시점에 category 테이블을 select 해옴
    @JoinColumn(name = "category_code") // FK 제약 조건이 있는 컬럼(자식 테이블에 있는 컬럼명만 쓴다.)
    private Category category;          // 메뉴 1개가 카테고리 엔티티 객체 몇개를 가지는지(List<타입>/타입)
                                        // "메뉴 left join 카테고리" 형식으로 날아감
    @Column(name = "orderable_status")
    private String orderableStatus;

    public MenuAndCategory() {
    }

    public MenuAndCategory(int menuCode, String menuName, int menuPrice, Category category, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuAndCategory{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
//                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}

