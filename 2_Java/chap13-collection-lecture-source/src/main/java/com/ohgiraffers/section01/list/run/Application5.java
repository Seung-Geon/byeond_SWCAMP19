package com.ohgiraffers.section01.list.run;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Application5 {
    public static void main(String[] args) {

        /* 수업목표. Queue에 대해 이해하고 활용할 수 있다. */
//        Queue que = new Queue();            // 인터페이스라 구현하는 하위 타입으로 객체 생성해야 함
        Queue<String> que = new LinkedList<String>();   // LinkedList는 덱을 상속받음

        que.offer("first");
        que.offer("second");
        que.offer("third");
        que.offer("fourth");
        que.offer("fifth");
        System.out.println("que = " + que);

        System.out.println("peek() = " + que.peek());
        System.out.println("que = " + que);

        System.out.println("poll(): " + que.poll());
        System.out.println("poll(): " + que.poll());
        System.out.println("poll(): " + que.poll());
        System.out.println("poll(): " + que.poll());
        System.out.println("poll(): " + que.poll());
        System.out.println("que = " + que);

        /* 설명. PriorityQueue를 활용하면 정렬된 상태를 활용할 수 있다. */
        Queue<Integer> priorityQue = new PriorityQueue<>();

        priorityQue.offer(1);
        priorityQue.offer(3);
        priorityQue.offer(4);
        priorityQue.offer(5);
        priorityQue.offer(2);
        System.out.println("priorityQue = " + priorityQue); // 힙정렬 관련 트리에 저장된 순서로 나온 상태

        System.out.println(priorityQue.poll());
        System.out.println(priorityQue.poll());
        System.out.println(priorityQue.poll());
        System.out.println(priorityQue.poll());
        System.out.println(priorityQue.poll());
        System.out.println("priorityQue = " + priorityQue);


    }
}
