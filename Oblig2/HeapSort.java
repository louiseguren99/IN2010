class HeapSort extends Sorter {

    void sort() {
        buildMaxHeap();
        for (int i = n-1; i >= 0; i--){
            swap(0, i);
            bubbleDown(0, i); 
        }  
    }

    private void buildMaxHeap(){
        for (int i = n/2; i >= 0; i--){
            bubbleDown(i, n);
        }
    }

    private void bubbleDown(int i, int n){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (lt(left, n) && lt(A[largest], A[left])){
            largest = left;
        }
        if (lt(right, n) && lt(A[largest], A[right])){
            largest = right;
        }
        if (!eq(i, largest)){
            swap(i, largest);
            bubbleDown(largest, n);
        }

    }

    String algorithmName() {
        return "heap";
    }
}