class Solution {
    public int coinChange(int[] coins, int amount) {
      if(amount==0) 
      return 0;
      Queue<Integer>q=new LinkedList<>();
      q.add(0);
      boolean[]seen=new boolean[amount+1];
      seen[0]=true;
      int res=0;
      while(!q.isEmpty()){
        res++;
        int size=q.size();
        for(int i=0; i<size; i++){
            int cur=q.poll();
            {
                for(int coin:coins){
                    int nxt=cur+coin;
                    if(nxt==amount) return res;
                    if(nxt>amount|| seen[nxt])continue;
                    seen[nxt]=true;
                    q.add(nxt);
                    
                }
            }
        }
      }
      return -1;

        
    }
}
