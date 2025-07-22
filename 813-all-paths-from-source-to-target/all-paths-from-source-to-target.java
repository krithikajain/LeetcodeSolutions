class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0); //always starts from 0
        dfs(graph, 0, graph.length-1, result, path);
        return result;
    }

    private void dfs(int[][] graph, int node, int target, List<List<Integer>> result, List<Integer> path){
        //base case:
        if(node == target){
            result.add(new ArrayList<>(path));
            return;
        }
        //run a loop to find all the neighbors of the current node
        for(int neighbor : graph[node]){
            path.add(neighbor); //add the neighbor
            dfs(graph, neighbor, target, result, path);//call to find the next neighbor
            path.remove(path.size()-1);
        }
    }
}

//clarification
//DAG - directed acyclic graphs - no cycles
//dfs - explore the path of all the neighbors
//cannot be empty; n==1 then [[0]]
//from 0->n-1