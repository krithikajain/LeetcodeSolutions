class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int x,y;
        for(String c :tokens){
            if(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/")){
                y=stack.pop();
                x=stack.pop();
                if(c.equals("+")){
                    stack.push(x+y);
                }
                else if(c.equals("-")){
                    stack.push(x-y);
                }
                else if(c.equals("*")){
                    stack.push(x*y);
                }
                else if(c.equals("/")){
                    stack.push(x/y);
                }
            }
                else{
                    stack.push(Integer.parseInt(c));
                }
            }
        return stack.pop();
    }
}