import java.util.*;

public class Sorting {
    /**
     * K번째 수
     * 잘라서 소팅하고 끄내고..
     * https://programmers.co.kr/learn/courses/30/lessons/42748
     */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0 ; i < commands.length; i ++){
            int[] tempArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tempArray);
            answer[i] = tempArray[commands[i][2] - 1];
        }

        return answer;
    }

    /**
     * 가장 큰수
     * https://programmers.co.kr/learn/courses/30/lessons/42746
     * 하나라도 0이거나 같은 수면 비교하고 리턴
     * => 첫 자리 확인하고 다르면 비교해서 리턴
     * ==> 자릿수 확인하고 같으면 비교해서 리턴
     * ===> 숫자끼리 붙이고 비교해서 리턴
     *
     * * * 마지막 작업 ===> 숫자끼리 붙이고 비교해서 리턴
     * * * 만 해도 가능한 것이었다.
     * * * 시간 차이도 별로 안남.
     */
//    public String solution(int[] numbers) {
//        String answer = "";
//
//        Integer[] numberIntegers = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
//        Comparator<Integer> comparator = (o1, o2) -> {
//
//            if(o1==0 || o2 == 0 || o1 == o2) return Integer.compare(o1, o2) * -1;
//
//            int d1 = (int) (Math.log10(o1));
//            int d2 = (int) (Math.log10(o2));
//
//            int n1 = o1 == 0 ? 1 : o1/(int)Math.pow(10 , d1);
//            int n2 = o2 == 0 ? 1 : o2/(int)Math.pow(10 , d2);
//
//            if(n1 == n2){
//                if (d1 != d2){
//
//                    int c1 = Integer.parseInt(o1.toString() + o2.toString());
//                    int c2 = Integer.parseInt(o2.toString() + o1.toString());
//
//                    return Integer.compare(c1, c2) * -1;
//                }
//                return Integer.compare(o1, o2) * -1;
//            }
//            return Integer.compare(n1, n2) * -1;
//        };
//
//        Collections.sort(Arrays.asList(numberIntegers) , comparator);
//        int zeroCheck = 0;
//        for(Integer i : numberIntegers){
//            answer += i;
//            zeroCheck += i;
//        }
//
//        return zeroCheck == 0 ? "0" : answer;
//    }

    /**
     * 가장 큰수 보완
     * ===> 숫자끼리 붙이고 비교해서 리턴
     */
//    public String solution(int[] numbers) {
//        String answer = "";
//
//        String[] strArr = new String[numbers.length];
//
//        for(int i = 0; i < numbers.length; i++){
//            strArr[i] = numbers[i] + "";
//        }
//
//        Comparator<String> comparator = (o1, o2) -> {
//            return (o2 + o1).compareTo(o1 + o2);
//        };
//
//        Collections.sort(Arrays.asList(strArr) , comparator);
//        for(String i : strArr){
//            answer += i;
//        }
//
//        return answer.charAt(0) == 0 ? "0" : answer;
//    }

    /**
     * H-Index
     * https://programmers.co.kr/learn/courses/30/lessons/42747
     * 정렬해서 제일 큰 수 에서 부터 --1 해서 같거나 큰 애들을 카운트한다.
     * @param citations
     * @return
     */
//    public int solution(int[] citations) {
//        int answer = 0;
//        Arrays.sort(citations);
//        int last = citations.length - 1;
//
//        for (int i = citations[last]; i >= 0; i--) {
//            int count = 0;
//
//            for (int j = last; j >= 0; j--) {
//                if(i <= citations[j]) count++;
//                else break;
//            }
//
//            if(count >= i) {
//                answer = i;
//                break;
//            }
//        }
//
//        return answer;
//    }

    /**
     * H-Index 참고용
     * 뭔소린지 모르겠따.
     * @param citations
     * @return
     */
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }

}
