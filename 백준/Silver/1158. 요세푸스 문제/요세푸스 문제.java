import java.util.*;
class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<K-1; j++) {
				q.add(q.remove());
			}
			sb.append(q.remove() + ", ");
		}
		sb.append(q.remove() + ">");
		System.out.println(sb);
	}
}