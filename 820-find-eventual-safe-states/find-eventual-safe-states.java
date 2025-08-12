class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        //dfs + visited + safe(to keep track of safe nodes)
        boolean[] visited = new boolean[n];
        boolean[] stack = new boolean[n];
        boolean[] safe = new boolean[n];

        for(int i=0; i<n; i++){
            dfs(i, graph, visited, stack, safe);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++)
            if(safe[i]) 
            res.add(i);
        return res;
        
    }

    private boolean dfs(int i, int[][] graph, boolean[] visited, boolean[] stack, boolean[] safe){
        if(stack[i]) return false; //cycle 
         if(visited[i]) return safe[i]; //just ignore/pass

        
        visited[i] = true;
        stack[i] = true;

        //explores the neighbours
        for(int v: graph[i]){
            if(!dfs(v, graph, visited, stack, safe)){
                stack[i] = false; //remove from the current path
                safe[i] = false; //mark it as unsafe
                return false;
            }

        }

        //reach a point where the node is terminal/safe
        stack[i] = false; //backtrack
        safe[i] = true; 
        return true;
    }
}

//clarifications
//directed graph with i=vertices and graph[i]=neighbours
//terminal nodes = no outgoing edges
//safe nodes = every path from that node will eventually reach to a terminal node
//unsafe nodes = is where the cycle exists
//return safe -> ascending order

//pattern DAG -> detect cycle -> maintain order => topological sorting

//edge cases: self loops, disconnected nodes 