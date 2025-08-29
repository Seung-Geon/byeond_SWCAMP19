package com.ohgiraffers.section03.sqlInjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/*
 * 인젝션(injection): 해킹 기법
 * 입력값으로 sql쿼리를 보내서 보안을 뚫어버리는 해킹
* */
public class Application1 {
    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";

    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "' AND EMP_NAME = '" + empName + "'";
//      -> "SELECT * FROM EMPLOYEE WHERE EMP_ID = '200' AND EMP_NAME = '' OR 1=1 AND EMP_ID = '200'

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()){
                System.out.println(empId + "사번 " + rset.getString("EMP_NAME") + "씨 조회 완료!");
            } else {  // NAME을 PW로 대체하면 비번을 모르는 채로 로그인 뚫은 것
                System.out.println("해당 사원이 없습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }

    }
}
