
class InsertionSort extends Sorter {

    void sort() {
        for (int i = 1; i < n; i++) {
                int j = i;
                //bruker metoder arvet fra Sorter
                while (j > 0 && lt(A[j], A[j - 1])) {
                    swap(j, j - 1);
                    j--;
                }
            }
    }

    String algorithmName() {
        return "insertion";
    }
}
