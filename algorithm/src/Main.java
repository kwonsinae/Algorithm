public class Main {
    public static void main(String[] args) {

        Implementation implementation = new Implementation();
        int[][] key = {
                {0, 0, 0},
                {0, 0, 0},
                {1, 0, 0}
        };
        int[][] lock = {
                {0, 0, 1},
                {0, 1, 0},
                {1, 0, 0}
        };

        for (int r = 0; r < lock.length; r++) {
            String s = "";
            for (int c = 0; c < lock.length; c++) {
//                s += r + "" + c + " ";
                s += lock[r][c] + " ";
            }
            System.out.println(s);
        }
        System.out.println("=====================");
        for (int r = 0; r < lock.length; r++) {
            String s = "";
            for (int c = 0; c < lock.length; c++) {
//                s += (key.length - c -1) + "" + r + " ";
                s += lock[key.length - c -1][r] + " ";
            }
            System.out.println(s);
        }
        System.out.println("=====================");
        for (int r = 0; r < lock.length; r++) {
            String s = "";
            for (int c = 0; c < lock.length; c++) {
//                s += (key.length - r -1) + "" + (key.length - c -1) + " ";
                s += lock[key.length - r - 1][key.length - c -1] + " ";
            }
            System.out.println(s);
        }
        System.out.println("=====================");
        for (int r = 0; r < lock.length; r++) {
            String s = "";
            for (int c = 0; c < lock.length; c++) {
//                s += c + "" + (key.length - r - 1) + " ";
                s += lock[c][key.length - r - 1] + " ";
            }
            System.out.println(s);
        }
        System.out.println("=====================");
        Boolean result = implementation.solution(key , lock);



        System.out.println(result);
    }
}
