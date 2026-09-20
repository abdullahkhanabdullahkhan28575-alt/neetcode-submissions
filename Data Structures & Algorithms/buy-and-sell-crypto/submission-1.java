class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        for(int i=0; i<prices.length;i++){
            int by=prices[i];
            for(int j=i+1; j<prices.length; j++){
                int sel=prices[j];
                res=Math.max(res,sel-by);
            }
        }
        return res;
        
    }
}
