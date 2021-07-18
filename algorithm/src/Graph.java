import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Graph {

    /**
     * 행성 터널
     * https://www.acmicpc.net/problem/2887
     */
    static int[] parents;
    public static void main(String[] args) {

        // scan
        Scanner scanner = new Scanner(System.in);

        int planetCount = scanner.nextInt();
        parents = new int[planetCount];

        ArrayList<Planet> planets = new ArrayList<>();

        for (int i = 0; i < planetCount; i++){
            planets.add(new Planet(
                    i,
                    scanner.nextInt(),
                    scanner.nextInt(),
                    scanner.nextInt()
            ));
            parents[i] = i;
        }

        // set arr
        ArrayList<Tunnel> tunnels = new ArrayList<>();

        // 이부분이 좀 중요하지않았나..? 인접한 곳 끼리만 계산한다.
        planets.sort(Comparator.comparingInt(o -> o.getX()));
        for(int i = 0; i < planetCount-1; i++) {
            int cost = Math.abs(planets.get(i).getX() - planets.get(i + 1).getX());
            tunnels.add(new Tunnel(planets.get(i).getId(), planets.get(i + 1).getId(), cost));
        }

        planets.sort(Comparator.comparingInt(o -> o.getY()));
        for(int i = 0; i < planetCount-1; i++) {
            int cost = Math.abs(planets.get(i).getY() - planets.get(i + 1).getY());
            tunnels.add(new Tunnel(planets.get(i).getId(), planets.get(i + 1).getId(), cost));
        }

        planets.sort(Comparator.comparingInt(o -> o.getZ()));
        for(int i = 0; i < planetCount-1; i++) {
            int cost = Math.abs(planets.get(i).getZ() - planets.get(i + 1).getZ());
            tunnels.add(new Tunnel(planets.get(i).getId(), planets.get(i + 1).getId(), cost));
        }

        // sort
        tunnels.sort(Comparator.comparingInt(o -> o.getCost()));

        int cost = 0;

        // cost
        for(int i = 0; i < tunnels.size(); i++){
            Tunnel tunnel = tunnels.get(i);
            if(findParent(tunnel.getFrom()) != findParent(tunnel.getTo())){
                unionParent(tunnel.getFrom() , tunnel.getTo());
                cost += tunnel.getCost();
            }
        }

        System.out.println(cost);

    }

    static private void unionParent(int idA , int idB){
        idA = findParent(idA);
        idB = findParent(idB);
        if(idA < idB) parents[idB] = idA;
        else parents[idA] = idB;
    }

    static private int findParent(int id){
        if(id == parents[id]) return id;
        return parents[id] = findParent(parents[id]);
    }

    static class Planet{
        private int id;
        private int x;
        private int y;
        private int z;

        Planet(int id, int x , int y, int z){
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getId() {
            return id;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }

    static class Tunnel{
        private int from;
        private int to;
        private int cost;

        Tunnel(int from , int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getCost() {
            return cost;
        }
    }


}
