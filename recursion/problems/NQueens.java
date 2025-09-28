import java.util.*;

public class NQueens {
    /**
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
     * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
     * 
     * Example: 
     * Input n = 4
     * Output: 2
     * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
     *
     * [
     *   [".Q..",  // Solution 1
     *    "...Q",
     *    "Q...",
     *    "..Q."],
     *   ["..Q.",  // Solution 2
     *    "Q...",
     *    "...Q",
     *    ".Q.."
     *    ]
     * ]
     * 
     * Constraints:
     * 1. 1 <= n <= 9
     * 2. You may assume that n is a positive integer.
     *
     * @param n - The size of the chessboard and the number of queens to place.
     * @returns int - The number of distinct solutions to the n-queens puzzle.
     **/
    public int totalNQueens(int n) {
        int ans = 0;

        HashMap<Integer, Integer> col = new HashMap<>();
        HashMap<Integer, Integer> d1 = new HashMap<>();
        HashMap<Integer, Integer> d2 = new HashMap<>();

        ans = solve(0, n, ans, col, d1, d2);

        return ans;
    }

    private boolean isSafe(int r, int c, HashMap<Integer, Integer> col, HashMap<Integer, Integer> d1, HashMap<Integer, Integer> d2) {
        if ((col.containsKey(c) && col.get(c) == 1) || (d1.containsKey(r + c) && d1.get(r + c) == 1) || (d2.containsKey(r - c) && d2.get(r - c) == 1)) return false;
        return true;
    }

    public int solve(int r, int n, int ans, HashMap<Integer, Integer> col, HashMap<Integer, Integer> d1, HashMap<Integer, Integer> d2) {
        if (r >= n) {
            ans++;
            return ans;
        } 

        for (int c = 0; c < n; c++) {
            if (isSafe(r, c, col, d1, d2) == true) {
                // modify
                col.put(c, 1);
                d1.put(r + c, 1);
                d2.put(r - c, 1);

                ans = solve(r + 1, n, ans, col, d1, d2);
                
                col.put(c, 0);
                d1.put(r + c, 0);
                d2.put(r - c, 0);
            }
        }

        // no position safe
        return ans;
    }

    /**
     * Main method for testing the NQueens class.
     */
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        // System.out.println(nQueens.totalNQueens(4));
        // System.out.println(nQueens.totalNQueens(1));
        // System.out.println(nQueens.totalNQueens(5));
        assert nQueens.totalNQueens(4) == 2 : "Test case 1 failed";
        assert nQueens.totalNQueens(1) == 1 : "Test case 2 failed";
        assert nQueens.totalNQueens(5) == 10 : "Test case 3 failed";
    }
}