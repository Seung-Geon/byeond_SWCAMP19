package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MenuService {
    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    /* 설명. 1. findById(), Optional이 반환되는 점을 고려(get(), orElseXXX() */
    public MenuDTO findMenuByCode(int menuCode) {

        Menu menu = menuRepository.findById(menuCode)
                                  .orElseThrow(IllegalArgumentException::new);

        log.debug("Service계층에서 하나의 메뉴 상세보기: {}", menu);

        return modelMapper.map(menu,MenuDTO.class);
    }

    /* 설명. 2. findAll() (페이징 처리 전) */
    public List<MenuDTO> findMenuList() {
        
        /* 설명. 내가 원하는 속성에 대한 정렬 가능(feat. Sort.by) */
        List<Menu> menus = menuRepository.findAll(Sort.by("menuCode").descending());    // 역순으로 정렬

        log.debug("Service계층에서 모든 메뉴보기: {}", menus);

        return menus.stream()
                    .map(menu -> modelMapper.map(menu,MenuDTO.class))
                    .collect(Collectors.toList());
    }
}
