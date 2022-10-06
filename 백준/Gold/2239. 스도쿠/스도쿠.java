import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] map = new int[9][9];
    static boolean[][] rowcheck = new boolean[9][9];
    static int[] nums = new int[9];
    static boolean flag = false;
    static List<Pos> zeros = new ArrayList<>();
    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j) - '0';
                if (map[i][j] == 0) zeros.add(new Pos(i, j));
                else rowcheck[i][map[i][j] - 1] = true;
            }
        }
        sudoku(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }

    private static void sudoku(int cnt) {
        if (cnt == zeros.size())
            return;
        Pos p=zeros.get(cnt);
        for (int i = 0; i < 9; i++) {
            if (!rowcheck[p.r][i]) {
                if (vertical(p.c, i + 1) && matrix(p.r, p.c, i + 1)) {
                    map[p.r][p.c] = i + 1;
                    rowcheck[p.r][i] = true;
                    sudoku(cnt + 1);
                    if (flag) {
                        map[p.r][p.c] = 0;
                        rowcheck[p.r][i] = false;
                        flag = false;
                    }
                }
            }
        }
        if (map[p.r][p.c] == 0) {
            flag = true;
            return;
        }
    }

    private static boolean matrix(int r, int c, int n) {
        int sr = 0, sc = 0;
        if (r < 3) sr = 0;
        else if (r >= 3 && r < 6) sr = 3;
        else sr = 6;

        if (c < 3) sc = 0;
        else if (c >= 3 && c < 6) sc = 3;
        else sc = 6;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (map[i][j] == n) {
                    return false;
                }
            }

        }
        return true;
    }

    private static boolean vertical(int c, int n) {
        for (int i = 0; i < 9; i++) {
            if (map[i][c] == n) return false;  
        }
        return true;
    }
}
