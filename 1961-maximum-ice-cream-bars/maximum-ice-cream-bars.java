class Solution {
    public int maxIceCream(int[] costs, int coins) {
        //         0 1 2 3 4
        //costs = [1,3,2,4,1]
        //coins=7
        //max bars with the coins -> more bars less cost

        Arrays.sort(costs); 
        //costs = [1,1,2,3,4]
        int bar_count=0; //track ice creams bought
        int spend=0; //track coins spent so far
        for(int cost:costs){
            if(spend+cost<=coins){
            spend += cost;
            bar_count++;
            }
        }
        return bar_count;
    }
}

//clarifications
//cost=0 or bars=0? no
//costs=[2] coins=1 => return 0
//costs=[2] coins=4 => return 1