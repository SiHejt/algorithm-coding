import java.util.*;
public class Main {
	public static int solve(int n) {
		boolean[] check = new boolean[1001];
		for (int i=1; i<100; i++) {
			check[i] = true;
		}
		for (int i=100; i<1000; i++) {
			int a = i/100;
			int b = (i/10) % 10;
			int c = i % 10;
			if ((a-b) == (b-c)) {
				check[i] = true;
			}
		}
		int cnt = 0;
		for (int i =0; i<=n; i++) {
			if (check[i] == true) {
				cnt++;
			}
		}
		return cnt;
	}
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(solve(n));
	}
}