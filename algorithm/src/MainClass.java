public class MainClass {
    public static void main(String[] args) {
        int[] lost = {2, 4};
        int[] reserve = {3};
        int n = 5;

        int[] people = {20 ,30 ,100, 80, 50 , 90};

        //BBBAAB
        Greedy greedy = new Greedy();
        int result = greedy.solution7(people, 120);

        System.out.println(result);


    }

}
