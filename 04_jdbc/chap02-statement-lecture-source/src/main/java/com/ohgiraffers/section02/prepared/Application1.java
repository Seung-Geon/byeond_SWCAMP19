package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rSet = null;

        try {
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");
            rSet = pstmt.executeQuery();

            while (rSet.next()) {
                System.out.println(rSet.getString("EMP_ID") + "사번의 " + rSet.getString("EMP_NAME") + "사원");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rSet);
            close(pstmt);   // PreparedStatement는 Statement의 자식 클래스라 다형성에 의해 기존 close() 활용 가능
            close(con);
        }

    }
}
