import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "(";

        System.out.println(isValidParentheses4(s1));
        System.out.println(isValidParentheses4(s2));
        System.out.println(isValidParentheses4(s3));
        System.out.println(isValidParentheses4(s4));
    }


    static public boolean isValidParentheses1(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == '(' && s.charAt(right) == ')' ||
                    s.charAt(left) == '[' && s.charAt(right) == ']' ||
                    s.charAt(left) == '{' && s.charAt(right) == '}') {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }


    static boolean isValidParentheses2(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (stack.empty()) {
                    return false;
                }
                char c = stack.pop();

                if (c == '(' && s.charAt(i) != ')') {
                    return false;
                } else if (c == '{' && s.charAt(i) != '}') {
                    return false;
                } else if (c == '[' && s.charAt(i) != ']') {
                    return false;
                }
            }

        }
        return stack.empty();
    }


    static boolean isValidParentheses3(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }


    static boolean isValidParentheses4(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[head++] = ')';
            } else if (c == '[') {
                stack[head++] = ']';
            } else if (c == '{') {
                stack[head++] = '}';
            } else if (head == 0 || stack[--head] != c) {
                return false;
            }
        }
        return head == 0;
    }
}
