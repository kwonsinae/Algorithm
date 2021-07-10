import java.util.Scanner;

public class Floyd {

    /**
     * 플로이드
     * https://www.acmicpc.net/problem/11404
     * ???? 
     */
    public void solution() {

        // scan
        Scanner scanner = new Scanner(System.in);

        int INF = (int) 1e9;
        int cities = scanner.nextInt();
        int buses = scanner.nextInt();

        int[][] payArr = new int[cities][cities];

        for (
                int i = 0;
                i < payArr.length; i++) {
            for (int j = 0; j < payArr.length; j++) {
                if (i == j) payArr[i][j] = 0;
                else payArr[i][j] = INF;
            }
        }

        for (
                int i = 0;
                i < buses; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            int pay = scanner.nextInt();
            payArr[from][to] = Math.min(payArr[from][to], pay);
        }

        // Floyd
        for (
                int mid = 0;
                mid < cities; mid++) {
            for (int from = 0; from < cities; from++) {
                for (int to = 0; to < cities; to++) {
                    payArr[from][to] = Math.min(payArr[from][to], (payArr[from][mid] + payArr[mid][to]));
                }
            }
        }

        // result
        for (
                int i = 0;
                i < payArr.length; i++) {
            for (int j = 0; j < payArr.length; j++) {
                if (payArr[i][j] == INF) payArr[i][j] = 0;
                System.out.print(payArr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
