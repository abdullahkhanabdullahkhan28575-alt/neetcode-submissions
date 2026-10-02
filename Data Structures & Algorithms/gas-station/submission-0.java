
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        if(Arrays.stream(gas).sum() <
         Arrays.stream(cost).sum()){
            return -1;
        }
        int total=0; 
        int res=0;
        for(int i=0; i<gas.length; i++){
            total+=gas[i]-cost[i];
          if ( total<0){
            total=0;
            res=i+1;
          }
        }
        return res;
        
    }
}
