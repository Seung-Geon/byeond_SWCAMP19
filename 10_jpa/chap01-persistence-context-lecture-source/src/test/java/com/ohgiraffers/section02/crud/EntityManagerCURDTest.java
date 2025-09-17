package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class EntityManagerCURDTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;


    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @Test
    public void 메뉴코드로_메뉴_조회_테스트() {
        int menuCode = 2;

        /* 설명. EntityManager를 통해 여러번 find를 해도 select은 한번만 동작한다.(feat. DB I/O 횟수 줄임) */
        Menu foundMenu = entityManager.find(Menu.class, menuCode);  // find의 두번째 인자는 무조건 PK만 가능
        Menu foundMenu2 = entityManager.find(Menu.class, menuCode);  // find의 두번째 인자는 무조건 PK만 가능

        /* 설명. 단정문은 두 개 이상 가능하며 동일성  보장 확인 */
        Assertions.assertNotNull(foundMenu);
        Assertions.assertEquals(foundMenu, foundMenu2); // jpa는 동일성을 보장한다.

        System.out.println("foundMenu = " + foundMenu);
    }

    @Test
    public void 새로운_메뉴_추가_테스트() {
        Menu menu = new Menu();
        menu.setMenuName("꿀발린 추어탕");
        menu.setMenuPrice(7000);
        menu.setCategoryCode(4);
        menu.setOrderableStatus("Y");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.persist(menu);    // 영속 상태로 바꿈
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Test
    public void 메뉴_이름_수정_테스트() {
        /* 설명. 31번 매뉴 엔티티를 영속 상태로 만들어 받은 다음 */
        Menu menu = entityManager.find(Menu.class, 31); // 영속성에 아무것도 없으므로 select 문 날려서 받아옴
        System.out.println("수정 전 menu = " + menu);

        String menuNameToChange = "갈치 스무디";

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            menu.setMenuName(menuNameToChange);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

    }

    @Test
    public void 메뉴_삭제하기_테스트() {
        Menu menuToRemove = entityManager.find(Menu.class, 31);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(menuToRemove);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

}
