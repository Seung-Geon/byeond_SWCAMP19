package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";

        /* 설명. JDBC에서의 Connection 객체 같은 개념 */
        SqlSession session = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);  // 설계도

            SqlSessionFactory sqlSessionFactory                             // Connection 객체를 찍어내는 객체
                    = new SqlSessionFactoryBuilder().build(inputStream);    // builder는 바로 버려지므로 변수할당 X

            session = sqlSessionFactory.openSession(false);             // false를 주어야 수동 커밋 가능 (xml의 설정과 여기서 false 둘다 만족해야 수동 커밋 가능)

            java.util.Date nowDate = session.selectOne("mapper.selectNow"); // namespace.id: config에 올라온 mapper.xml에서
                                                                                // namespace를 찾고, 거기서 해당 id를 가지는 쿼리 실행하고 반환 타입은 resultType을 따름
            System.out.println("nowDate = " + nowDate);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(session!= null) session.close();
        }

    }
}
