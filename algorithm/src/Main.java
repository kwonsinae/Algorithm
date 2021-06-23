import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();

//        int n = 6;
//        int[] times = {7,10};
//
//        System.out.println(binarySearch.solutions(n , times));

//        ["frodo", "front", "frost", "frozen", "frame", "kakao"]	["fro??", "????o", "fr???", "fro???", "pro?"]
//        [3, 2, 4, 1, 0]

        // ["frame", "frodo", "front", "frost", "frozen", "kakao"]

//        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
//        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
//        System.out.println(binarySearch.solution(words , queries));

//        6	[7, 10]	28
        int n = 6;
        int[] times = {7, 10};
        System.out.println(binarySearch.solution(n , times));

    }
}