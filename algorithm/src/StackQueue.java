import java.util.*;

public class StackQueue {
    /**
     * 기능개발
     * https://programmers.co.kr/learn/courses/30/lessons/42586
     *
     * 며칠걸리는지 계산해서 비교하고 이전보다 작으면 count 세서 집어넣음
     * 길이 -1 이면 집어 넣고 끝
     * 큐에서 끄내와서 배열로 만들음
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
     *
     * 트럭 올리고 무게 계산해서 가능하면 올리고 아니면 시간 증가
     * 트럭 내려갈 시간이면 내려놓고 그다음 내려갈 시간 확인
     * 마지막 트럭이 되면 마지막 내리는 시간으로 리턴
     * @param bridge_length
     * @param bridge_weight
     * @param truck_weights
     * @return
     */
    public int solution(int bridge_length, int bridge_weight, int[] truck_weights) {

        int time = 0;
        int weight = 0;
        int i = 0;

        Queue tracksOnBridge = new LinkedList();
        Queue outTimes = new LinkedList();
        int outTime = 0;

        while (true) {

            time++;

            if (time == outTime) {
                weight -= (int) tracksOnBridge.poll();
                if (outTimes.size() > 0) outTime = (int) outTimes.poll();
                else outTime = 0;
            }

            int track_weight = truck_weights[i];
            if (bridge_weight >= weight + track_weight) {

                if (i == truck_weights.length - 1) {
                    time = time + bridge_length;
                    break;
                }

                tracksOnBridge.offer(track_weight);
                weight += track_weight;
                outTimes.offer(time + bridge_length);

                if (outTime == 0) outTime = (int) outTimes.poll();

                i++;
            }

        }

        return time;
    }
}
