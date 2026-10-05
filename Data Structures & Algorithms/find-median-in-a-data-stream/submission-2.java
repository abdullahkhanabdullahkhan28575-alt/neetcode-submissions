class MedianFinder {
    private ArrayList<Integer> data;


    public MedianFinder() {
        data=new ArrayList<>();

        
    }
    
    public void addNum(int num) {
        data.add(num);

        
    }
    
    public double findMedian() {
        Collections.sort(data);

        int n=data.size();
        if((n&1)==1){

        return data.get(n/2);
        
    }else{
        return (data.get(n/2)+data.get(n/2-1))/2.0;
        }
    }
}
