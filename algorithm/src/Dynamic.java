import java.util.Arrays;
import java.util.HashMap;

public class Dynamic {

    /**
     * 정수 삼각형
     * https://programmers.co.kr/learn/courses/30/lessons/43105
     */
    int[][] triangle;
    int[][] sumArr;

    public int solution(int[][] triangle) {
        this.triangle = triangle;
        this.sumArr = new int[triangle.length][triangle.length];
        return find( 0, 0);
    }

    private int find(int i, int j) {
        if (i < 0 || i >= triangle.length || j < 0 || j >= triangle[i].length) return 0;
        if(sumArr[i][j] > 0) {
            return sumArr[i][j];
        }
        return sumArr[i][j] = triangle[i][j] + Math.max(find(i + 1, j), find(i + 1, j + 1));
    }

//    private int find(int prv , int i , int j){
//        if(i < 0 || i >= triangle.length || j < 0 || j >= triangle[i].length) return prv;
//        System.out.println(" i > "  +  i + "   j > "  + j);
//        int sum = prv + triangle[i][j];
//        return Math.max(find(sum , i+1 , j) ,find(sum , i+1 , j+1 ));
//    }


}
