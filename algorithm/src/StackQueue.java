import java.util.*;

public class StackQueue {
    /**
     * 기능개발
     * https://programmers.co.kr/learn/courses/30/lessons/42586
     *
     * 며칠걸리는지 계산해서 비교하고 이전보다 작으면 count 세서 집어넣음
     * 길이 -1 이면 집어 넣고 끝
     * 큐에서 끄내와서 배열로 만들음
     * 큐를 쓴 의미를 모르겠음
     * @param progresses
     * @param speeds
     * @return
     */
//    public int[] solution(int[] progresses, int[] speeds) {
//
//        Queue queue = new LinkedList();
//
//        int prvDays = (int)Math.ceil((100.00 - progresses[0]) / speeds[0]);
//        int count = 1;
//
//        for(int i = 1 ; i < progresses.length; i++) {
//            int days = (int) Math.ceil((100.00 - progresses[i]) / speeds[i]);
//            if (prvDays >= days) {
//                count++;
//            } else {
//                prvDays = days;
//                queue.offer(count);
//                count = 1;
//            }
//            if (i == progresses.length - 1) {
//                queue.offer(count);
//            }
//        }
//
//        int size = queue.size();
//        int[] answer = new int[size];
//        for(int i = 0 ; i < size; i++) {
//            answer[i] = (int)queue.poll();
//        }
//
//        return answer;
//    }

    /**
     * 다리를 지나는 트럭
     * https://programmers.co.kr/learn/courses/30/lessons/42583
     * bridge_length는 1 이상 10,000 이하입니다.
     * weight는 1 이상 10,000 이하입니다.
     * truck_weights의 길이는 1 이상 10,000 이하입니다.
     * 모든 트럭의 무게는 1 이상 weight 이하입니다.
     *
     * @param bridge_length
     * @param bridge_weight
     * @param truck_weights
     * @return
     */
    public int solution(int bridge_length, int bridge_weight, int[] truck_weights) {

        Arrays.sort(truck_weights);
        int time = 0;
        int weight = 0;
        int i = 0;

        Queue bridge = new LinkedList();
        Queue outTime = new LinkedList();
        int out = 0;
        while (true){

            if(i < truck_weights.length && bridge_weight > weight + truck_weights[i]) {
                bridge.offer(truck_weights[i]);
                weight += truck_weights[i];

                outTime.offer(time + bridge_length);
                if(i == 0) out = (int)outTime.poll();

                i++;
            }

            if(bridge.size() == 0){
                time = out;
                break;
            }

            if(time == out) {
                weight -= (int)bridge.poll();
                if(outTime.size() > 0) out = (int)outTime.poll();
            }

            time ++;

        }
        return time;
    }
}
