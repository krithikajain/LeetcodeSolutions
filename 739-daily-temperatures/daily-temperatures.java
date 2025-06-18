class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
//questions: are there negative temperatures?

        //things to keep in mind:
        //if there are no warmer day ahead res[idx]=0
        // track the preivous day temp using a stack
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); //stores the value as [temp,idx]
    
        for(int i=0; i<temperatures.length; i++){
            int t=temperatures[i];
            while(!stack.isEmpty() && t>stack.peek()[0]){
                int[] pair = stack.pop();
                res[pair[1]]=i-pair[1];
        }
        stack.push(new int[]{t,i});
        }
        return res;
    }
}
    //stack [{73,0}]