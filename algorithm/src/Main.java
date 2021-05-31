public class Main {
    public static void main(String[] args) {

//        int[] pr = {95, 90, 99, 99, 80, 99};
//        int[] sp = {1, 1, 1, 1, 1, 1};
//
//        StackQueue stackQueue = new StackQueue();
//
////        System.out.println( stackQueue.solution(pr , sp));
//
////        2	10	[7,4,5,6]	8
////        100	100	[10]	101
////        100	100	[10,10,10,10,10,10,10,10,10,10]	110
//
//
//        int[] tr = {7,4,5,6};
//        System.out.println( stackQueue.solution(2, 10 ,tr));]
        DfsBfs dfsBfs = new DfsBfs();
        int[] numbers = {1, 1, 1, 1, 1};
        dfsBfs.solution(numbers , 3);
    }
}
