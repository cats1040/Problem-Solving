public class ValidParenthesis {
  /**
   * Given a string s containing just the characters '(', ')', '{', '}', '[' and
   * ']',
   * determine if the input string is valid.
   *
   * An input string is valid if:
   * 1. Open brackets must be closed by the same type of brackets.
   * 2. Open brackets must be closed in the correct order.
   * 3. Every close bracket has a corresponding open bracket of the same type.
   * 
   * @param s - Input string containing parentheses. 1 <= s.length <= 10^4
   * @returns boolean - True if the string is valid, false otherwise.
   */
  public boolean isValidRecursive(String s) {
    int ans = solve(0, s, s.length());
    return ans == s.length();
  }

  private int solve(int i, String s, int n) {
    if (i >= s.length()) {
      return i;
    }

    char ch = s.charAt(i);

    if (ch == '(' || ch == '[' || ch == '{') {
      int nxt = solve(i + 1, s, n);
      char closing = '\0';
      if (ch == '(') {
        closing = ')';
      } else if (ch == '[') {
        closing = ']';
      } else {
        closing = '}';
      }

      if (nxt == -1 || nxt == n || s.charAt(nxt) != closing)
        return -1;

      return solve(nxt + 1, s, n);
    }

    return i;
  }

  /**
   * Main method for testing the ValidParenthesis class.
   */
  public static void main(String[] args) {
    ValidParenthesis vp = new ValidParenthesis();
    String test1 = "()";
    String test2 = "()[]{}";
    String test3 = "(]";
    String test4 = "([)]";
    String test5 = "{[]}";

    assert vp.isValidRecursive(test1) == true : "Test case 1 failed";
    assert vp.isValidRecursive(test2) == true : "Test case 2 failed";
    assert vp.isValidRecursive(test3) == false : "Test case 3 failed";
    assert vp.isValidRecursive(test4) == false : "Test case 4 failed";
    assert vp.isValidRecursive(test5) == true : "Test case 5 failed";
  }
}