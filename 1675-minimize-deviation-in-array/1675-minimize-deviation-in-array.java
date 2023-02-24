class Solution {
    public int minimumDeviation(int[] nums) {
        // change to treeset as treeset is a order set
        TreeSet<Integer> ts=new TreeSet<>();
        
        for(int i:nums){
            if(i%2==1) i*=2;
            ts.add(i); // just add the value in the treeset
        }
        
        int diff=Integer.MAX_VALUE;
        
        while(true){
            int max=ts.last(); // as it is a sorted set, max value will be at the end of the set
            int min=ts.first(); // and min value at the front
            
            diff=Math.min(diff,max-min);
            if(max%2==0){ // if it's a even value
                ts.remove(max); // first remove the value
                ts.add(max/2); // add the value called max/2 into the treeset
            }
            else{ // if it's odd just break it
                break;
            }
        }
        
        return diff;
    }
}