class Solution {
    public int minNumberOperations(int[] target) {

        int n = target.length;

        SegmentTree sg = new SegmentTree(target);

        int[] res = sg.query(0, n - 1);

        int currMin = res[0];
        int partition = res[1];

        return currMin
                + solve(0, partition - 1, currMin, target, sg)
                + solve(partition + 1, n - 1, currMin, target, sg);
    }

    private int solve(int left, int right, int prev, int[] target, SegmentTree sg) {

        if (left < 0 || right >= target.length || left > right) {
            return 0;
        }

        int[] res = sg.query(left, right);

        if (res == null) {
            return 0;
        }

        int currMin = res[0];
        int partition = res[1];

        int incr = currMin - prev;

        return incr
                + solve(left, partition - 1, currMin, target, sg)
                + solve(partition + 1, right, currMin, target, sg);
    }


    public class SegmentTree {

        int minValue;
        int index;

        SegmentTree left;
        SegmentTree right;

        int l;
        int r;

        SegmentTree(int l, int r) {
            this.l = l;
            this.r = r;
        }

        SegmentTree(int l, int r, int val, int index) {
            this.l = l;
            this.r = r;
            this.minValue = val;
            this.index = index;
        }

        SegmentTree(int[] arr) {

            int n = arr.length;

            this.l = 0;
            this.r = n - 1;

            int mid = (l + r) / 2;

            this.left = build(0, mid, arr);
            this.right = build(mid + 1, r, arr);

            int rMin = this.right != null ? this.right.minValue : Integer.MAX_VALUE;
            int lMin = this.left != null? this.left.minValue : Integer.MAX_VALUE;

            if (rMin < lMin) {
                this.minValue = rMin;
                this.index = this.right.index;
            } else {
                this.minValue = lMin;
                this.index = this.left.index;
            }
        }

        public SegmentTree build(int l, int r, int[] arr) {

            if (l < 0 || r >= arr.length || l > r) {
                return null;
            }

            if (l == r) {
                return new SegmentTree(l, r, arr[l], l);
            }

            int mid = (l + r) / 2;

            SegmentTree sg = new SegmentTree(l, r);

            sg.left = sg.build(l, mid, arr);
            sg.right = sg.build(mid + 1, r, arr);

            int rMin = sg.right.minValue;
            int lMin = sg.left.minValue;

            if (rMin < lMin) {
                sg.minValue = rMin;
                sg.index = sg.right.index;
            } else {
                sg.minValue = lMin;
                sg.index = sg.left.index;
            }

            return sg;
        }

        public int[] query(int qleft, int qright) {

            int[] ans = new int[2];

            if (qleft > qright) {
                return null;
            }

            if (qleft == l && qright == r) {

                ans[0] = minValue;
                ans[1] = index;

                return ans;
            }

            int mid = (l + r) / 2;

            if (qright <= mid) {
                return left.query(qleft, qright);
            }

            if (qleft > mid) {
                return right.query(qleft, qright);
            }

            int[] ansLeft = null;
            int[] ansRight = null;

            if (left != null) {
                ansLeft = left.query(qleft, mid);
            }

            if (right != null) {
                ansRight = right.query(mid + 1, qright);
            }

            if (ansLeft == null) {
                return ansRight;
            }

            if (ansRight == null) {
                return ansLeft;
            }

            if (ansLeft[0] <= ansRight[0]) {
                return ansLeft;
            }

            return ansRight;
        }
    }
}