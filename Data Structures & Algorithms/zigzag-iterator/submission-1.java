class ZigzagIterator {

    List<List<Integer>> lists;
    List<Integer> iterators;
    int curr;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {

        List<List<Integer>> currLists = new ArrayList();
        currLists.add(v1);
        currLists.add(v2);

        List<Integer> itrs = new ArrayList();
        for(int i=0; i<currLists.size(); i++){
            itrs.add(0);
        }

        this.lists = currLists;

        this.iterators = itrs;
        this.curr = 0;
    }

    public int next() {

        List<Integer> currList = lists.get(curr);
        int itr = iterators.get(curr);

       while(! (iterators.get(curr) < lists.get(curr).size())){
            curr = (curr+1)%lists.size();
       }

       int ans = lists.get(curr).get(iterators.get(curr));
       iterators.set(curr,iterators.get(curr)+1);

       curr = (curr+1)%lists.size();

       return ans;
        
    }

    public boolean hasNext() {

        for(int i=0; i<lists.size(); i++){
            if(iterators.get(i) < lists.get(i).size()){
                return true;
            }
        }

        return false;
        
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
