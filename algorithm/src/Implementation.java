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
//    private int[][] key, lock;
//    private int width = 0;
//    private int height = 0;
//
//    public Boolean solution(int[][] key, int[][] lock) {
//
//        this.lock = lock;
//        this.key = key;
//
//        int[] minPoint = {lock.length ,lock.length};
//        int[] maxPoint = {0,0};
//
//        for (int i = 0; i < lock.length; i++ ) {
//            for (int j = 0; j < lock.length; j++ ) {
//                if(lock[i][j] == 0){
//                    minPoint[0] = Math.min(i , minPoint[0]);
//                    minPoint[1] = Math.min(j , minPoint[1]);
//                    maxPoint[0] = Math.max(i , maxPoint[0]);
//                    maxPoint[1] = Math.max(j , maxPoint[1]);
//                }
//            }
//        }
//
//        width = maxPoint[0] - minPoint[0] + 1;
//        height = maxPoint[1] - minPoint[1] + 1;
//        if(width < 0 && height < 0) return false;
//        if(width > key.length && height > key.length ) return false;
//
//        for (int i = minPoint[0]; i <= key.length - width; i++ ) {
//            for (int j = minPoint[1]; j <= key.length - height; j++ ) {
//                if (isSuit(i, j)) return true;
//            }
//        }
//
//        return false;
//    }
//
//    private Boolean isSuit(int startRow, int startCol){
//        Boolean check0 = true;
//        Boolean check90 = true;
//        Boolean check180 = true;
//        Boolean check270 = true;
//
//        for (int keyRow = 0; keyRow < width; keyRow++) {
//            for (int keyCol = 0; keyCol < height; keyCol++) {
//                if (lock[startRow + keyRow][startCol + keyCol] == 1) {
//                    if (key[keyRow][keyCol] == 1) check0 = false;
//                    if (key[height - 1 - keyCol][keyRow] == 1) check90 = false;
//                    if (key[width - 1 - keyRow][height - 1 - keyCol] == 1) check180 = false;
//                    if (key[keyCol][width - 1 - keyRow] == 1) check270 = false;
//                }
//                System.out.println(" keyRow " + keyRow + " keyCol " + keyCol + " is?? " +
//                        ((check0 || check90 || check180 || check270)? true : false));
//            }
//        }
//
//        if (check0 || check90 || check180 || check270) return true;
//        return false;
//    }

//    int size = key.length - 1;
//        for (int keyRow = 0; keyRow < width; keyRow++) {
//        for (int keyCol = 0; keyCol < height; keyCol++) {
//
//            if ((startRow + keyRow >= lock.length) || (startCol + keyCol >= lock.length)) break;
//
//            if (lock[startRow + keyRow][startCol + keyCol] == 1) {
//                if (key[keyRow][keyCol] == 1)               check0 = false;
//                if (key[size - keyCol][keyRow] == 1)        check90 = false;
//                if (key[size - keyRow][size - keyCol] == 1) check180 = false;
//                if (key[keyCol][size - keyRow] == 1)        check270 = false;
//            }
//        }
//    }
//
//        if (check0 || check90 || check180 || check270) return true;
//        return false;

//    private Boolean isSame(int i, int j , int length) {
//        Boolean check0 = true;
//        Boolean check90 = true;
//        Boolean check180 = true;
//        Boolean check270 = true;
//
//        for (int r = 0; r < length; r++) {
//            for (int c = 0; c < length; c++) {
//                int n = lock[i + c][j + r];
//
//                if (n == key[r][c]) check0 = false;
//                if (n == key[length - c][r]) check90 = false;
//                if (n == key[length - r][length - c]) check180 = false;
//                if (n == key[c][length - r]) check270 = false;
//
//                // 죄다 false 면 리턴
//                if (!check0 && !check90 && !check180 && !check270) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }

    //
//        for (int r = 0; r < maxX; r++) {
//        for (int c = 0; c < maxY; c++) {
//            int n = lock[i + c][j + r];
//
//            if (n == key[r][c]) check0 = false;
//            if (n == key[maxY - c][r]) check90 = false;
//            if (n == key[maxY - r][maxX - c]) check180 = false;
//            if (n == key[c][maxX - r]) check270 = false;
//
//            // 죄다 false 면 리턴
//            if (!check0 && !check90 && !check180 && !check270) {
//                return false;
//            }
//        }
//    }
//    private Boolean isSame(int i, int j) {
//        Boolean check0 = true;
//        Boolean check90 = true;
//        Boolean check180 = true;
//        Boolean check270 = true;
//
//        int width =  lock.length - i -1;
//        int height =   lock.length - j -1;
//
//        for(int r = 0; r <= width; r++){
//            for(int c = 0; c <= height; c++){
//
//                int n = key[r + i][c + j];
//
//                if (n == lock[r][c]) check0 = false;
//                if (n == lock[width-c][r]) check90 = false;
//                if (n == lock[width-r][width-c]) check180 = false;
//                if (n == lock[c][width-r]) check270 = false;
//
//                // 죄다 false 면 리턴
//                if (!check0 && !check90 && !check180 && !check270) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
}

