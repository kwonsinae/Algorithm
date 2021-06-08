import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Sorting sorting = new Sorting();
//        [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] numbers = {21, 212};

//        [12, 121]	"12121"
//                [21, 212]	"21221"

//        [3, 0, 6, 1, 5]	3
//        int[] citations = {22, 42};

//        N	stages	result
//        5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
//        4	[4,4,4,4,4]	[4,1,2,3]

        int n = 3;
        int[] stages = {2, 1, 3};
        sorting.solution(n , stages);
    }
//    public static boolean[] visited = new boolean[9];
//    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
//
//    // DFS 함수 정의
//    public static void dfs(int x) {
//        // 현재 노드를 방문 처리
//        visited[x] = true;
//        System.out.print(x + " ");
//        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
//        for (int i = 0; i < graph.get(x).size(); i++) {
//            int y = graph.get(x).get(i);
//            if (!visited[y]) dfs(y);
//        }
//    }
//
//    public static void main(String[] args) {
//        // 그래프 초기화
//        for (int i = 0; i < 9; i++) {
//            graph.add(new ArrayList<Integer>());
//        }
//
//        // 노드 1에 연결된 노드 정보 저장
//        graph.get(1).add(2);
//        graph.get(1).add(3);
//        graph.get(1).add(8);
//
//        // 노드 2에 연결된 노드 정보 저장
//        graph.get(2).add(1);
//        graph.get(2).add(7);
//
//        // 노드 3에 연결된 노드 정보 저장
//        graph.get(3).add(1);
//        graph.get(3).add(4);
//        graph.get(3).add(5);
//
//        // 노드 4에 연결된 노드 정보 저장
//        graph.get(4).add(3);
//        graph.get(4).add(5);
//
//        // 노드 5에 연결된 노드 정보 저장
//        graph.get(5).add(3);
//        graph.get(5).add(4);
//
//        // 노드 6에 연결된 노드 정보 저장
//        graph.get(6).add(7);
//
//        // 노드 7에 연결된 노드 정보 저장
//        graph.get(7).add(2);
//        graph.get(7).add(6);
//        graph.get(7).add(8);
//
//        // 노드 8에 연결된 노드 정보 저장
//        graph.get(8).add(1);
//        graph.get(8).add(7);
//
//        dfs(1);
//    }

//    public static void main(String[] args) {
//
//        int[] pr = {95, 90, 99, 99, 80, 99};
//        int[] sp = {1, 1, 1, 1, 1, 1};
//
////        StackQueue stackQueue = new StackQueue();
//
////        System.out.println( stackQueue.solution(pr , sp));
//
////        2	10	[7,4,5,6]	8
////        100	100	[10]	101
////        100	100	[10,10,10,10,10,10,10,10,10,10]	110
//
//
////        int[] tr = {7,4,5,6};
////        System.out.println( stackQueue.solution(2, 10 ,tr));
//
//
//        DfsBfs dfsBfs = new DfsBfs();
//        int[] numbers = {1,2,3};
//        System.out.println( dfsBfs.solution(numbers, 10));
//    }
}
