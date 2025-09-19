package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<[엔티티타입],[PK 타입]>
public interface MenuRepository extends JpaRepository<Menu, Integer> {


}
