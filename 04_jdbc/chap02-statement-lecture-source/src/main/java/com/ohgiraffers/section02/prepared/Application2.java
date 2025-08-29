package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rSet = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회 할 사번을 입력하세요: ");
        String empId = sc.nextLine();

        System.out.print("퇴사 여부까지 입력하세요: ");
        String empYn = sc.nextLine();


        try {
            /* 설명. ?(placeholder)를 사용하면 1. 가독성 증가(하나의 문자열), 2. 전처리 가능, 3. Statement 대비 속도 향상*/
            pstmt =  con.prepareStatement(
                    "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = ?");
            /* 설명. ?인 placeHolder의 위치별로 들어갈 값들을 setter를 이용해 매꿔준다. */
            pstmt.setString(1, empId);  // 매꿀 자료형 맞춰서 set사용
            pstmt.setString(2, empYn);  // 몇번째 ?를 채울 것인가, 어떤 변수를 넣을 것인가

            rSet = pstmt.executeQuery();
            if (rSet.next()) {
                System.out.println("입력하신 " + empId + "번 사원은 " + rSet.getString("EMP_NAME") + "이고, 월급은 " + rSet.getInt("SALARY") + "입니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rSet);
            close(pstmt);
            close(con);
        }

    }
}
