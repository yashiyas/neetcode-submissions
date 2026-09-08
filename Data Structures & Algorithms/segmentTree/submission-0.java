class SegmentTree {

    int l;
    int r;
    SegmentTree left;
    SegmentTree right;
    int sum;

    public SegmentTree(int l, int r){
        this.l = l;
        this.r = r;
    }

    public SegmentTree(int l, int r, int sum){
        this.l = l;
        this.r = r;
        this.sum = sum;
    }

    public SegmentTree(int[] nums) {

        int n = nums.length;
        this.l = 0;
        this.r = n-1;
        int mid = (n-1)/2;

        this.left = build(0,mid,nums);
        this.right = build(mid+1,r,nums);
        int lsum = this.left != null ? this.left.sum : 0;
        int rsum = this.right != null ? this.right.sum : 0;
        this.sum = lsum + rsum;

    }

    private SegmentTree build(int l, int r, int[] nums){
        if(l < 0 || r >= nums.length || l>r){
            return null;
        }
        if(r == l){
            return new SegmentTree(r,l,nums[r]);
        }
        SegmentTree node = new SegmentTree(r,l);
        int mid = (r+l)/2;
        node.left = this.build(l,mid,nums);
        node.right = this.build(mid+1,r,nums);
        int lsum = node.left != null ? node.left.sum : 0;
        int rsum = node.right != null ? node.right.sum : 0;
        node.sum = lsum + rsum;
        return node;
    }

    public void update(int index, int val) {

        if(index == l && index == r){
            sum = val;
            return;
        }

        int mid = (l + r)/2;

        if(index <= mid){
            left.update(index,val);
        }else{
            right.update(index,val);
        }
        sum = left.sum+right.sum;

    }

    public int query(int L, int R) {

        if(l == L && r == R){
            return sum;
        }

        int mid = (l+r)/2;

        if(R <= mid){
            return left.query(L,R);
        }
        if(L > mid){
            return right.query(L,R);
        }

        int lsum = 0;
        if(left != null){
            lsum = left.query(L,mid);
        }

        int rsum = 0;

        if(right != null){
            rsum = right.query(mid+1,R);
        }

        return lsum + rsum;

    }
}
