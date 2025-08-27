package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.*;

public class Application2 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    /* 설명. 상하좌우로 붙어 있는 배추들이 쌓일 큐 */
    static Queue<Node> q = new LinkedList<>();

    /* 설명. 방향 벡터 */
    static int[] dx = {0, 0, -1, 1};    // 상하좌우를 위한 x좌표
    static int[] dy = {1, -1, 0, 0};    // 상하좌우를 위한 y좌표

    /* 설명. 배추밭 */
    static int[][] map;

    /* 설명. 방문 배열 */
    static boolean[][] visit;   // 양방향 관계이거나 대각선에 대칭되는 표가 아니다.

    /* 설명. 현재 위치(지렁이 투척 이후 사용하는 좌표) */
    static int curr_x, curr_y;

    /* 설명. 배추밭의 크기(너비/높이), 심어진 배추의 수 */
    static int M, N, K;

    /* 설명. 필요한 배추흰지렁이의 마리 수 */
    static int count;

    /* 설명. 이 문제를 풀기 위해서 배추 하나하나를 Node 객체로 다룸 */
    private static class Node {

        /* 설명. 자신의 좌쵸를 두 개의 필드로 가짐 */
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   // 배추밭의 너비
        N = Integer.parseInt(st.nextToken());   // 배추밭의 높이
        K = Integer.parseInt(st.nextToken());   // 심어진 배추 수

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[y][x] = 1;  // 행렬은 x, y좌표와 반대
        }

//        /* 설명. static 변수는 메소드 호출마다 초기화 되는 것이 아닌 누적이 되어브리므로 명시적으로 0으로 초기화 */
        /* 설명. 현재 우리가 테스트 케이스들을 여러개를다룰 때 최기화 해야 될 static 변수는 초기화 해 주어야 함 */
        count = 0;  // 지렁이 수 초기화

        for (int i = 0; i < N; i++) {       // 열, 배추밭의 세로
            for (int j = 0; j < M; j++) {   // 행, 배추밭의 가로
                if(visit[i][j] == false && map[i][j] == 1) {
                    count++;

                    bfs(j, i);

//                    System.out.println(count + "번째 지렁이 투척 후");
//                    for (int k = 0; k < visit.length; k++) {
//                        System.out.println(Arrays.toString(visit[k]));
//                    }
//                    System.out.println();
                }

            }
        }


        return count;
    }

    /* 설명. 현재 좌표에서 상하 좌우를 둘러보고 방문하지 않았고 또 다른 배추가 심어져 있는지 확인 */
    /* 설명. 여기서 방문배열은 배추가 심어지 ㄴ위치상에서 방문한 것들만 해당 */
    private static void bfs(int x, int y) {
        /* 설명. 지렁이를 뿌린 후 지렁이가 커버할 수 있는 배추들을 que에 담기 시작 */
        q.offer(new Node(x, y));
        visit[y][x] = true;
        
        /* 설명. que에서 하나의 배추(노드)를 꺼내서 상하좌우로 붙어 있는 배추를 que에 추가 */
        while(!q.isEmpty()) {
            Node node = q.poll();

            /* 설명. que에서 나온 배추의 상하좌우를 둘러보는 로직 */
            for (int i = 0; i < 4; i++) {
                curr_x = node.x + dx[i];
                curr_y = node.y + dy[i];

                if(range_check() && !visit[curr_y][curr_x] && map[curr_y][curr_x] == 1) {
                    q.offer(new Node(curr_x, curr_y));          // 주변을 둘러보고 유효한지 확인하고 que에 담는다.
                    visit[curr_y][curr_x] = true;
                }
            }
        }
        
    }

    /* 설명. 지금 보는 위치(curr_x, curr_y)가 배추밭의 범위를 벗어나는지 유효성 검사용 메소드 */
    private static boolean range_check() {
        return curr_x >= 0 && curr_x < M && curr_y >= 0 && curr_y < N;
    }
}
