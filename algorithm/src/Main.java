import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //    [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        Dynamic dynamic = new Dynamic();
        System.out.println(dynamic.solution(triangle));

    }
}