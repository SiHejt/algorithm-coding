import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		Stack<Character> s = new Stack<>();
		boolean tag = false;
		for(char ch : line.toCharArray()) {
			if(ch == '<') {
				while(!s.isEmpty()) {
					bw.write(s.pop());
				}
				bw.write(ch);
				tag = true;
			}
			else if(ch=='>') {
				bw.write(ch);
				tag = false;
			}
			else if(tag == true) {
				bw.write(ch);
			} else {
				if(ch == ' ') {
					while(!s.isEmpty()) {
						bw.write(s.pop());
					}
					bw.write(ch);
				} else {
					s.push(ch);
				}
			}
		}
		while(!s.isEmpty()) {
			bw.write(s.pop());
		}
		bw.flush();
	}
}