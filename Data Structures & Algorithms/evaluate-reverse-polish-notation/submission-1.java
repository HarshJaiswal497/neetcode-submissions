class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")
                || tokens[i].equals("/")) {
                int op2 = s.pop();
                int op1 = s.pop();
                int res = 0;
                String fun = new String(tokens[i]);
                if (fun.equals("+")) {
                    res = op1 + op2;
                } else if (fun.equals("-")) {
                    res = op1 - op2;
                } else if (fun.equals("*")) {
                    res = op1 * op2;
                } else {
                    res = op1 / op2;
                }
                s.push(res);
            } else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();
    }
}
