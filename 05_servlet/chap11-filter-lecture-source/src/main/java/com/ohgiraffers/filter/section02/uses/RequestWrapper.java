package com.ohgiraffers.filter.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request the {@link HttpServletRequest} to be wrapped.
     * @throws IllegalArgumentException if the request is null
     */
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String key) {
//        return super.getParameter(key);

        String value = "";
        if("password".equals(key)){
            /* 설명. key 값으로 'password''가 넘어오면 Bcrypt 암호화 진행 */
            BCryptPasswordEncoder passwordEncoder = new  BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter("password"));
            System.out.println("암호화된 값: " + value);
        } else {
            value = super.getParameter(key);
        }

        return value;
    }
}
