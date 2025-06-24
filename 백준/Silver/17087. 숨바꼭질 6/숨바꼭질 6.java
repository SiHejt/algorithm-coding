import java.util.*;
public class Main {
    public static int gcd(int a, int b) {
    	while (b != 0) {
    		int r = a % b;
    		a = b;
    		b = r;
    	}
    	return a;
    }
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] distance = new int[n];
        for (int i=0; i<n; i++) {
        	distance[i] = Math.abs(sc.nextInt() - s);
        }
        for (int i=1; i<n; i++) {
        	distance[0] = gcd(distance[0], distance[i]);
        }
        System.out.print(distance[0]);
    }
}