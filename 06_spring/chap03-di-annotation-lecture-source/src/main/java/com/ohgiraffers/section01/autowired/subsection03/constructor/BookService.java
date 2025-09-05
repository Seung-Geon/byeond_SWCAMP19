package com.ohgiraffers.section01.autowired.subsection03.constructor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("constructorService")
public class BookService {
    private final BookDAO bookDAO;

    /* 설명.
     *  BookDTO 타입의 빈 객체를 생성자를 통해 주입 받는다.
     *  (기본 생성자 사용 X)
     *
     * 설명.
     *   생성자 주입의 이점
     *   1. 필드에 final 키워드 사용 (값의 오염 방지)
     *   2. 순환참조를 스프링 시작(컨테이너 생성 시)과 동시에 확인하고 에러를 발생시켜 준다.
     *   3. field 주입 및 setter 주입의 단점을 보완
     *      (필드 주입은 같결하지만 남용할 수 있고 이후에 setter가 없이는 수정이 불가능하다.)
     *      (필드 주입과 setter 주입은 수정할 수 있게 할 때 사용)
     *      (setter를 많이 사용하는 것은 안티 패턴, 값의 예측에 대한 확신을 가지고 수정할 수 없음)
     *      (setter 주입은 불변 객체를 만들고자 함에 있어 문제가 발생할 수 있으면 정말 필요한 객체의 속성 변경을 위해서만 setter를 추가하는 것이 맞다.(feat. 가급적 변경의 여지를 남기지 않아야 한다.))
     *   4. 테스트 코드 작성이 용이하다.(생성자 주입은 @InjectMocks를 사용하지 않고 그 자리에서 객체를 생성해서 쉽게 핡 수 있음) (Mockito 라이브러리)
    * */

    //생성자 권장의 가장 큰 이유: final -> 주입된 콩은 변경되지 않는다는 확신
    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    public BookDTO findBookBySequenceOf(int sequence) {
        return bookDAO.findBookBySequenceOf(sequence);
    }
}
