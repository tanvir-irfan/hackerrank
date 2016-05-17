import java.util.Scanner;

public class NotInPair {

    static int MAX_VAL = 101;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] array = new int[MAX_VAL];

        for(int i = 0; i< N; i++) {
            array[sc.nextInt()]++;
        }

        for(int i = 0; i<= MAX_VAL; i++) {
            if(array[i] % 2 == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}
