class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=getMaxPile(piles);
        int result = right;

        while(left<=right){
            int mid=(left+right)/2;

            if(canFinish(piles,mid,h)){
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
        private int getMaxPile(int []piles){
            int maxPile=0;
            for(int pile:piles){
                maxPile = Math.max(maxPile,pile);
            }
            return maxPile;
        }

        //helper to check if koko can finish with speed k in h hours
        private boolean canFinish(int[] piles, int k, int h){
            int total=0;
            for(int pile:piles){
                total+= (pile+k-1)/k;
                if(total>h){
                    return false;
                }
            }
            return true;
        }
    }
