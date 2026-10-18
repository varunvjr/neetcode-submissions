

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for (String token : tokens) {
            if (isNumber(token)) {
                st.push(Integer.parseInt(token));
            } else {
                int b = st.pop();
                int a = st.pop();
                int ans = 0;
                
                // Apply the operator
                switch (token) {
                    case "+":
                        ans = a + b;
                        break;
                    case "-":
                        ans = a - b;
                        break;
                    case "*":
                        ans = a * b;
                        break;
                    case "/":
                        ans = a / b;
                        break;
                }
                st.push(ans);
            }
        }
        
        return st.peek();
    }

    // Helper method to check if a token is a number
    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
