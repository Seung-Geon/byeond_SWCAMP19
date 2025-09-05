package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    /* 설명.
     *  필드의 @Autowired를 추가하면 필드를 통한 의존성 객체 주입(bean 주입)으로 필드 주입이라고 한다.
    * */
    @Autowired                  // 자동으로 주입 받음
//    private BookDAO bookDAO = new BookDAOImpl();
    private BookDAO bookDAO;    // 리플렉션 기술을 사용해서 대입해줌

    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    public BookDTO findBookBySequenceOf(int sequence) {
        return bookDAO.findBookBySequenceOf(sequence);
    }
}
