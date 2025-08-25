package com.ohgiraffers.assertions.section02.assertj;

import java.util.Objects;

public class Member {
    private int sequence;
    private String id;
    private String name;
    private int age;

    public Member() {
    }

    public Member(int sequence, String id, String name, int age) {
        this.sequence = sequence;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "sequence=" + sequence +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return sequence == member.sequence && age == member.age && Objects.equals(id, member.id) && Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence, id, name, age);
    }
}
