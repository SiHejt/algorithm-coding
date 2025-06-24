import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static int tetronomino(int N, int M, int[][] array){
        int sum = 0;
        for (int i = 0; i < N - 3; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = array[i][j] + array[i + 1][j] + array[i + 2][j] + array[i + 3][j];
                if(tmp > sum) sum = tmp;
            }
        } // ㅡ
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 3; j++) {
                int tmp = array[i][j] + array[i][j + 1] + array[i][j + 2] + array[i][j + 3];
                if(tmp > sum) sum = tmp;
            }
        } // ㅣ
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < M - 1; j++) {
                int tmp = array[i][j] + array[i][j + 1] + array[i+ 1][j] + array[i + 1][j + 1];
                if(tmp > sum) sum = tmp;
            }
        } // ㅁ
        for (int i = 0; i < N - 2; i++) { //ㄱ
            for (int j = 0; j < M - 1; j++) {
                int tmp = array[i][j] + array[i + 1][j] + array[i + 2][j] + array[i + 2][j + 1];
                if(tmp > sum) sum = tmp; //ㄱ
                tmp = array[i][j] + array[i][j + 1] + array[i+ 1][j + 1] + array[i + 2][j + 1];
                if(tmp > sum) sum = tmp; // ㄴ
                tmp = array[i][j + 1] + array[i + 1][j + 1] + array[i + 2][j + 1] + array[i + 2][j];
                if(tmp > sum) sum = tmp;
                tmp = array[i][j] + array[i][j + 1] + array[i + 1][j] + array[i + 2][j];
                if(tmp > sum) sum = tmp;
                tmp = array[i][j] + array[i + 1][j] + array[i + 1][j + 1] + array[i + 2][j + 1];
                if(tmp > sum) sum = tmp;
                tmp = array[i][j + 1] + array[i + 1][j + 1] + array[i + 1][j] + array[i + 2][j];
                if(tmp > sum) sum = tmp;

                tmp = array[i][j] + array[i + 1][j] + array[i + 2][j] + array[i + 1][j + 1];
                if(tmp > sum) sum = tmp;
                tmp = array[i + 1][j] + array[i][j + 1] + array[i + 1][j + 1] + array[i + 2][j + 1];
                if(tmp > sum) sum = tmp;
            }
        } //3x2

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                int tmp = array[i][j] + array[i + 1][j] + array[i + 1][j + 1] + array[i + 1][j + 2];
                if(tmp > sum) sum = tmp; //ㄱ
                tmp = array[i][j] + array[i][j + 1] + array[i][j + 2] + array[i + 1][j];
                if(tmp > sum) sum = tmp;
                tmp = array[i][j] + array[i][j + 1] + array[i][j + 2] + array[i + 1][j + 2];
                if(tmp > sum) sum = tmp; //ㄴ
                tmp = array[i][j + 2] + array[i + 1][j + 2] + array[i + 1][j + 1] + array[i + 1][j];
                if(tmp > sum) sum = tmp;

                tmp = array[i][j] + array[i][j + 1] + array[i + 1][j + 1] + array[i + 1][j + 2];
                if(tmp > sum) sum = tmp;
                tmp = array[i + 1][j] + array[i + 1][j + 1] + array[i][j + 1] + array[i][j + 2];
                if(tmp > sum) sum = tmp;

                tmp = array[i][j] + array[i][j + 1] + array[i][j + 2] + array[i + 1][j + 1];
                if(tmp > sum) sum = tmp;
                tmp = array[i][j + 1] + array[i + 1][j] + array[i + 1][j + 1] + array[i + 1][j + 2];
                if(tmp > sum) sum = tmp;
            }
        } //2x3
        return sum;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int sum = tetronomino(N, M, array);

        System.out.println(sum);

    }

}