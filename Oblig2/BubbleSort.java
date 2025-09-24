class BubbleSort extends Sorter {

    void sort() {
        if (n < 2) return;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                // bruker sammenligningsmetode fra Sorter
                if (gt(A[j], A[j + 1])) {
                    swap(j, j + 1);   // teller bytter
                    swapped = true;
                }
            }
            // optimaliserer algoritmen ved å sjekke om det swappes, og hvis ikke brytes ut av denne plasseringen
            if (!swapped) break;
        }
    }

    String algorithmName() {
        return "bubble";
    }
}