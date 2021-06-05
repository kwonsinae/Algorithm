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

    /**
     * 실패율
     * 계산해서 넣고 벨류값으로 쏘팅 하고 키값으로 배열에 넣어준다.
     * @return
     */
//    public int[] solution(int n, int[] stages) {
//        int[] answer = new int[n];
//
//        List<Map.Entry<Integer, Double>> stageList = new LinkedList<>();
//        for(int i = 1 ; i < n+1; i++){
//            Double onCount = 0.0;
//            Double passCount = 0.0;
//            for(int s : stages){
//                if(s == i) onCount ++;
//                if(s > i) passCount ++;
//            }
//
//            Double rate = 0.0;
//            if(passCount == 0 && onCount != 0) rate = 100.0;
//            else if(passCount != 0 && onCount != 0) rate = onCount / passCount;
//
//            stageList.add(new AbstractMap.SimpleEntry<>(i, rate));
//        }
//
//        Collections.sort(stageList, (o1, o2) -> {
//            if(o1.getValue() == o2.getValue()) return Integer.compare(o1.getKey() , o2.getKey());
//            return Double.compare(o1.getValue() , o2.getValue()) * -1;
//        });
//
//        for(int i = 0 ; i < n; i++){
//            answer[i] = stageList.get(i).getKey();
//        }
//
//        return answer;
//    }

    /**
     * 실패율 참고용
     * 디버깅했는데 이상함
     *
     * int n = 3;
     * int[] stages = {2, 1, 3};
     *
     * [Infinity, 1.0, 0.3333333333333333]
     *  ==> 이렇게 나오는데
     *
     * [1.0 , 0 , 0.5] 가 나와야할 것 같은데..
     */
//    public int[] solution(int N, int[] stages) {
//        int[] answer = new int[N];
//        double[] tempArr = new double[N];
//
//        int arrLength = stages.length;
//        int idx = arrLength;
//        double tempD = 0;
//        int tempI = 0;
//
//        // answer에 현재 on인 사용자수 삽입
//        for (int i = 0; i < arrLength; i++) {
//            int stage = stages[i];
//            if (stage != N + 1)
//                answer[stage - 1] += 1;
//        }
//
//        //
//        for (int i = 0; i < N; i++) {
//            int personNum = answer[i];
//            tempArr[i] = (double) personNum / idx;
//            idx -= personNum;
//            answer[i] = i + 1;
//        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 1; j < N - i; j++) {
//                if (tempArr[j - 1] < tempArr[j]) {
//                    tempD = tempArr[j - 1];
//                    tempArr[j - 1] = tempArr[j];
//                    tempArr[j] = tempD;
//
//                    tempI = answer[j - 1];
//                    answer[j - 1] = answer[j];
//                    answer[j] = tempI;
//                }
//            }
//        }
//        return answer;
//    }
}
