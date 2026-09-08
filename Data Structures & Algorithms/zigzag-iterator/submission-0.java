class ZigzagIterator {

    List<Integer> list1;
    List<Integer> list2;
    int it1;
    int it2;
    int prev;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {

        this.list1 = v1;
        this.list2 = v2;
        this.it1 = 0;
        this.it2 = 0;
        this.prev = 2;
        
    }

    public int next() {

        if(prev == 2){
            if(it1 < list1.size()){
                it1++;
                prev = 1;
                return list1.get(it1-1);
            }else if(it2 < list2.size()){
                it2++;
                prev = 2;
                return list2.get(it2-1);
            }
        }
        if(prev == 1){
            if(it2 < list2.size()){
                it2++;
                prev = 2;
                return list2.get(it2-1);
            }else if(it1 < list1.size()){
                it1++;
                prev = 1;
                return list1.get(it1-1);
            }
        }

        return -1;
        
    }

    public boolean hasNext() {

        return it1 < list1.size() || it2 < list2.size();
        
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
