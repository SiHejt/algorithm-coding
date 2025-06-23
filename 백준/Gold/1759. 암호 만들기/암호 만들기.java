import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int c = sc.nextInt();

        String[] alphabet = new String[c];
        for (int i = 0; i < c; i++) {
            alphabet[i] = sc.next();
        }

        Arrays.sort(alphabet);

        go(l, alphabet, "", 0);
    }

    static void go(int l, String[] alphabet, String pw, int i) {
        if (pw.length() == l) {
            if (check((pw))) {
                System.out.println(pw);
            }
            return;
        }
        if (i >= alphabet.length) return;
        go(l, alphabet, pw + alphabet[i], i + 1);
        go(l, alphabet, pw, i + 1);
    }

    static boolean check(String pw) {
        int aeiou = 0;
        int other = 0;

        for (char x : pw.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                aeiou += 1;
            }
            else {
                other += 1;
            }
        }

        return aeiou >= 1 && other >=2;
    }
}