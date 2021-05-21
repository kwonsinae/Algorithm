public class Implementation {

    /**
     * 문자열 압축
     * https://programmers.co.kr/learn/courses/30/lessons/60057
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
}
