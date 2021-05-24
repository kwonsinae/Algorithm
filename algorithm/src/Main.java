public class Main {
    public static void main(String[] args) {
//	[[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
        Implementation implementation = new Implementation();
        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
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

        for (int r = 0; r < key.length; r++) {
            String s = "";
            for (int c = 0; c < key.length; c++) {
//                s += r + "" + c + " ";
                s += key[r][c] + " ";
            }
            System.out.println(s);
        }
        System.out.println("=====================");
        for (int r = 0; r < key.length; r++) {
            String s = "";
            for (int c = 0; c < key.length; c++) {
//                s += (key.length - c -1) + "" + r + " ";
                s += key[key.length - c -1][r] + " ";
            }
            System.out.println(s);
        }
        System.out.println("=====================");
        for (int r = 0; r < key.length; r++) {
            String s = "";
            for (int c = 0; c < key.length; c++) {
//                s += (key.length - r -1) + "" + (key.length - c -1) + " ";
                s += key[key.length - r - 1][key.length - c -1] + " ";
            }
            System.out.println(s);
        }
        System.out.println("=====================");
        for (int r = 0; r < key.length; r++) {
            String s = "";
            for (int c = 0; c < key.length; c++) {
//                s += c + "" + (key.length - r - 1) + " ";
                s += key[c][key.length - r - 1] + " ";
            }
            System.out.println(s);
        }
        System.out.println("=====================");
        Boolean result = implementation.solution(key , lock);



        System.out.println(result);
    }
}
