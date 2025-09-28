public class ValidParenthesis {
  /**
   * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
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
    boolean ans = solve(0, s, 0, 0, 0, -1);
    return ans;
  }

  private boolean solve(int i, String s, int o1, int o2, int o3, int lastOpen) {
    if (i >= s.length()) {
        if (o1 > 0 || o2 > 0 || o3 > 0) return false;
        return true;
    }

    char ch = s.charAt(i);
    int l = -1;

    if (ch == '(') {
        l = 1;
        o1++;
    }
    else if (ch == '[') {
        l = 2;
        o2++;
    }
    else if (ch == '{') {
        l = 3;
        o3++;
    }
    else if (ch == ')') {
        if (o1 <= 0 || (lastOpen != 1 && lastOpen != -1)) return false;
        o1--;
    }
    else if (ch == ']') {
        if (o2 <= 0 || (lastOpen != 2 && lastOpen != -1)) return false;
        o2--;
    }
    else if (ch == '}') {
        if (o3 <= 0 || (lastOpen != 3 && lastOpen != -1)) return false;
        o3--;
    }

    boolean ans = solve(i + 1, s, o1, o2, o3, l);

    return ans;
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