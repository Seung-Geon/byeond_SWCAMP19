package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {

        Connection con = getConnection();
        System.out.println("con = " + con);     // DB와의 연동 확인

        Statement stmt = null;                  // sql 및 쿼리 실행 결과를 싣고 dbms를 오가는 트럭같은 개념
        ResultSet rset = null;                  // 쿼리(select)의 결과(Java의 타입)

        /* 설명. Scanner를 활용해 사용자의 입력에 따른 사원 조회 */
        Scanner sc = new Scanner(System.in);
        System.out.print("조회하고자 하는 사원의 번호를 입력하세요: ");
        String empId = sc.nextLine();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'");
            if(rset.next()) {
                System.out.println("조회하신 " + empId + "번의 사원은 " + rset.getString("EMP_NAME") + "입니다.");
            } else {
                System.out.println("해당 " + empId + "번의 사원은 존재하지 않습니다.ㅣ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            /* 설명. 닫는 순서는 연 순서의 반대로 진행 */
            close(rset);
            close(stmt);
            close(con);
        }
    }
}