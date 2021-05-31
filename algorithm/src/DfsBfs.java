import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class DfsBfs {
    /**
     * 타겟넘버
     * https://programmers.co.kr/learn/courses/30/lessons/43165
     * @param numbers
     * @param target
     * @return
     */
//    private int count = 0;
//    private int target = 0;
//    private int len = 0;
//    private ArrayList<Node> nodeArr = new ArrayList<>();
//    public int solution(int[] numbers, int target) {
//        this.target = target;
//        this.len = (int)Math.pow(2, numbers.length + 1) - 1;
//
//        int inserted = 0;
//        int index = -1;
//        for (int i = 0; i < len ; i++) {
//            Node node;
//
//            if(index == -1)  node = new Node(0);
//            else             node = new Node(numbers[index] * (i%2 == 0 ? 1 : -1));
//
//            nodeArr.add(node);
//            node.setNeighbor(i);
//
//            inserted++;
//            if (inserted == Math.pow(2, index + 1)) {
//                index++;
//                inserted = 0;
//            }
//
//        }
//
//        return Dfs(0 , 0);
//    }
//
//    public int Dfs(int index , int sum){
//
//        nodeArr.get(index).setVisited(true);
//
//        for(int n :  nodeArr.get(index).getNeighbor()){
//            Node node = nodeArr.get(n);
//            if(!node.isVisited()){
//                node.setSum(sum + node.getNum());
//                Dfs(n , node.getSum());
//            }
//
//            if(node.isTarget()) this.count ++;
//        }
//        return count;
//    }
//
//    class Node{
//        private int sum = 0;
//        private int num = 0;
//        private boolean visited = false;
//        private ArrayList<Integer> neighbor = new ArrayList<>();
//
//        Node(int num){
//            this.num = num;
//        }
//
//        public void setNeighbor(int i) {
//            int n1 = (i*2) + 1;
//            int n2 = (i*2) + 2;
//
//            if(n1 >= len && n2  >= len) return;
//
//            ArrayList<Integer> neighbor = new ArrayList<>();
//            neighbor.add(n1);
//            neighbor.add(n2);
//            this.neighbor = neighbor;
//        }
//
//        public boolean isTarget() { return neighbor.size() == 0 && sum == target; }
//
//        public boolean isVisited() { return visited; }
//        public void setVisited(boolean visited) { this.visited = visited; }
//        public int getNum() { return num; }
//        public void setSum(int sum) { this.sum = sum; }
//        public int getSum() { return sum; }
//        public ArrayList<Integer> getNeighbor() { return neighbor; }
//
//    }

    /**
     * 타겟넘버
     * DFS 참고용
     * @param numbers
     * @param target
     * @return
     */
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    int dfs(int[] numbers, int n, int sum, int target) {
        if (n == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        // 여기서 한쪽은 + 한쪽은 - 로 양쪽으로 나감.........
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }

}
