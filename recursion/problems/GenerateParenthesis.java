import java.util.*;

public class GenerateParenthesis {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * 
     * Constraints:
     * 1. 1 <= n <= 8
     * 2. The solution set must not contain duplicate combinations.
     * 
     * Example:
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * 
     * @param n - Number of pairs of parentheses.
     * @returns List<String> - A list of all combinations of well-formed parentheses.
     */
    public List<String> generateParenthesis(int n) {
        StringBuilder temp = new StringBuilder("");
        HashSet<String> ans = new HashSet<>();

        solve(n, temp, 0, ans);

        return new ArrayList<>(ans);
    }

    private void solve(int n, StringBuilder temp, int open, HashSet<String> ans) {
        if (n <= 0) {
            // System.out.println(temp);
            ans.add(temp.toString());
            return;
        }

        if (open < n) {
            // can (
            temp.append('(');
            solve(n, temp, open + 1, ans);

            // don't
            if (open > 0) {
                temp.deleteCharAt(temp.length() - 1);
                temp.append(')');
                solve(n - 1, temp, open - 1, ans);
            }     
        }
        else if (open >= 0) {
            temp.append(')');
            solve(n - 1, temp, open - 1, ans);
        }

        temp.deleteCharAt(temp.length() - 1);

        return;
    }

    /**
     * Main method for testing the GenerateParenthesis class.
     */
    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        int n = 3;
        List<String> result = gp.generateParenthesis(n);
        List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        
        assert result.size() == expected.size() && result.containsAll(expected) : "Test case failed";
    }
}