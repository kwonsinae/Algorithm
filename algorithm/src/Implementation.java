import java.util.Arrays;
import java.util.logging.Logger;

import java.util.*;
import java.util.Scanner;
public class Implementation {
    /**
     * 럭키스트레이트
     * https://www.acmicpc.net/problem/18406
     */
    public void solutionLucky() {

        // 입력 받아서
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();

        int check = 0;

        // 입력 받은 스트링 체크
        for (int i = 0; i < number.length(); i++) {
            // 길이가 절반 이하일때 플러스
            if (i < number.length() / 2) check += (int) number.charAt(i);
                // 이후는 마이너스
            else check -= (int) number.charAt(i);
        }

        // 0 이면 같은 값으로 럭키 아니면 래디
        System.out.println(check == 0 ? "LUCKY" : "READY");
    }

    /**
     * 뱀
     * https://www.acmicpc.net/problem/3190
     * 시간 증가 , 방향 체크
     * 이동시 벽과 만나면 break;
     * 이동시 뱀과 만나면 break;
     * 이돌 위치 체크
     * 이동시 사과 없으면 꼬리 따라옴
     * 방향 전환 지점 일 시 방향 재 설정
     */
    public void solutionSnake() {
        /////////////  입력
        Scanner scanner = new Scanner(System.in);

        // 보드 사이즈 입력 후 보드 생성
        int boardSize = scanner.nextInt();
        int[][] board = new int[boardSize][boardSize];

        // 사과 사이즈 입력 후 사과 위치 체크
        int appleSize = scanner.nextInt();
        for (int i = 0; i < appleSize; i++) {
            // 인덱스가 1 차이나니까 뺴줌
            board[scanner.nextInt() - 1][scanner.nextInt() - 1] = 2;
        }

        // 방향은 맵으로 받아서 저장
        int moveSize = scanner.nextInt();
        HashMap<Integer, Integer> movePoints = new HashMap<>();
        for (int i = 0; i < moveSize; i++) {
            movePoints.put(scanner.nextInt(), scanner.next().equals("L") ? 1 : -1);
        }
        /////////////  입력


        int time = 0;
        int direction = 0;

        Queue snakeQueue = new LinkedList();

        int i = 0;
        int j = 0;
        board[i][j] = 1;
        snakeQueue.add(new int[]{0, 0});

        while (true) {

            time++;

            switch (direction) {
                case 0: j++; break;
                case 1: i--; break;
                case 2: j--; break;
                case 3: i++; break;
            }

            if (j >= boardSize || j < 0 || i >= boardSize || i < 0) break;
            if (board[i][j] == 1) break;

            board[i][j] = 1;
            snakeQueue.add(new int[]{i, j});

            if (board[i][j] != 2) {
                int[] tail = (int[]) snakeQueue.poll();
                board[tail[0]][tail[1]] = 0;
            }

            if (movePoints.get(time) != null) {
                direction += movePoints.get(time);
                if (direction < 0) direction = 3;
                else if (direction > 3) direction = 0;
            }
        }

        System.out.println(time);
    }

    /**
     * 문자열 압축
     * https://programmers.co.kr/learn/courses/30/lessons/60057
     * 1 부터 전체길이의 절반 까지로 압출길이 설정
     * subString 시작 지점 종료 지점 설정
     * 종료 지점 + 압축 길이 가 전체 보다 길면 break
     * 자를 수 있으면 비교 해서 같은 단어면 count ++
     * 다른 단어면 len 계산하고 count 초기화
     * 더 작은 길이 저장한 뒤 압축 길이 증가
     *
     * @return
     */
    public int solution(String s) {
        int minLength = s.length();

        for (int i = 1; i <= Math.round(s.length() / 2); i++) {

            int count = 1;
            int len = 0;
            int j = 0;

            while (true) {
                int begin = j;
                int end = j + i;

                if (end + i > s.length()) {
                    end = s.length();
                    len += end - begin;
                    if (count > 1) len += (int) (Math.log10(count) + 1);
                    break;
                }

                if (s.substring(begin, end).equals(s.substring(end, end + i))) {
                    count++;
                } else {
                    len += end - begin;
                    if (count > 1) len += (int) (Math.log10(count) + 1);
                    count = 1;
                }
                j += i;
            }

            minLength = Math.min(len, minLength);
        }
        return minLength;
    }

    /**
     * 자물쇠와 열쇠
     * https://programmers.co.kr/learn/courses/30/lessons/60059
     * 자물쇠의 범위는 1 - (열쇠의 전체길이) 부터 (열쇠의 전체길이 + 자물쇠의 전체길이) - 1 의 정사각형
     * 자물쇠 배열 복사 하여 임시 배열 생성. 해당 위치에서 키 배열과 합친다.
     * 자물쇠의 index 값이 벗어나면 합치지 않는다.
     * 키의 배열만큼 합치기가 끝나면 임시 배열이 전체 1 인지 확인한다.
     * 맞지 않으면 방향을 회전 하여 확인한다.
     * 네 방향 모두 확인했는데도 맞지 않으면 다음 캄으로 옮겨간다.
     */
    private int[][] lock;
    private int[][] key;

    public Boolean solution(int[][] key, int[][] lock) {

        this.key = key;
        this.lock = lock;

        for (int i = 1 - key.length; i < key.length + lock.length - 1; i++) {
            for (int j = 1 - key.length; j < key.length + lock.length - 1; j++) {
                if (isOpenAble(i, j)) return true;
            }
        }

        return false;
    }

