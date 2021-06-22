import java.util.*;

public class BinarySearch {

    /**
     * 가사 검색
     * https://programmers.co.kr/learn/courses/30/lessons/60060
     * 원본
     * 효율성 초과
     */
//    public int[] solution(String[] words, String[] queries) {
//        int[] answer = new int[queries.length];
//
//        for(int i = 0 ; i < queries.length; i++){
//            StringBuffer queryBuffer = new StringBuffer(queries[i]);
//            for(String word : words){
//                int p = 0;
//                StringBuffer wordBuffer = new StringBuffer(word);
//                if(wordBuffer.length() == queryBuffer.length()) {
//                    while (p < wordBuffer.length() && (wordBuffer.charAt(p) == queryBuffer.charAt(p) || queryBuffer.charAt(p) == '?')) p++;
//                }
//                answer[i] += p == wordBuffer.length()? 1 : 0;
//            }
//        }
//
//        return answer;
//    }

    public int[] solution(String[] words, String[] queries) {
        int qLen = queries.length;
        int[] answer = new int[qLen];

        HashMap<Integer , ArrayList<String>> map = new HashMap<>();
        HashMap<Integer , ArrayList<String>> reverseMap = new HashMap<>();

        for(int i = 0 ; i < words.length; i++){
            int key = words[i].length();
            if(map.get(key) == null && reverseMap.get(key) == null) {
                map.put(key , new ArrayList<>());
                reverseMap.put(key , new ArrayList<>());
            }
            map.get(key).add(words[i]);
            reverseMap.get(key).add(new StringBuffer(words[i]).reverse().toString());
        }

        for(ArrayList<String> list : map.values()){
            list.sort(String::compareTo);
        }

        for(ArrayList<String> list : reverseMap.values()){
            list.sort(String::compareTo);
        }

        for (int i = 0; i < qLen; i++) {

            String query = queries[i];
            boolean isReverse = query.startsWith("?");
            int key = query.length();

            if (map.get(key) == null || reverseMap.get(key) == null) {
                answer[i] = 0;
            } else {

                ArrayList<String> wordList;
                if (isReverse) {
                    query = new StringBuffer(query).reverse().toString();
                    wordList = reverseMap.get(key);
                } else {
                    wordList = map.get(key);
                }
                answer[i] = lowerBound(query.replace('?', Character.MAX_VALUE), wordList) - lowerBound(query.replace("?", ""), wordList);

            }
        }

        return answer;
    }

    /**
     * binarySearch
     * 해당 값의 위치 찾기
     * @return
     */
    private int binarySearch(String target , ArrayList<String> list){

        int min = 0;
        int max = list.size() - 1;
        int mid = 0;

        while (min <= max){
            mid = (min + max)/2;
            if(target.compareTo(list.get(mid)) < 0){
                min = mid + 1;
            }else if(target.compareTo(list.get(mid)) > 0){
                max = mid + 1;
            }else{
                // 해당하는 값의 위치를 찾기 때문에 동일한 값이 나오면 바로 빠져나온다.
                break;
            }
        }

        return mid;
    }

    /**
     * lowerBound
     * 크거나 같은 값들 중 가장 앞의 값
     * @return
     */
    private int lowerBound(String target , ArrayList<String> list){

        int min = 0;

        // target 이 모든 값보다 큰 경우를 대비하여 1 늘려서 계산한다.
        int max = list.size();
        int mid = 0;

        while (min < max){
            mid = (min + max)/2;
            // 같은 값인 경우에도 더 앞의 값을 찾는다.
            if(target.compareTo(list.get(mid)) <= 0){
                // mid 값이 가장 앞의 값일 수 있기 때문에 다시 계산할 떄 포함시킨다.
                max = mid;
            }else {
                min = mid + 1;
            }
        }

        // 결국 min 이 max 인 상황
        return min;

    }

    /**
     * upperBound
     * 초과된 값들 중 가장 앞의 값
     * @return
     */
    private int upperBound(String target , ArrayList<String> list){

        int min = 0;

        // target 이 모든 값보다 큰 경우를 대비하여 1 늘려서 계산한다.
        int max = list.size();
        int mid = 0;

        while (min < max){
            mid = (min + max)/2;
            // target 이상인 경우 min 값을 늘려준다.
            if(target.compareTo(list.get(mid)) >= 0){
                min = mid + 1;
            }else{
                // mid 값이 가장 앞의 값일 수 있기 때문에 다시 계산할 떄 포함시킨다.
                max = mid;
            }
        }

        // 결국 min 이 max 인 상황
        return min;
    }

}