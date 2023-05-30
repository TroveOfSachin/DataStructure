package backbase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class BaseBall {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> s = new HashMap<>();


        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop(); // Remove the previous score
            } else if (op.equals("D")) {
                int prevScore = stack.peek();
                stack.push(prevScore * 2); // Double the previous score and add to the record
            } else if (op.equals("+")) {
                int prevScore1 = stack.pop();
                int prevScore2 = stack.peek();
                stack.push(prevScore1);
                stack.push(prevScore1 + prevScore2); // Add the sum of the previous two scores to the record
            } else {
                stack.push(Integer.parseInt(op)); // Add the integer score to the record
            }
        }

        int totalSum = 0;
        while (!stack.isEmpty()) {
            totalSum += stack.pop(); // Calculate the sum of all scores on the record
        }

        return totalSum;
    }
}