class SnapshotArray {
private final Map<Integer,TreeMap<Integer,Integer>> indexToSnapIdToValue;
int curSnapId=0;    

    public SnapshotArray(int length) {
        indexToSnapIdToValue = new HashMap<>();
    }
    
    public void set(int index, int val) {
       if(!indexToSnapIdToValue.containsKey(index))
       {
           indexToSnapIdToValue.put(index, new TreeMap<>());
       }
       indexToSnapIdToValue.get(index).put(curSnapId,val); 
    }
    
    public int snap() {
      curSnapId++;
      return curSnapId -1;  
    }
    
    public int get(int index, int snap_id) {
        return java.util.Optional.ofNullable(indexToSnapIdToValue.get(index))
        .map(treeMap->treeMap.floorEntry(snap_id))
        .map(Map.Entry::getValue)
        .orElse(0);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */