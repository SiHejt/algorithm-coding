import java.util.*;
public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] a = new char[26];
		int max = -1;
		char ch = '?';
		for (int i=0; i<s.length(); i++) {
			if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
				a[s.charAt(i) - 'A']++;;
			} else {
				a[s.charAt(i) - 'a']++;
			}
		}
		for (int i=0; i<26; i++) {
			if (a[i] > max) {
				max = a[i];
				ch = (char)(i + 65);
			} else if (a[i] == max) {
				ch = '?';
			}
		}
		System.out.print(ch);
	}
}