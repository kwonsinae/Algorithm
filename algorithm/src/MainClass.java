public class MainClass {
    public static void main(String[] args) {
        int[] lost = {2,4};
        int[] reserve = {3};
        int n = 5;

        //BBBAAB
        Greedy greedy = new Greedy();
        String result = greedy.solution6("4177252841" , 4);

        System.out.println(result);


    }

}
