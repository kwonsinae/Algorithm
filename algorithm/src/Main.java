import java.util.*;

public class Main {

    /**
     * 최종순위
     * https://www.acmicpc.net/problem/3665
     */
    static ArrayList<int[]> result = new ArrayList<>();
    public static void main(String[] args) {

        // scan
        Scanner scanner = new Scanner(System.in);

        int testCount = scanner.nextInt();
        ArrayList<Test> tests = new ArrayList<>();

        for(int i = 0; i < testCount; i++){
            Test test = new Test();

            int teamCount = scanner.nextInt();
            result.add(new int[teamCount]);

            test.setTeamCount(teamCount);
            int[] lastResult = new int[teamCount];
            for(int j = 0; j < teamCount; j++){
                lastResult[j] = scanner.nextInt();
            }
            test.setLastResult(lastResult);

            int changedTeamCount = scanner.nextInt();
            test.setChangedTeamCount(changedTeamCount);
            int[][] changedTeams = new int[changedTeamCount][2];
            for(int j = 0; j < changedTeamCount; j++){
                changedTeams[j][0] = scanner.nextInt();
                changedTeams[j][1] = scanner.nextInt();
            }
            test.setChangedTeams(changedTeams);

            tests.add(test);
        }

        Queue<Integer> q = new LinkedList<>();


        System.out.println();

    }

    static class Test{

        int teamCount;
        int[] lastResult;
        int changedTeamCount;
        int[][] changedTeams;

        public int[] getLastResult() {
            return lastResult;
        }

        public int[][] getChangedTeams() {
            return changedTeams;
        }

        public int getTeamCount() {
            return teamCount;
        }

        public int getChangedTeamCount() {
            return changedTeamCount;
        }

        public void setTeamCount(int teamCount) {
            this.teamCount = teamCount;
        }

        public void setLastResult(int[] lastResult) {
            this.lastResult = lastResult;
        }

        public void setChangedTeams(int[][] changedTeams) {
            this.changedTeams = changedTeams;
        }

        public void setChangedTeamCount(int changedTeamCount) {
            this.changedTeamCount = changedTeamCount;
        }
    }
}
