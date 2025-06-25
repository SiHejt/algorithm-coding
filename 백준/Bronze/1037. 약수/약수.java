import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int divCount = sc.nextInt();
        int[] divArray = new int[divCount];

        for (int i = 0; i < divCount; i++) {
            divArray[i] = sc.nextInt();
        }

        Arrays.sort(divArray);

        int divMin = divArray[0];
        int divMax = divArray[divCount - 1];

        System.out.println(divMin * divMax);
    }
}