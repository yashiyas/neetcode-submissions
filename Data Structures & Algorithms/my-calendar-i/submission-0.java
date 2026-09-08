class MyCalendar {

    private BSTNode root;

    public MyCalendar() {
        this.root = null;
    }
    
    public boolean book(int startTime, int endTime) {
        if(root == null){
            root = new BSTNode(startTime, endTime);
            return true;
        }

        return doBook(startTime, endTime, root);
    }

    private boolean doBook(int start, int end, BSTNode node){
        if(start >= node.start && start < node.end){
            return false;
        }

        if(end <= node.start){
            if(node.left == null){
                node.left = new BSTNode(start,end);
                return true;
            }else{
                return doBook(start,end,node.left);
            }
        }
        if(start >= node.end){
            if(node.right == null){
                node.right = new BSTNode(start,end);
                return true;
            }else{
                return doBook(start,end,node.right);
            }
        }
        return false;
    }


    class BSTNode{
        private BSTNode left;
        private BSTNode right;
        private int start;
        private int end;

        BSTNode(int s, int e){
            this.start = s;
            this.end = e;
            this.left = null;
            this.right = null;
        }

    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */