import java.util.*;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char x) {
        val = x;
    }
}

public class cd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            TreeNode root = buildTree(s);
            levelOrderTraversal(root);
            System.out.println();
        }
        sc.close();
    }

    public static TreeNode buildTree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            TreeNode node = new TreeNode(c);
            if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                stack.push(node);
            } else if (c == '(') {
                stack.push(node);
            } else if (c == ')') {
                while (stack.peek().val != '(') {
                    TreeNode right = stack.pop();
                    TreeNode operator = stack.pop();
                    TreeNode left = stack.pop();
                    operator.left = left;
                    operator.right = right;
                    stack.push(operator);
                }
                stack.pop();
                stack.push(node);
            } else {
                while (!stack.isEmpty() && stack.peek().val != '(' && getPrecedence(c) <= getPrecedence(stack.peek().val)) {
                    TreeNode right = stack.pop();
                    TreeNode operator = stack.pop();
                    TreeNode left = stack.pop();
                    operator.left = left;
                    operator.right = right;
                    stack.push(operator);
                }
                stack.push(node);
            }
        }
        while (stack.size() > 1) {
            TreeNode right = stack.pop();
            TreeNode operator = stack.pop();
            TreeNode left = stack.pop();
            operator.left = left;
            operator.right = right;
            stack.push(operator);
        }
        return stack.pop();
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                System.out.print(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.print("-");
        }
    }

    public static int getPrecedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        }
        return 0;
    }
}