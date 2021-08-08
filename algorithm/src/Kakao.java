import com.sun.source.doctree.SerialTree;

import java.util.*;

public class Kakao {

    /**
     * 신규 아이디 추천
     * https://programmers.co.kr/learn/courses/30/lessons/72410
     * 정규식으로..그냥..
     *
     * @param new_id
     * @return
     */
//    public String solution(String new_id) {
//        String answer = new_id.toLowerCase().replaceAll("[^0-9A-Za-z-_.]", "").replaceAll("[.]{2,}", ".");
//
//        if (answer.length() > 0 && answer.charAt(0) == '.')                     answer = answer.substring(1);
//        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.')   answer = answer.substring(0, answer.length() - 1);
//        if (answer.length() == 0)                                               answer = "a";
//        if (answer.length() > 15)                                               answer = answer.substring(0, 15);
//        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.')   answer = answer.substring(0, answer.length() - 1);
//
//        while (answer.length() < 3) {
//            answer += answer.charAt(answer.length() - 1);
//        }
//
//        return answer;
//    }
    public String solution(String new_id) {
        String answer = new_id
                .toLowerCase()
                .replaceAll("[^0-9A-Za-z-_.]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]|[.]$", "");

        if (answer.length() == 0) answer = "a";
        if (answer.length() >= 16) answer = answer.substring(0, 15);

        answer = answer.replaceAll("[.]$", "");

        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }

    /**
     * 메뉴 리뉴얼
     * https://programmers.co.kr/learn/courses/30/lessons/72411
     *
     * @param orders 고객들의 주문 배열
     * @param course 원하는 코스 배열
     * @return
     */
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();

        // 코스 메뉴의 수 , 맥스 카운트
        HashMap<Integer, Integer> courseMap = new HashMap<>();
        for (int i = 0; i < course.length; i++) {
            courseMap.put(course[i], 0);
        }

        // 코스 조합 , 해당 코스가 나온 카운트
        HashMap<String, Integer> orderedMap = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            String order = orders[i];

            // 오더 스트링이 정렬이 안된경우가 있다.
            char[] StringToChar = order.toCharArray();
            Arrays.sort(StringToChar);
            String SortedString = new String(StringToChar);

            for (int j = 0; j < order.length(); j++) {
                // 조합을 돌린다.
                combination(SortedString, "", j, orderedMap, courseMap);
            }
        }

        // 조합을 기준으로 정렬한다.
        Object[] keyList = orderedMap.keySet().toArray();
        Arrays.sort(keyList);

        for (int i = 0; i < keyList.length; i++) {
            String key = keyList[i].toString();
            int count = orderedMap.get(key);

            // 카운트가 1보다 크고 맥스 카운트와 같은것만 결과 값으로 저장
            if (courseMap.get(key.length()) == count && count > 1) {
                result.add(keyList[i].toString());
            }
        }

        return result.toArray(new String[result.size()]);
    }

    private void combination(String order, String key, int i, HashMap<String, Integer> orderedMap, HashMap<Integer, Integer> courseMap) {
        key += order.charAt(i);
        if (courseMap.get(key.length()) != null) {
            int count = 1;

            if (orderedMap.get(key) != null) {
                count += orderedMap.get(key);
            }

            orderedMap.put(key, count);
            // 카운트가 큰걸로 저장한다.
            courseMap.put(key.length(), Math.max(courseMap.get(key.length()), count));
        }
        for (int j = i + 1; j < order.length(); j++) {
            combination(order, key, j, orderedMap, courseMap);
        }
    }

    /**
     * 순위 검색
     * <p>
     * 시간초과..
     * https://programmers.co.kr/learn/courses/30/lessons/72412
     * <p>
     * 언어는 cpp, java, python, – 중 하나입니다.
     * 직군은 backend, frontend, – 중 하나입니다.
     * 경력은 junior, senior, – 중 하나입니다.
     * 소울푸드는 chicken, pizza, – 중 하나입니다.
     *
     * @param info
     * @param queries
     * @return
     */
    public int[] solution(String[] info, String[] queries) {
        int[] result = new int[queries.length];

        int[] score = new int[info.length];
        HashMap<String, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < info.length; i++) {
            String[] infoArr = info[i].split(" ");

            for (int j = 0; j < infoArr.length; j++) {
                String key = infoArr[j];

                if (j == infoArr.length - 1) {
                    score[i] = Integer.parseInt(infoArr[j]);
                } else {
                    Set<Integer> set;
                    if (map.get(key) == null) {
                        set = new HashSet<>();
                    } else {
                        set = map.get(key);
                    }
                    set.add(i);
                    map.put(key, set);
                }
            }

        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = countMatch(map, score, queries[i]);
        }

        return result;
    }

    private int countMatch(HashMap<String, Set<Integer>> map, int[] score, String query) {
        String[] queryArr = query.replace("and ", "").split(" ");
        int countValid = 0;
        int[] checkCount = new int[score.length];
        int minRoutScore = 0;
        for (int i = 0; i < queryArr.length; i++) {
            if (i == queryArr.length - 1) {
                minRoutScore = Integer.parseInt(queryArr[i]);
            } else {
                String key = queryArr[i];
                if (!key.equals("-")) {
                    if (map.get(key) != null) {
                        Set<Integer> set = map.get(key);
                        for (Integer s : set) {
                            checkCount[s] += 1;
                        }
                    }
                    countValid++;
                }
            }
        }

        int countMatch = 0;
        for (int i = 0; i < checkCount.length; i++) {
            if (checkCount[i] == countValid && score[i] >= minRoutScore) {
                countMatch++;
            }
        }

        return countMatch;
    }


