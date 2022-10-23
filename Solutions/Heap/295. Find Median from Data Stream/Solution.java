class MedianFinder {
    PriorityQueue<Integer> maxQ;
    PriorityQueue<Integer> minQ;

    public MedianFinder() {
        maxQ = new PriorityQueue<Integer>((a,b)->b-a);
        minQ = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        int s1=maxQ.size();
        int s2 = minQ.size();
        if(s1==s2){
            if(minQ.isEmpty()){
                maxQ.add(num);
            }else{
                 if(num<=minQ.peek()){
                maxQ.add(num);
            }else{
                maxQ.add(minQ.poll());
                minQ.add(num);
            }
           
            }
        }else{
            if(num>=maxQ.peek()){
                minQ.add(num);
            }else{
                minQ.add(maxQ.poll());
                maxQ.add(num);
            }
        }
        
        
    }
    
    public double findMedian() {
        if(maxQ.size()==minQ.size()){
            return (maxQ.peek()+minQ.peek())/2.0;
        }else{
            return maxQ.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */