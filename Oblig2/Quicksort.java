class Quicksort extends Sorter {

    void sort() {
        quicksort(0, n - 1);
    }

    private void quicksort(int lo, int hi) {
        if (geq(lo, hi)) {
            return;
        }
        int p = partition(lo, hi);
        quicksort(lo, p - 1);
        quicksort(p + 1, hi);
        
    }

    private int partition(int lo, int hi) {
        int p = choosePivot();
        swap(p, hi);

        int pivot = A[hi];
        int left = lo;
        int right = hi - 1;  

        while (leq(left, right)){
            while (leq(left, right) && leq(left, pivot)){
                left = left + 1;
            }
            while (geq(right, left) && geq(right, pivot)){
                right = right - 1;
            }
            if (lt(left, right)){
                swap(left, right);
            }
        }
        swap(left, hi);
        return left;
    }

    private int choosePivot(){
        int a = A[0];
        int b = A[n/2];
        int c = A[n-1];

        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return 0;
        } else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return n/2;
        } else {
            return n-1;
        }
    }

    String algorithmName() {
        return "quick";
    }
}