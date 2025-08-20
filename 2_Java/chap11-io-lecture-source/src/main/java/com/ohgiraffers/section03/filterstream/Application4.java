package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;

import java.io.*;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표. 객체 단위의 입출력을 이해할 수 있다. */
        MemberDTO[] members = new MemberDTO[50];
        members[0] = new MemberDTO("user01", "pass01", "홍길동", "hong123@gmail.com", 25, '남');
        members[1] = new MemberDTO("user02", "pass02", "유관순", "korea31@gmail.com", 16, '여');
        members[2] = new MemberDTO("user03", "pass03", "강감찬", "kang@gmail.com", 38, '남');

        String path = "src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt";

        File file = new File(path);
        ObjectOutputStream oos = null;
        try {
            if(!file.exists()) {
                oos = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(path)
                        )
                );
            } else {
                oos = new MyOutput(
                        new BufferedOutputStream(
                                new FileOutputStream(path, true)
                        )
                );
            }
            for(int i = 0; i < 3; i++){     // 내보내는 객체의 갯수를 출력하는 객체 만큼만 반복
                oos.writeObject(members[i]);
                oos.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        MemberDTO[] newMembers = new MemberDTO[members.length];

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(path)
                    )
            );

//            newMembers[0] = (MemberDTO) ois.readObject();
//            newMembers[1] = (MemberDTO) ois.readObject();
//            newMembers[2] = (MemberDTO) ois.readObject();
            int index = 0;
            while(true){
                Object obj = ois.readObject();
                if(obj instanceof MemberDTO){
                    newMembers[index] =  (MemberDTO)obj;
                }
                index++;
            }

        } catch (EOFException e) {
            System.out.println("회원 읽기 끝");
        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("==== 읽어드린 회원들 ====");
        for(MemberDTO member: newMembers) {
            System.out.println(member);
        }
    }
}