//    public int[] solution(String[] info, String[] query) {
//        int[] result = new int[query.length];
//        int[] score = new int[info.length];
//
//        for(int i = 0 ; i < info.length; i++){
//            String[] infoArr = info[i].split(" ");
//            score[i] = Integer.parseInt(infoArr[infoArr.length-1]);
//        }
//
//        ArrayList<String[]> queryArr = new ArrayList<>();
//        for(int i = 0 ; i < query.length; i++){
//            queryArr.add(query[i].replace("and " , "").split(" "));
//        }
//
//        for(int i = 0; i < query.length; i++){
//            for(int j = 0; j < info.length; j++) {
//                if (checkMatch(info[j] , queryArr.get(i) , score[j])) {
//                    result[i] += 1;
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private boolean checkMatch(String info , String[] query, int score){
//        for(int i = 0 ; i < query.length; i ++){
//
//            if(query[i].equals("-")) continue;
//            if(i == query.length - 1) {
//                if(score<Integer.parseInt(query[i])) return false;
//            }else {
//                if (!info.contains(query[i])) return false;
//            }
//        }
//        return true;
//    }

    /**
     * 합승택시 요금
     * https://programmers.co.kr/learn/courses/30/lessons/72413
     *
     * @param n     지점의 개수
     * @param s     출발지점
     * @param a     a 의 도착지점
     * @param b     b 의 도착지점
     * @param fares 지점 사이의 예상 택시요금
     * @return //        7	3	4	1	[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]	14
     */
    public int solution(int n, int s, int a, int b, int[][] fares) {

        int[][] f = new int[n + 1][n + 1];

        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], (int) 1e6);
            f[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            f[from][to] = cost;
            f[to][from] = cost;
        }

        for (int mid = 1; mid < n + 1; mid++) {
            for (int from = 1; from < n + 1; from++) {
                for (int to = 1; to < n + 1; to++) {
                    f[from][to] = Math.min(f[from][to], (f[from][mid] + f[mid][to]));
                }
            }
        }

        int result = f[s][a] + f[s][b];
        for (int mid = 1; mid < n + 1; mid++) {
            result = Math.min(result, (f[s][mid] + f[mid][a] + f[mid][b]));
        }

        return result;
    }

    //    public int solution(int n, int s, int a, int b, int[][] fares) {
