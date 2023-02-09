package examprep;

/**
 * Given two one-dimensional arrays LL and UR, fill in the program on the next page
 * to insert the elements of LL into the lower-left triangle of a square two-dimensional
 * array S and UR into the upper-right triangle of S, without modifying elements along
 * the main diagonal of S. You can assume LL and UR both contain at least enough
 * elements to fill their respective triangles. (Spring 2020 MT1)
 *
 * After calling fillGrid(LL, UR, S), S should contain
 * {
 * { 0, 11, 12, 13, 14 },
 * { 1, 0, 15, 16, 17 },
 * { 2, 3, 0, 18, 19 },
 * { 4, 5, 6, 0, 20 },
 * { 7, 8, 9, 10, 0 }
 * }
 * (The last two elements of LL are excess and therefore ignored.)
 */
public class FillGrid {
    static int[] LL = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0 };
    static int[] UR = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
    static int[][] S = {
            { 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0}
    };
    public static void fillGrid(int[] LL, int[] UR, int[][] S) {
        int N = S.length;
        int kL, kR;
        kL = kR = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i < j) {
                    S[i][j] = UR[kR];
                    kR++;
                } else if (i > j){
                    S[i][j] = LL[kL];
                    kL++;
                }
                System.out.print(S[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        fillGrid(LL, UR, S);
    }
}
