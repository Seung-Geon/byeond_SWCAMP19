package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();
        System.out.println("con = " + con);     // DB와의 연동 확인

        Statement stmt = null;                  // sql 및 쿼리 실행 결과를 싣고 dbms를 오가는 트럭같은 개념
        ResultSet rset = null;                  // 쿼리(select)의 결과(Java의 타입)
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery("SELECT * FROM EMPLOYEE");

            while(rset.next()) {    // next 호출마다 ResultSet의 다음 행을 가리킴
                /* 설명. 반복문 안에서는 단일행을 하나하나 컬럼별로 꺼내쓴다. */
                System.out.println(rset.getString("EMP_NAME") + ", " + rset.getInt("SALARY"));  // rset이 가리키고 있는 행에 대해 작동
                                                                            // ResultSet이 제공하는 메소드를 통해 DB의 자료형을 Java의 자료형으로 매핑
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

/* 설명. Connection이 열린 순간부터 닫힐 때까지가 하나의 Transaction */