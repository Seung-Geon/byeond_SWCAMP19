package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 사용자 정의형 예외 클래스 정의 후 발생한 사용자 예외들을 처리할 수 있다. */
        /* 설명.
         *  catch 블럭은 이어서 여러개를 쓸 수 있다.
         *  (try 블럭 안에서 발생하는 예외 타입의 종류만큼 가능, 각 상황별로 예외 처리를 달리 할 수 있다.)
         *  try 블럭 안에서 예외가 발생하면 이후 try 블럭을 건너뛰고 catch 블럭을 순차적으로 타입 체크하며
         *  발생한 예외 타입과 일치하는 catch 블럭이 동작
         *   (자식 타입의 예외 타입을 가진 catch 블럭일수록 위쪽에 작성하고 부모타입일수록 아래쪽에 작성해야 한다.)
        * */
        ExceptionTest et = new ExceptionTest();

        /* 설명. 예외처리를 하면 우리가 원하는 데로 진행 됨(프로그램 종료 안되게, 그 외에 다양하게) */
        try {
            et.checkEnoughMoney(30000, 40000);
            et.checkEnoughMoney(-30000, 40000);
            et.checkEnoughMoney(30000, -40000);
            et.checkEnoughMoney(50000, 40000);
        }
        catch (PriceNegativeException e) {
            System.out.println("가격이 음수라니!");
        }
        /* 설명. multi-catch block */
        catch (MoneyNegativeException | NotEnoughMoneyException e) {
            System.out.println("너 빚쟁이야?");
            System.out.println("돈이 부족한걸?");
        }
//        catch (NotEnoughMoneyException e) {
//            System.out.println("돈이 부족한걸?")  ;
//        }
        catch(Exception e) {
            e.printStackTrace();
        } // 다형성에 입각해서 모든 에러를 받을 수 있음 -> 이보다 밑에 있는 자식 클래스 catch문은 의미 없어짐 -> 에러 => 부모 타입의 클래스는 아래로 빼야 됨

        System.out.println("프로그램을 종료합니다.");
    }
}
