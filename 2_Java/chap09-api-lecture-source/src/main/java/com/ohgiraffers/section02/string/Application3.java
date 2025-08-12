package com.ohgiraffers.section02.string;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. String 클래스의 자주 사용하는 메소드를 숙지하고 응용할 수 있다. */
        /* 설명. 1. charAt() */
        String str1 = "apple";
        for (int i = 0; i < str1.length(); i++) {
            System.out.println("charAt (" + i + "): " + str1.charAt(i));
        }

        /* 설명. 2. compareTo(): 문자열의 차이를 양수, 0, 음수로 반환 */
        String str2 = "java";
        String str3 = "java";
        String str4 = "JAVA";
        String str5 = "mariaDB";
        System.out.println(str2.compareTo(str3));   // 사전식으로 앞글자부터 비교해서 어떤게 더 먼저인가
                                                    // 오든 정렬은 오름차순이 기본
        System.out.println(str3.compareTo(str4));   // 문자끼리 빼기 -> 0이 아니면 멈춤
        System.out.println((int)'j');               // 0: 두 문자가 동일
        System.out.println((int)'J');               // 음수: 현재 오름차순
        System.out.println((int)'j'-'J');           // 양수: 현재 내림차순
        System.out.println(str3.compareTo(str5));

        /* 설명. 3. concat() */
        System.out.println("concat(): " + str2.concat(str5)); // 문자열 합쳐서 새로운 객체 만들기

        /* 설명. 4. indexOf() */
        String str6 = "java mariaDB";
        System.out.println("indexOf('a'): " + str6.indexOf('a')); // 문자열이 있는 인덱스 반환(무조건 가장 왼쪽의 것)
        System.out.println("indexOf('z'): " + str6.indexOf('z')); // 원하는 문자가 없으면 -1 반환
        /* 설명. 2번 인덱스부터 우측으로 'a'를 찾아서 발견한 위치의 index값 반환 */
        System.out.println("indexOf('a', 2): " + str6.indexOf('a', 2)); // 원하는 인덱스부터 찾기

        /* 설명. 5. trim(): 공백 제거 */
        String trimStr = "          java           ";
        System.out.println("trimStr: #" + trimStr + "#");
        System.out.println("trimStr: #" + trimStr.trim() + "#");

        /* 설명. 6. toLowerCase() / toUpperCase() */
        String caseStr = "javamariaDB";
        System.out.println("toLowerCase(): " + caseStr.toLowerCase());  // 알파벳 소문자화
        System.out.println("toUpperCase(): " + caseStr.toUpperCase());  // 알파벳 대문자화

        /* 설명. substring() */
        String javamariaDB = "javamariaDB";
        System.out.println("subString(3, 6): " + javamariaDB.substring(3, 6)); // 3인덱스부터 6인덱스 까지 잘라서 반환(3, 4, 5)
        System.out.println("subString(3): " + javamariaDB.substring(3)); // 3인덱스부터 끝까지 잘라서 반환

        /* 설명. 8. replace(): 값을 치환 */
        System.out.println("replace(): " + javamariaDB.replace("java", "python"));
        System.out.println("javamariaDB: " + javamariaDB); // 원본에 영향X

        /* 설명. 9. length() */
        System.out.println("length(): " + javamariaDB.length());
        System.out.println("빈 문자열의 길이" + "".length());

        /* 설명. 10. isEmpty() */
        System.out.println("isEmpty(): " + "".isEmpty());
        System.out.println("isEmpty(): " + "abc".isEmpty());

        /* 설명. 11. startsWith() */
        System.out.println("startsWith(): " + "abcdef".startsWith("ab")); // 넣은 문자열로 시작하는 가
        System.out.println("startsWith(): " + "abcdef".startsWith("def"));

    }
}