//        ArrayList<HashMap<Integer , Integer>> f = new ArrayList<>();
//        for(int i = 0 ; i < n + 1; i ++){
//            f.add(new HashMap<>());
//        }
//
//        for (int i = 0 ; i < fares.length; i++){
//            int from = fares[i][0];
//            int to = fares[i][1];
//            int distance = fares[i][2];
//            f.get(from).put(to,distance);
//            f.get(to).put(from,distance);
//        }
//
//        Route[] startRoute = getRoute(n, s, f);
//        int min = (int)Math.min(1e9, getMinCost(a ,b, startRoute));
//
//        for(int i = 1 ; i < n + 1; i++){
//            if(i != s && i != a && i != b) {
//                Route[] route = getRoute(n, i, f);
//                min =(int)Math.min(min, (long)startRoute[i].getCost() + getMinCost(a ,b, route));
//            }
//        }
//
//        return min;
//    }
//
//    public Route[] getRoute(int n , int s , ArrayList<HashMap<Integer , Integer>> f){
//        Route[] minRoute = new Route[n + 1];
//
//        for(int i = 0; i < minRoute.length; i ++){
//            minRoute[i] = new Route();
//        }
//        minRoute[s].setCost(0);
//
//        PriorityQueue<Node> queue = new PriorityQueue<>();
//        queue.offer(new Node(s , 0));
//
//        while (!queue.isEmpty()){
//            Node node = queue.poll();
//            int cost = node.getDistance();
//            int index = node.getIndex();
//            if(minRoute[index].getCost() < cost) continue;
//
//            for(Map.Entry<Integer, Integer> entry : f.get(index).entrySet()){
//                int k = entry.getKey();
//                int v = entry.getValue();
//                int newCost = minRoute[index].getCost() + v;
//                if(newCost < minRoute[k].getCost()){
//                    minRoute[k].changeRoute(minRoute[index].getOverlay() , index , newCost);
//                    queue.offer(new Node(k , newCost));
//                }
//            }
//        }
//
//        return minRoute;
//    }
//
//    public int getMinCost(int a, int b , Route[] route) {
//        Route A = route[a];
//        Route B = route[b];
//
//        if (!A.isOverlay(b) && !B.isOverlay(a)) {
//            return A.getCost() + B.getCost();
//        }else if(A.isOverlay(b)){
//            return A.getCost();
//        }else if(B.isOverlay(a)){
//            return B.getCost();
//        }
//        return Math.min(A.getCost() , B.getCost());
//    }
//}
//
//class Route {
//
//    private ArrayList<Integer> overlay = new ArrayList<>();
//    private int cost = (int)1e9;
//
//    public void changeRoute(ArrayList<Integer> overlay, int index , int cost){
//        this.overlay.clear();
//        this.overlay = overlay;
//        this.overlay.add(index);
//        this.cost = cost;
//    }
//
//    public int getCost() {
//        return cost;
//    }
//
//    public void setCost(int cost) {
//        this.cost = cost;
//    }
//
//    public ArrayList<Integer> getOverlay() {
//        return overlay;
//    }
//
//    public boolean isOverlay(int index){
//        for(int i = 0 ; i < overlay.size(); i ++){
//            if(overlay.get(i) == index) return true;
//        }
//        return false;
//    }
//}
//
//
//class Node implements Comparable<Node> {
//
//    private int index;
//    private int distance;
//
//    Node(int index , int distance){
//        this.distance = distance;
//        this.index = index;
//    }
//
//    @Override
//    public int compareTo(Node n) {
//        return this.distance > n.getDistance() ? 1 : -1;
//    }
//
//    public int getDistance() {
//        return distance;
//    }
//
//    public int getIndex() {
//        return index;
//    }


    /**
     *2+
     * 광고 삽입
     * https://programmers.co.kr/learn/courses/30/lessons/72414
     *
     * @param play_time
     * @param adv_time
     * @param logs
     * @return
     */
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        long[] startLog = new long[logs.length];
        long[] endLog = new long[logs.length];

        for (int i = 0; i < logs.length; i++) {
            String[] log = logs[i].split("-");
            startLog[i] = getTime(log[0]);
            endLog[i] = getTime(log[1]);
        }

        long advLong = getTime(adv_time);
        long playLong = getTime(play_time);

        // ..?
        for(long i = 0; i < playLong; i++){

        }

        return answer;
    }

    public long getTime(String log){
        String[] logArr = log.split(":");
        String h = logArr[0];
        String m = logArr[1];
        String s = logArr[2];
       return (Integer.parseInt(h) * 60 * 60) + (Integer.parseInt(m) * 60) + Integer.parseInt(s);
    }

}