    private Boolean isOpenAble(int lockI, int lockJ) {
        boolean isOpenAble = true;

        int direction = 0;
        while (direction < 4) {
            isOpenAble = true;

            int[][] temp = new int[lock.length][lock.length];
            for (int i = 0; i < lock.length; i++) {
                for (int j = 0; j < lock.length; j++) {
                    temp[i][j] = lock[i][j];
                }
            }

            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key.length; j++) {

                    int tempI = lockI + i;
                    int tempJ = lockJ + j;

                    if (tempI >= lock.length || tempJ >= lock.length || tempI < 0 || tempJ < 0) continue;

                    switch (direction) {
                        case 0: temp[tempI][tempJ] += key[i][j]; break;
                        case 1: temp[tempI][tempJ] += key[key.length - j - 1][i]; break;
                        case 2: temp[tempI][tempJ] += key[key.length - i - 1][key.length - j - 1]; break;
                        case 3: temp[tempI][tempJ] += key[j][key.length - i - 1]; break;
                    }
                }
            }

            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp.length; j++) {
                    if (temp[i][j] != 1) isOpenAble = false;
                }
            }
            if (isOpenAble) break;

            direction++;
        }
        return isOpenAble;
    }

}

// 자물쇠와 열쇠
//    Boolean result = implementation.solution(key , lock);
////	[[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
//        Implementation implementation = new Implementation();
//        int[][] key = {
//                {0, 0, 0},
//                {1, 0, 0},
//                {0, 1, 1}
//        };
//        int[][] lock = {
//                {1, 1, 1},
//                {1, 1, 0},
//                {1, 0, 1}
//        };
//
//        for (int r = 0; r < lock.length; r++) {
//        String s = "";
//        for (int c = 0; c < lock.length; c++) {
////                s += r + "" + c + " ";
//        s += lock[r][c] + " ";
//        }
//        System.out.println(s);
//        }
//        System.out.println("=====================");
//
//        for (int r = 0; r < key.length; r++) {
//        String s = "";
//        for (int c = 0; c < key.length; c++) {
////                s += r + "" + c + " ";
//        s += key[r][c] + " ";
//        }
//        System.out.println(s);
//        }
//        System.out.println("=====================");
//        for (int r = 0; r < key.length; r++) {
//        String s = "";
//        for (int c = 0; c < key.length; c++) {
////                s += (key.length - c -1) + "" + r + " ";
//        s += key[key.length - c -1][r] + " ";
//        }
//        System.out.println(s);
//        }
//        System.out.println("=====================");
//        for (int r = 0; r < key.length; r++) {
//        String s = "";
//        for (int c = 0; c < key.length; c++) {
////                s += (key.length - r -1) + "" + (key.length - c -1) + " ";
//        s += key[key.length - r - 1][key.length - c -1] + " ";
//        }
//        System.out.println(s);
//        }
//        System.out.println("=====================");
//        for (int r = 0; r < key.length; r++) {
//        String s = "";
//        for (int c = 0; c < key.length; c++) {
////                s += c + "" + (key.length - r - 1) + " ";
//        s += key[c][key.length - r - 1] + " ";
//        }
//        System.out.println(s);
//        }
//        System.out.println("=====================");

// 문자열 압축
//    public int solution(String s) {
//        // 최대길이
//        int minLength = s.length();
//
//        for (int i = 1; i <= Math.round(s.length() / 2); i++) {
//
//            String zip = "";
//
//            int count = 1;
//            int j = 0;
//            while (true) {
//                int begin = j;
//                int end = i + j;
//                if (end + i > s.length()) {
//                    if (count > 1) zip += count + s.substring(begin, end);
//                    else zip += s.substring(begin);
//                    break;
//                } else {
//                    if (s.substring(begin, end).equals(s.substring(end, end + i))) {
//                        count++;
//                    } else {
//                        if (count > 1) zip += count + s.substring(begin, end);
//                        else zip += s.substring(begin, end);
//                        count = 1;
//                    }
//                    j += i;
//                }
//            }
//
//            minLength = Math.min(zip.length(), minLength);
//        }
//
//
//        return minLength;
//    }
//
//    public int solution(String s) {
//        // 최대길이
//        int minLength = s.length();
//
//        // 1 부터 2등분 길이 까지 자를 수 있다
//        for (int i = 1; i <= Math.round(s.length() / 2); i++) {
//
//            // 같은 단어의 수
//            int count = 1;
//
//            // 압축된 문장의 길이
//            int len = 0;
//
//            // subString 위치
//            int j = 0;
//
//            while (true) {
//
//                // subString 시작 지점
//                int begin = j;
//
//                // subString 종료 지점
//                int end = j + i;
//
//                // 종료 지점 + 자를 수 있는 길이가 전체 String 보다 길면 더이상 비교 불가
//                // len 계산 해서 break;
//                if (end + i > s.length()) {
//                    end = s.length();
//                    len += end - begin;
//                    if (count > 1) len += (int) (Math.log10(count) + 1);
//                    break;
//                }
//
//                // 자를 수 있으면 잘라서 비교
//                if (s.substring(begin, end).equals(s.substring(end, end + i))) {
//                    // 같은 단어면 count ++;
//                    count++;
//                } else {
//                    // 다른 단어면 len 계산 count 초기화
//                    len += end - begin;
//                    if (count > 1) len += (int) (Math.log10(count) + 1);
//                    count = 1;
//                }
//                // j 는 자를 수 있는 만큼 증가
//                j += i;
//            }
//
//            // 더 작은 길이로 저장
//            minLength = Math.min(len, minLength);
//        }
//        return minLength;
//    }