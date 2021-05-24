import java.util.Arrays;
import java.util.logging.Logger;

public class Implementation {

    /**
     * 문자열 압축
     * https://programmers.co.kr/learn/courses/30/lessons/60057
     *
     * @return
     */
//    public int solution(String s) {
//        // 최대길이
//        int minLength = s.length();
//
//        for (int i = 1; i <= Math.round(s.length()/2); i++){
//
//            String zip = "";
//
//            int count = 1;
//            int j = 0;
//            while (true) {
//                int begin = j;
//                int end = i + j;
//                if(end + i > s.length()){
//                    if (count > 1) zip += count + s.substring(begin, end);
//                    else zip += s.substring(begin);
//                    break;
//                }else {
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
//            minLength = Math.min(zip.length() , minLength);
//        }
//
//
//        return minLength;
//    }
//}
//    public int solution(String s) {
//        int minLength = s.length();
//
//        for (int i = 1; i <= Math.round(s.length() / 2); i++) {
//
//            int count = 1;
//            int len = 0;
//            int j = 0;
//
//            while (true) {
//                int begin = j;
//                int end = j + i;
//
//                if (end + i > s.length()) {
//                    end = s.length();
//                    len += end - begin;
//                    if (count > 1) len += (int) (Math.log10(count) + 1);
//                    break;
//                }
//
//                if (s.substring(begin, end).equals(s.substring(end, end + i))) {
//                    count++;
//                } else {
//                    len += end - begin;
//                    if (count > 1) len += (int) (Math.log10(count) + 1);
//                    count = 1;
//                }
//                j += i;
//            }
//
//            minLength = Math.min(len, minLength);
//        }
//        return minLength;
//    }

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
//

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/60059
     * 자물쇠와 열쇠
     */
    private int[][] lock;
    private int[][] key;
    public Boolean solution(int[][] key, int[][] lock) {

        this.key = key;
        this.lock = lock;

        for(int i = 1 - key.length; i < key.length + lock.length - 1 ; i ++){
            for(int j = 1 - key.length; j < key.length + lock.length - 1 ; j ++){
                if(isOpenAble(i , j)) return true;
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

                    if(tempI >= lock.length || tempJ >= lock.length || tempI < 0 || tempJ < 0) continue;

                    switch (direction) {
                        case 0:
                            temp[tempI][tempJ] += key[i][j];
                            break;
                        case 1:
                            temp[tempI][tempJ] += key[key.length - j - 1][i];
                            break;
                        case 2:
                            temp[tempI][tempJ] += key[key.length - i - 1][key.length - j - 1];
                            break;
                        case 3:
                            temp[tempI][tempJ] += key[j][key.length - i - 1];
                            break;
                    }
                }
            }

            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp.length; j++) {
                    if(temp[i][j] != 1) isOpenAble = false;
                }
            }
            if(isOpenAble) break;

            direction++;
        }
        return isOpenAble;
    }
}

