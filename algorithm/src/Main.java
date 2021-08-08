public class Main {

    public static void main(String[] args) {
        Kakao kakao = new Kakao();

        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
//        orders	course	result
//                ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
//["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
//["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]
//        test.solution(orders , course);
//
//        예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
//        예2	"z-+.^."	"z--"
//        예3	"=.="	"aaa"
//        예4	"123_.def"	"123_.def"
//        예5	"abcdefghijklmn.p"	"abcdefghijklmn"
//        test.solution("abcdefghijklmn.p");

//        String[] info = {"java backend junior pizza 150"};
//        String[] query = {"java and backend and junior and pizza 100"};

//        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
//        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};


//        6	4	6	2	{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}	82
//        7	3	4	1	{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}	14
//        6	4	5	6	{{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}}	18
        int n = 6;
        int s = 4;
        int a = 5;
        int b = 6;
        int[][] fares = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};

        kakao.solution(n, s, a, b, fares);
    }

//    /**
//     * 최종순위
//     * https://www.acmicpc.net/problem/3665
//     */
//    static ArrayList<int[]> result = new ArrayList<>();
//    public static void main(String[] args) {
//
//        // scan
//        Scanner scanner = new Scanner(System.in);
//
//        int testCount = scanner.nextInt();
//        ArrayList<Test> tests = new ArrayList<>();
//
//        for(int i = 0; i < testCount; i++){
//            Test test = new Test();
//
//            int teamCount = scanner.nextInt();
//            result.add(new int[teamCount]);
//
//            test.setTeamCount(teamCount);
//            int[] lastResult = new int[teamCount];
//            for(int j = 0; j < teamCount; j++){
//                lastResult[j] = scanner.nextInt();
//            }
//            test.setLastResult(lastResult);
//
//            int changedTeamCount = scanner.nextInt();
//            test.setChangedTeamCount(changedTeamCount);
//            int[][] changedTeams = new int[changedTeamCount][2];
//            for(int j = 0; j < changedTeamCount; j++){
//                changedTeams[j][0] = scanner.nextInt();
//                changedTeams[j][1] = scanner.nextInt();
//            }
//            test.setChangedTeams(changedTeams);
//
//            tests.add(test);
//        }
//
//        Queue<Integer> q = new LinkedList<>();
//
//
//        System.out.println();
//
//    }
//
//    static class Test{
//
//        int teamCount;
//        int[] lastResult;
//        int changedTeamCount;
//        int[][] changedTeams;
//
//        public int[] getLastResult() {
//            return lastResult;
//        }
//
//        public int[][] getChangedTeams() {
//            return changedTeams;
//        }
//
//        public int getTeamCount() {
//            return teamCount;
//        }
//
//        public int getChangedTeamCount() {
//            return changedTeamCount;
//        }
//
//        public void setTeamCount(int teamCount) {
//            this.teamCount = teamCount;
//        }
//
//        public void setLastResult(int[] lastResult) {
//            this.lastResult = lastResult;
//        }
//
//        public void setChangedTeams(int[][] changedTeams) {
//            this.changedTeams = changedTeams;
//        }
//
//        public void setChangedTeamCount(int changedTeamCount) {
//            this.changedTeamCount = changedTeamCount;
//        }
//    }
}
