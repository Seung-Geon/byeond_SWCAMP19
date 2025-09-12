package com.ohgiraffers.section03.remix;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/* 설명. SqlSession 객체를 반환하는 Mybatis 관련 코드 모듈(모듈화) */
public class Template {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/menudb";
    private static String username = "swcamp";
    private static String password = "swcamp";

    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) {
            Environment environment = new Environment(
                    "dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(driver, url, username, password)
            );

            Configuration configuration = new Configuration(environment);
            
            /* 설명. Mapper용 인터페이스(feat. 쿼리 포함 인터페이스) 추가 */
            configuration.addMapper(MenuMapper.class);  // 인터페이스를 주면 알아서 하위 구현체를 만듬

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }

        return sqlSessionFactory.openSession(false);    // 싱글통하게 생성된 Factory에서 ConnectionPool에 있는 SqlSession 반환
    }
}
