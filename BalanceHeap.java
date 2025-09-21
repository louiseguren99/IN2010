import java.util.*;

public class BalanceHeap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 

        while (scanner.hasNextInt()) pq.add(scanner.nextInt());

        balanceHeap(pq); 
    }

    // skriver rekkefølgen som gir helt balansert BST ved vanlig innsetting
    static void balanceHeap(PriorityQueue<Integer> Q) {
        if (Q.isEmpty()){
            return;
        }
        PriorityQueue<Integer> left = new PriorityQueue<>(); // nedre/venstre halvdel
        
        int k = Q.size() / 2;
        for (int i = 0; i < k; i++){
            left.add(Q.poll());  // flytt k første elementer i Q til left
        }
        Integer mid = Q.poll(); // median
        if (mid == null){ 
            return;  
        }                                
        System.out.println(mid);

        balanceHeap(left); 
        balanceHeap(Q); 
    }
}