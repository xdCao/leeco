package bytedance.codetop;

import java.util.Stack;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/28 13:55
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        validateStackSequences(new int[]{1, 0, 2}, new int[]{2, 1, 0});
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();
        for (int i = popped.length - 1; i >= 0; i--) {
            popStack.push(popped[i]);
        }
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && !popStack.isEmpty() && stack.peek().equals(popStack.peek())) {
                stack.pop();
                popStack.pop();
            }
        }
        return stack.isEmpty();
    }

}
