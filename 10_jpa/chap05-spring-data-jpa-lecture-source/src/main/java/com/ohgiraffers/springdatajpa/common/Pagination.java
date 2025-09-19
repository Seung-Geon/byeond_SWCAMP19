package com.ohgiraffers.springdatajpa.common;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import org.springframework.data.domain.Page;

public class Pagination {

    public static PagingButtonInfo getPagingButtonInfo(Page page) {
        int currentPage = page.getNumber() + 1; // 인덱스 개념 -> 실제 페이지에 보여질 번호의 개념으로 다시 변경
        int defaultButtonCount = 10;            // 한 페이지에 보일 버튼의 개수
        int startPage;                          // 한 페이지에 보여질 첫 버튼
        int endPage;                            // 한 페이지에 보여질 마지막 버튼

        // 한번에 보이는 페이지를 하나의 묶음으로 봄
        // (현재 페이지) / (묶음 당 페이지 개수): 현재 몇번째 묶음인가?--
        // -1: 이전 묶음으로 이동
        // x 페이지 개수: 이전 묶음의 마지막 페이지로 이동
        // + 1 : 이전 묶음의 마지막 페이지 다음 페이지 -> 현재 묶음의 첫 페이지
//        startPage = (int)(Math.ceil(currentPage / (double)defaultButtonCount) - 1) * defaultButtonCount + 1;
        startPage = (int)((currentPage / (double)defaultButtonCount + 0.9) - 1) * defaultButtonCount + 1; // ceil을 하나 +0.9를 하나 동일

        // 한 묶음에 시작 페이지부터 끝페이까지 defaultButtonCount개
        // 하지만 마지막 페이지를 넘어가는 상황을 막기 위해 if로 막기
        endPage = startPage + defaultButtonCount - 1;

        /* 설명.  이 아래쪽 조건문들은 마지막 버튼이 축소되어야 될 2가지 경우 */

        /* 설명. 현재 페이지 버튼 그룹의 마지막 버튼이 전체의 마지막 페이지를 넘어가면 */
        if(page.getTotalPages() < endPage) endPage = page.getTotalPages();
                                // totalPage가 마지막 페이지보다 작으면
                                // totalPage가 마지막 페이지 버튼이 된다.

        // 게시판의 1페이지만 있는 경우 또는 게시글이 아예 없는 경우
        // startPage는 나오지만 endPage는 오류 발생
        /* 설명. 게시글이 없거나 한 페이지가 채 차지도 않을만큼의 item이 존재할 때 */
        if(page.getTotalPages() == 0) { // 1페이지도 안된다면
            endPage = startPage;        // startPage가 곧 endPage가 된다.(1페이지 버튼만 표시)
        }

        // 현재는 검색어가 없는 경우에 대한 처리
        // 검색어가 있는 경우와 검색어가 있는 경우 모두 처리해줘야 함
        return new PagingButtonInfo(currentPage, startPage, endPage);
    }
}
